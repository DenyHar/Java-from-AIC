package org.example.pwt_lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "minMaxAverageServlet", value = "/min-max-average-servlet")
public class MinMaxAverageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
        int number3 = Integer.parseInt(request.getParameter("number3"));
        String choice = request.getParameter("choice");
        out.println("<html><body>");
        switch (choice) {
            case "min":
                out.println("<h1>Найменше число з введених: " + Math.min(number1, Math.min(number2, number3)) + "</h1>");
                break;
            case "max":
                out.println("<h1>Найбільше число з введених: " + Math.max(number1, Math.max(number2, number3)) + "</h1>");
                break;
            case "avg":
                out.println("<h1>Середнє арифметичне з введених чисел: " + (number1 + number2 + number3)/3 + "</h1>");
        }
        out.println("<br/><br/>\n" +
                "<a href=\"index.jsp\">Повернутись на головну</a>");
        out.println("</body></html>");

        out.close();
    }
    @Override
    public void destroy() {
    }
}
