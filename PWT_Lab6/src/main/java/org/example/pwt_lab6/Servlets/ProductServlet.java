package org.example.pwt_lab6.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pwt_lab6.Classes.Buyer;
import org.example.pwt_lab6.Classes.Product;
import org.example.pwt_lab6.DAOs.ProductDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns  = {"/product","/product/list","/product/new","/product/insert","/product/idDel","/product/idEdit","/product/edit","/product/update","/product/delete","/product/top"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        productDao = new ProductDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/product":
                case "/product/new":
                    showNewForm(request, response);
                    break;
                case "/product/insert":
                    insertProduct(request, response);
                    break;
                case "/product/idDel":
                    request.setAttribute("command", "delete");
                    getId(request, response);
                    break;
                case "/product/idEdit":
                    request.setAttribute("command", "edit");
                    getId(request, response);
                    break;
                case "/product/edit":
                    showEditForm(request, response);
                    break;
                case "/product/update":
                    updateProduct(request, response);
                    break;
                case "/product/delete":
                    deleteProduct(request, response);
                    break;
                case "/product/list":
                    listProducts(request, response);
                    break;
                case "/product/top":
                    topProduct(request, response);
                    break;
            }
        }  catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Product> products = productDao.getAllProduct();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("product-list.jsp");
        rd.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Product product = productDao.getProduct(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-form.jsp");
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }
    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(name, price);
        productDao.save(product);
        response.sendRedirect("list");
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id, name, price);;
        productDao.update(product);
        response.sendRedirect("list");
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        productDao.delete(id);
        response.sendRedirect("list");
    }
    private void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("id-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void topProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Product> products = productDao.getTopProduct();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("product-list.jsp");
        rd.forward(request, response);
    }
}
