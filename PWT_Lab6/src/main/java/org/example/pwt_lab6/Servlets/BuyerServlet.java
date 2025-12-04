package org.example.pwt_lab6.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pwt_lab6.Classes.Buyer;
import org.example.pwt_lab6.Classes.Seller;
import org.example.pwt_lab6.DAOs.BuyerDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BuyerServlet", urlPatterns  = {"/buyer","/buyer/list","/buyer/new","/buyer/insert","/buyer/idDel","/buyer/idEdit","/buyer/edit","/buyer/update","/buyer/delete", "/buyer/top"})
public class BuyerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BuyerDao buyerDao;

    @Override
    public void init() throws ServletException {
        buyerDao = new BuyerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("buyer action: " + action);
        try {
            switch (action) {
                case "/buyer":
                case "/buyer/list":
                    listBuyers(request, response);
                    break;
                case "/buyer/new":
                    showNewForm(request, response);
                    break;
                case "/buyer/insert":
                    insertBuyer(request, response);
                    break;
                case "/buyer/idDel":
                    request.setAttribute("command", "delete");
                    getId(request, response);
                    break;
                case "/buyer/idEdit":
                    request.setAttribute("command", "edit");
                    getId(request, response);
                    break;
                case "/buyer/edit":
                    showEditForm(request, response);
                    break;
                case "/buyer/update":
                    updateBuyer(request, response);
                    break;
                case "/buyer/delete":
                    deleteBuyer(request, response);
                    break;
                case "/buyer/top":
                    topBuyer(request, response);
                    break;
            }
        }  catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    private void listBuyers(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Buyer> buyers = buyerDao.getAllBuyer();
        request.setAttribute("buyers", buyers);
        RequestDispatcher rd = request.getRequestDispatcher("buyer-list.jsp");
        rd.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("buyer-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Buyer buyer = buyerDao.getBuyer(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("buyer-form.jsp");
        request.setAttribute("buyer", buyer);
        requestDispatcher.forward(request, response);
    }
    private void insertBuyer(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Buyer buyer = Buyer.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).build();
        buyerDao.save(buyer);
        response.sendRedirect("list");
    }
    private void updateBuyer(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Buyer buyer = Buyer.builder().id(id).firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).build();
        buyerDao.update(buyer);
        response.sendRedirect("list");
    }
    private void deleteBuyer(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        buyerDao.delete(id);
        response.sendRedirect("list");
    }
    private void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("id-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void topBuyer(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Buyer> buyers = buyerDao.getTopBuyer();
        request.setAttribute("buyers", buyers);
        RequestDispatcher rd = request.getRequestDispatcher("buyer-list.jsp");
        rd.forward(request, response);
    }
}
