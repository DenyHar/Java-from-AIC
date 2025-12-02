package org.example.pwt_lab5;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "NotepadServlet", value = "/")
public class NotepadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NotepadDao notepadDao;

    @Override
    public void init() throws ServletException {
        notepadDao = new NotepadDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/":
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertNotepad(request, response);
                    break;
                case "/idDel":
                    request.setAttribute("command", "delete");
                    getId(request, response);
                    break;
                case "/idEdit":
                    request.setAttribute("command", "edit");
                    getId(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateNotepad(request, response);
                    break;
                case "/delete":
                    deleteNotepad(request, response);
                    break;
                case "/list":
                    listNotepads(request, response);
                    break;
                case "/productionCountry":
                    request.setAttribute("command", "Country");
                    listProductionByCountry(request, response);
                    break;
                case "/productionPublisher":
                    request.setAttribute("command", "Publisher");
                    listProductionByPublisher(request, response);
                    break;
                case "/topProductionCountry":
                    listProductionTopCountry(request, response);
                    break;
                case "/topProductionPublisher":
                    listProductionTopPublisher(request, response);
                    break;
                case "/bottomProductionCountry":
                    listProductionBottomCountry(request, response);
                    break;
                case "/bottomProductionPublisher":
                    listProductionBottomPublisher(request, response);
                    break;
                case "/hardNotepads":
                    listHardNotepads(request, response);
                    break;
                case "/softNotepads":
                    listSoftNotepads(request, response);
                    break;
                case "/country":
                    getCountry(request, response);
                    break;
                case "/countryList":
                    listByCountry(request, response);
                    break;
                case "/filteredPageType":
                    listFilteredByPageType(request, response);
                    break;
                case "/filteredByPages":
                    listFilteredByPages(request, response);
                    break;
                case "/filteredByCirculation":
                    listFilteredByCirculation(request, response);
                    break;
            }
        }  catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    private void listNotepads(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Notepad> notepads = notepadDao.getAllNotepad();
        request.setAttribute("notepads", notepads);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listProductionByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> productions = notepadDao.getCirculationByCountry();
        request.setAttribute("production", productions);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listProductionByPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> productions = notepadDao.getCirculationByPublisher();
        request.setAttribute("production", productions);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listProductionTopCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> productions = notepadDao.getCirculationTopCountry();
        request.setAttribute("production", productions);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listProductionTopPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> productions = notepadDao.getCirculationTopPublisher();
        request.setAttribute("production", productions);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listProductionBottomCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> productions = notepadDao.getCirculationBottomCountry();
        request.setAttribute("production", productions);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listProductionBottomPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> productions = notepadDao.getCirculationBottomPublisher();
        request.setAttribute("production", productions);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listHardNotepads(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> notepads = notepadDao.getAllHardCover();
        request.setAttribute("notepads", notepads);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void listSoftNotepads(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Object[]> notepads = notepadDao.getAllSoftCover();
        request.setAttribute("notepads", notepads);
        RequestDispatcher rd = request.getRequestDispatcher("notepad-list.jsp");
        rd.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("notepad-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Notepad notepad = notepadDao.getNotepad(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("notepad-form.jsp");
        request.setAttribute("notepad", notepad);
        requestDispatcher.forward(request, response);
    }
    private void insertNotepad(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String publisher = request.getParameter("publisher");
        String name = request.getParameter("name");
        int pages =  Integer.parseInt(request.getParameter("pages"));
        String cover = request.getParameter("cover");
        String country = request.getParameter("country");
        int circulation = Integer.parseInt(request.getParameter("circulation"));
        String page = request.getParameter("page");
        Notepad notepad = new Notepad(publisher, name, pages, cover, country, circulation, page);
        notepadDao.save(notepad);
        response.sendRedirect("list");
    }
    private void updateNotepad(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String publisher = request.getParameter("publisher");
        String name = request.getParameter("name");
        int pages =  Integer.parseInt(request.getParameter("pages"));
        String cover = request.getParameter("cover");
        String country = request.getParameter("country");
        int circulation = Integer.parseInt(request.getParameter("circulation"));
        String page = request.getParameter("page");
        Notepad notepad = new Notepad(id, publisher, name, pages, cover, country, circulation, page);
        notepadDao.update(notepad);
        response.sendRedirect("list");
    }
    private void deleteNotepad(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        notepadDao.delete(id);
        response.sendRedirect("list");
    }
    private void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("id-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void getCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("country-form.jsp");
        requestDispatcher.forward(request, response);
    }
    private void listByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String country = request.getParameter("country");
        List<Notepad> notepads = notepadDao.getAllByCountry(country);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("notepad-list.jsp");
        request.setAttribute("notepads", notepads);
        requestDispatcher.forward(request, response);
    }
    private void listFilteredByPageType(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        //String pageType = request.getParameter("pageType");
        String pageType = "Line";
        List<Notepad> notepads = notepadDao.getFilteredByPageType(pageType);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("notepad-list.jsp");
        request.setAttribute("notepads", notepads);
        requestDispatcher.forward(request, response);
    }
    private void listFilteredByPages(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        //int pageType = request.getParameter("pages");
        int pages = 15;
        List<Notepad> notepads = notepadDao.getFilteredByPages(pages);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("notepad-list.jsp");
        request.setAttribute("notepads", notepads);
        requestDispatcher.forward(request, response);
    }
    private void listFilteredByCirculation(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        //long pageType = request.getParameter("pages");
        long circulation = 200000;
        List<Notepad> notepads = notepadDao.getFilteredByCirculation(circulation);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("notepad-list.jsp");
        request.setAttribute("notepads", notepads);
        requestDispatcher.forward(request, response);
    }
}
