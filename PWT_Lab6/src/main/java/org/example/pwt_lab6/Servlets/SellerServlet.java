package org.example.pwt_lab6.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pwt_lab6.Classes.Seller;
import org.example.pwt_lab6.DAOs.SellerDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SellerServlet", urlPatterns  = {"/seller","/seller/list","/seller/new",
        "/seller/insert","/seller/idDel","/seller/idEdit","/seller/edit","/seller/update",
        "/seller/delete","/seller/top"})
public class SellerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SellerDao sellerDao;

    @Override
    public void init() throws ServletException {
        sellerDao = new SellerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/seller":
                case "/seller/list":
                    listSellers(request, response);
                    break;
                case "/seller/new":
                    showNewForm(request, response);
                    break;
                case "/seller/insert":
                    insertSeller(request, response);
                    break;
                case "/seller/idDel":
                    request.setAttribute("command", "delete");
                    getId(request, response);
                    break;
                case "/seller/idEdit":
                    request.setAttribute("command", "edit");
                    getId(request, response);
                    break;
                case "/seller/edit":
                    showEditForm(request, response);
                    break;
                case "/seller/update":
                    updateSeller(request, response);
                    break;
                case "/seller/delete":
                    deleteSeller(request, response);
                    break;
                case "/seller/top":
                    topSeller(request, response);
                    break;
            }
        }  catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    private void listSellers(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Seller> sellers = sellerDao.getAllSeller();
        request.setAttribute("sellers", sellers);
        RequestDispatcher rd = request.getRequestDispatcher("seller-list.jsp");
        rd.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("seller-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Seller seller = sellerDao.getSeller(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("seller-form.jsp");
        request.setAttribute("seller", seller);
        requestDispatcher.forward(request, response);
    }
    private void insertSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Seller seller = Seller.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).build();
        sellerDao.save(seller);
        response.sendRedirect("list");
    }
    private void updateSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Seller seller = Seller.builder().id(id).firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).build();
        sellerDao.update(seller);
        response.sendRedirect("list");
    }
    private void deleteSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        sellerDao.delete(id);
        response.sendRedirect("list");
    }
    private void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("id-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void topSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Seller> sellers = sellerDao.getTopSeller();
        request.setAttribute("sellers", sellers);
        RequestDispatcher rd = request.getRequestDispatcher("seller-list.jsp");
        rd.forward(request, response);
    }
}
