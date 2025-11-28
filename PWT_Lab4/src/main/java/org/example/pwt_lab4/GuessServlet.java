package org.example.pwt_lab4;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

enum state{LESS, UNKNOWN,EQUALS, GREATER}

@WebServlet(name="guessServlet", value="/guess-servlet")
public class GuessServlet extends HttpServlet {
    private int number;
    private int step;
    private state  state;
    private String question;
    private boolean answer;
    @Override
    public void init() throws ServletException {
        number = 50;
        step = 25;
        state = org.example.pwt_lab4.state.UNKNOWN;
        question = "Загадане число меньше за ";
        answer = false;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("/GuessingForm.jsp");
        answer = Boolean.parseBoolean(request.getParameter("answer")) ;
        if (step < 1){step = 1;}
        switch (state) {
            case  UNKNOWN:
                if (!answer) {
                    state = org.example.pwt_lab4.state.LESS;
                    question = "Загадане число меньше за ";
                } else if (answer) {
                    state = org.example.pwt_lab4.state.EQUALS;
                }
                break;
            case  LESS:
                if (!answer) {
                    state = org.example.pwt_lab4.state.GREATER;
                    question = "Загадане число більше за ";
                } else if (answer)  {
                    number -= step;
                    step /= 2;
                }
                break;
            case  GREATER:
                if (!answer) {
                    state = org.example.pwt_lab4.state.UNKNOWN;
                    question = "Загадане число це ";
                } else if (answer) {
                    state = org.example.pwt_lab4.state.LESS;
                    number += step;
                    step /= 2;
                    question = "Загадане число меньше за ";
                }
                break;
        }

        request.setAttribute("question", question);
        request.setAttribute("number", number);
        if (state != org.example.pwt_lab4.state.EQUALS) {rd.forward(request,response);}

        out.println("<h1>Ви загадали число " + number + "</h1>");
        out.println("<br/><br/>\n" +
                "<a href=\"index.jsp\">Повернутись на головну</a>");
        out.close();
        if(state == org.example.pwt_lab4.state.EQUALS){
                init();}
    }

    public void destroy()
    {
    }
}
