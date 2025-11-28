package org.example.pwt_lab4;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "tableServlet", value = "/table-servlet")
public class TableServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int number = Integer.parseInt(request.getParameter("number"));

        out.println("<p>" + number + " * 1 = " + number + "</p>");
        out.println("<p>" + number + " * 2 = " + number * 2 + "</p>");
        out.println("<p>" + number + " * 3 = " + number * 3 + "</p>");
        out.println("<p>" + number + " * 4 = " + number * 4 + "</p>");
        out.println("<p>" + number + " * 5 = " + number * 5 + "</p>");
        out.println("<p>" + number + " * 6 = " + number * 6 + "</p>");
        out.println("<p>" + number + " * 7 = " + number * 7 + "</p>");
        out.println("<p>" + number + " * 8 = " + number * 8 + "</p>");
        out.println("<p>" + number + " * 9 = " + number * 9 + "</p>");
        out.println("<br/><br/>\n" +
                "<a href=\"TableForm.jsp\">Повторити введення даних</a>");
        out.println("<br/><br/>\n" +
                "<a href=\"index.jsp\">Повернутись на головну</a>");
        out.close();
    }

    public void destroy()
    {
    }
}
