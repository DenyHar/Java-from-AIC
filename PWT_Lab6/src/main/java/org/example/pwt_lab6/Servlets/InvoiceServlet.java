package org.example.pwt_lab6.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pwt_lab6.Classes.Buyer;
import org.example.pwt_lab6.Classes.Invoice;
import org.example.pwt_lab6.Classes.Product;
import org.example.pwt_lab6.Classes.Seller;
import org.example.pwt_lab6.DAOs.BuyerDao;
import org.example.pwt_lab6.DAOs.InvoiceDao;
import org.example.pwt_lab6.DAOs.ProductDao;
import org.example.pwt_lab6.DAOs.SellerDao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "InvoiceServlet", urlPatterns  = {"/invoice","/invoice/list","/invoice/new",
        "/invoice/insert","/invoice/idDel","/invoice/idEdit","/invoice/edit","/invoice/update",
        "/invoice/delete","/invoice/date","/invoice/selectByDate","/invoice/idSeller","/invoice/selectBySeller",
        "/invoice/idBuyer","/invoice/selectByBuyer"})
public class InvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao invoiceDao;
    private ProductDao productDao;
    private SellerDao sellerDao;
    private BuyerDao buyerDao;

    @Override
    public void init() throws ServletException {
        invoiceDao = new InvoiceDao();
        productDao = new ProductDao();
        sellerDao = new SellerDao();
        buyerDao = new BuyerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/invoice":
                case "/invoice/new":
                    showNewForm(request, response);
                    break;
                case "/invoice/insert":
                    insertInvoice(request, response);
                    break;
                case "/invoice/idDel":
                    request.setAttribute("command", "delete");
                    getId(request, response);
                    break;
                case "/invoice/idEdit":
                    request.setAttribute("command", "edit");
                    getId(request, response);
                    break;
                case "/invoice/edit":
                    showEditForm(request, response);
                    break;
                case "/invoice/update":
                    updateInvoice(request, response);
                    break;
                case "/invoice/delete":
                    deleteInvoice(request, response);
                    break;
                case "/invoice/list":
                    listInvoices(request, response);
                    break;
                case "/invoice/date":
                    getDate(request, response);
                    break;
                case "/invoice/selectByDate":
                    selectByDate(request, response);
                    break;
                case "/invoice/idSeller":
                    request.setAttribute("command", "seller");
                    getId(request, response);
                    break;
                case "/invoice/selectBySeller":
                    selectBySeller(request, response);
                    break;
                case "/invoice/idBuyer":
                    request.setAttribute("command", "buyer");
                    getId(request, response);
                    break;
                case "/invoice/selectByBuyer":
                    selectByBuyer(request, response);
                    break;
            }
        }  catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    private void listInvoices(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Invoice> invoices = invoiceDao.getAllInvoice();
        request.setAttribute("invoices", invoices);
        RequestDispatcher rd = request.getRequestDispatcher("invoice-list.jsp");
        rd.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("invoice-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Invoice invoice = invoiceDao.getInvoice(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("invoice-form.jsp");
        request.setAttribute("invoice", invoice);
        requestDispatcher.forward(request, response);
    }
    private void insertInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long product_id = Long.parseLong(request.getParameter("product_id"));
        Product product = productDao.getProduct(product_id);
        long seller_id = Long.parseLong(request.getParameter("seller_id"));
        Seller seller = sellerDao.getSeller(seller_id);
        long buyer_id = Long.parseLong(request.getParameter("buyer_id"));
        Buyer buyer = buyerDao.getBuyer(buyer_id);
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        Invoice invoice = new Invoice(product, seller, buyer, date);
        invoiceDao.save(invoice);
        response.sendRedirect("list");
    }
    private void updateInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        long product_id = Long.parseLong(request.getParameter("product_id"));
        Product product = productDao.getProduct(product_id);
        long seller_id = Long.parseLong(request.getParameter("seller_id"));
        Seller seller = sellerDao.getSeller(seller_id);
        long buyer_id = Long.parseLong(request.getParameter("buyer_id"));
        Buyer buyer = buyerDao.getBuyer(buyer_id);
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        Invoice invoice = new Invoice(id, product, seller, buyer, date);
        invoice.getProduct().getId();
        invoiceDao.update(invoice);
        response.sendRedirect("list");
    }
    private void deleteInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        invoiceDao.delete(id);
        response.sendRedirect("list");
    }
    private void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("id-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void getDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("date-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void selectByDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Invoice> invoices = null;

        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        String choice = request.getParameter("choice");
        if (choice.equals("Exact")) {
            invoices = invoiceDao.getByDate(endDate);
        } else if (choice.equals("Interval")) {
            LocalDate beginDate = LocalDate.parse(request.getParameter("beginDate"));
            invoices = invoiceDao.getByDate(beginDate, endDate);
        }
        request.setAttribute("invoices", invoices);
        RequestDispatcher rd = request.getRequestDispatcher("invoice-list.jsp");
        rd.forward(request, response);
    }
    private void selectBySeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        List<Invoice> invoices = invoiceDao.getBySeller(id);
        request.setAttribute("invoices", invoices);
        RequestDispatcher rd = request.getRequestDispatcher("invoice-list.jsp");
        rd.forward(request, response);
    }
    private void selectByBuyer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        List<Invoice> invoices = invoiceDao.getByBuyer(id);
        request.setAttribute("invoices", invoices);
        RequestDispatcher rd = request.getRequestDispatcher("invoice-list.jsp");
        rd.forward(request, response);
    }
}
