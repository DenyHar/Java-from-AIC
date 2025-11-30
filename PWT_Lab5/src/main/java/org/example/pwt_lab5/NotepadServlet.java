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
                    System.out.println("I`m doing insert");
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
                    System.out.println("Yes, i'm trying to update");
                    updateNotepad(request, response);
                    break;
                case "/delete":
                    deleteNotepad(request, response);
                    break;
                case "/list":
                    listNotepads(request, response);
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
        CoverType cover = CoverType.valueOf(request.getParameter("cover"));
        String country = request.getParameter("country");
        int circulation = Integer.parseInt(request.getParameter("circulation"));
        PageType page = PageType.valueOf(request.getParameter("page"));
        Notepad notepad = new Notepad(publisher, name, pages, cover, country, circulation, page);
        notepadDao.save(notepad);
        response.sendRedirect("list");
    }
    private void updateNotepad(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String publisher = request.getParameter("publisher");
        String name = request.getParameter("name");
        int pages =  Integer.parseInt(request.getParameter("pages"));
        CoverType cover = CoverType.valueOf(request.getParameter("cover"));
        String country = request.getParameter("country");
        int circulation = Integer.parseInt(request.getParameter("circulation"));
        PageType page = PageType.valueOf(request.getParameter("page"));
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
}
