package org.example.pwt_lab4.Laptops;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LaptopsServlet", value = "/laptops-servlet")
public class LaptopServlet extends HttpServlet {
    private final List<Laptop> laptops = new ArrayList<Laptop>();

    @Override
    public void init() throws ServletException {
        ArrayList<String> urls1 =  new ArrayList();
        urls1.add("pics/D06H4EA1.png");
        urls1.add("pics/D06H4EA2.png");
        urls1.add("pics/D06H4EA3.png");
        this.laptops.add(new Laptop("HP Laptop 15-fc0316ua (D06H4EA)",
                "Завдяки досконалому балансу потужності та продуктивності ноутбук HP з діагоналлю екрана 15,6 дюйма чудово підходить для потокової передачі даних, підключення та керування списками справ.",
                "AMD Ryzen™ 5 7520U",
                "16 Гб LPDDR5",
                "512 Гб твердотілий накопичувач (SSD)",
                urls1));

        ArrayList<String> urls2 =  new ArrayList();
        urls2.add("pics/D06H6EA1.png");
        urls2.add("pics/D06H6EA2.png");
        urls2.add("pics/D06H6EA3.png");
        this.laptops.add(new Laptop("HP Laptop 15-fc0318ua (D06H6EA)",
                "Завдяки досконалому балансу потужності та продуктивності ноутбук HP з діагоналлю екрана 15,6 дюйма чудово підходить для потокової передачі даних, підключення та керування списками справ.",
                "AMD Ryzen™ 7 7730U",
                "16 Гб DDR4",
                "512 Гб твердотілий накопичувач (SSD)",
                urls2));

        ArrayList<String> urls3 =  new ArrayList();
        urls3.add("pics/D06HFEA1.png");
        urls3.add("pics/D06HFEA2.png");
        urls3.add("pics/D06HFEA3.png");
        this.laptops.add(new Laptop("HP Laptop 17-cp2043ua (D06HFEA)",
                "Завдяки дисплею із високою роздільною здатністю та корпусу із вмістом океанічного пластику цей 17,3-дюймовий ноутбук HP створено з думкою про вас і нашу планету.",
                "AMD Ryzen™ 3 7320U",
                "8 Гб LPDDR5",
                "512 Гб твердотілий накопичувач (SSD)",
                urls3));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        writeStart(out);
        if(request.getParameterMap().containsKey("id"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            if(!Laptops.writeInfoOne(out, this.laptops, id, "laptops-servlet"))
                response.sendRedirect("laptops-servlet");
        }
        else
            Laptops.writeInfo(out, laptops, "laptops-servlet");

        writeEnd(out);
    }
    private void writeStart(PrintWriter out)
    {
        out.println("<html><head>" +
                "<title>Models</title>" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">" +
                "<style>" +
                "   body {" +
                "       font-family: \"Segoe UI\", serif;" +
                "   }" +
                "</style>" +
                "</head><body>");
        out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">" +
                "        <div class=\"container-fluid\">" +
                "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">" +
                "                <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">" +
                "                    <li class=\"nav-item\">" +
                "                        <a class=\"nav-link\" href=\"Company.jsp\">General info</a>" +
                "                    </li>" +
                "                    <li class=\"nav-item\">" +
                "                        <a class=\"nav-link\" href=\"news-servlet\">Recent news</a>" +
                "                    </li>" +
                "                    <li class=\"nav-item\">" +
                "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"laptops-servlet\">Models</a>" +
                "                    </li>" +
                "                    <li class=\"nav-item\">" +
                "                        <a class=\"nav-link\" href=\"index.jsp\">Index</a>" +
                "                    </li>" +
                "                </ul>" +
                "            </div>" +
                "        </div>" +
                "    </nav>");
        out.println("<h1 style=\"text-align: center; margin: 10px 0;\">Models</h1>");
    }

    private void writeEnd(PrintWriter out)
    {
        out.println("</body></html>");
    }
}
