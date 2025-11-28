package org.example.pwt_lab4.News;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pwt_lab4.News.New;
import org.example.pwt_lab4.News.News;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewsServlet", value = "/news-servlet")
public class NewsServlet extends HttpServlet {
    private final List<New> news = new ArrayList<New>();

    @Override
    public void init() throws ServletException {
        ArrayList<String> urls1 =  new ArrayList();
        urls1.add("pics/New1_1.png");
        urls1.add("pics/New1_2.png");
        this.news.add(new New("HP Inc. Reports Fiscal 2025 Full Year and Fourth Quarter Results",
                "25 November 2025",
                "PALO ALTO, Calif. – Nov. 25, 2025 (GLOBE NEWSWIRE) – HP (NYSE: HPQ)<br>" +
                        "<br>" +
                        "Fiscal 2025 GAAP diluted net earnings per share (\"EPS\") of $2.65, down 5.7% from the prior year period<br>" +
                        "Fiscal 2025 non-GAAP diluted net EPS of $3.12, down 9.0% from the prior year period<br>" +
                        "Fiscal 2025 net revenue of $55.3 billion, up 3.2% from the prior-year period<br>" +
                        "Fiscal 2025 net cash provided by operating activities of $3.7 billion, free cash flow of $2.9 billion<br>" +
                        "Fiscal 2025 returned $1.9 billion to shareholders in the form of dividend and share repurchases <br>" +
                        "Fourth quarter GAAP diluted net EPS of $0.84, down 9.7% from the prior year period<br>" +
                        "Fourth quarter non-GAAP diluted net EPS of $0.93, down 3.1% from the prior year period <br>" +
                        "Fourth quarter net revenue of $14.6 billion, up 4.2% from the prior-year period<br>" +
                        "Fourth quarter net cash provided by operating activities of $1.6 billion, free cash flow of $1.5 billion<br>" +
                        "Fourth quarter returned $0.8 billion to shareholders in the form of dividend and share repurchases<br>" +
                        "HP Inc. increases quarterly dividend to $0.30 per share<br>" +
                        "HP Inc. announces company-wide initiative, estimates gross run rate cost savings of approximately $1 billion by the end of fiscal 2028, and restructuring and other charges of approximately $650 million ",
                urls1));

        ArrayList<String> urls2 =  new ArrayList();
        urls2.add("pics/New2_1.png");
        this.news.add(new New("HP Elevates Hybrid Work Experiences with Microsoft Device Ecosystem Platform Integration",
                "18 November 2025",
                "HP today announced plans to integrate the Microsoft Device Ecosystem Platform (MDEP) into Poly video conferencing solutions, IP phones, room controllers, and scheduling displays. This integration will enable more consistent Microsoft Teams experiences, improved security, and simplified management for IT.<br>" +
                        " <br>" +
                        "By leveraging MDEP, HP aims to accelerate innovation and streamline certification while simplifying device development and lifecycle management for IT. Customers can expect the same premium audio and video quality, intuitive controls, and enterprise-grade reliability they trust from HP - now with deeper integration with Microsoft Teams and services enabled on HP’s trusted hardware. Together, HP and Microsoft are delivering smarter, more connected meeting experiences that support productivity, inclusivity, and flexibility in today’s dynamic workplace. \n" +
                        " <br>" +
                        "This announcement reinforces HP’s long-standing partnership with Microsoft to shape modern meeting experiences across Microsoft Teams Rooms on Windows and Android. Over multiple platform generations, HP has introduced category-defining room systems, becoming one of the first partners to launch Teams Rooms on Windows and the first to bring Teams on Android to market through the Poly Studio X portfolio. This collaboration reflects a shared commitment to delivering smarter, more intuitive meeting solutions for today’s hybrid workforce. ",
                urls2));

        ArrayList<String> urls3 =  new ArrayList();
        urls3.add("pics/New3_1.png");
        this.news.add(new New("HP Drives Additive Manufacturing Adoption Through Portfolio Expansion, New Material Innovations and Global Collaborations at Formnext 2025",
                "18 November 2025",
                "News Highlights:<br>" +
                        "HP drives innovation in additive manufacturing, announcing upcoming advancements across its portfolio designed to reduce cost per part by 2026, along with the general availability of HP 3D HR PA 11 Gen2.<br>" +
                        "HP simplifies adoption and scales industrial production through the new HP Additive Manufacturing Network (AMN) Program, connecting parts demand with HP’s partner network.<br>" +
                        "HP advances Metal Jet materials innovation through collaborations with Continuum Powders and GKN Additive.<br>" +
                        "HP expands its industrial portfolio with HP Industrial Filament 3D Printer Solutions, introducing the HP Industrial Filament 3D Printer 600 High Temperature (HP IF 600HT) for demanding applications.<br>" +
                        "HP and Würth Additive Group launch a digital production collaboration enabling digital inventory for producing on-demand, localized parts.",
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
            if(!News.writeInfoOne(out, this.news, id, "news-servlet"))
                response.sendRedirect("news-servlet");
        }
        else
            News.writeInfo(out, news, "news-servlet");

        writeEnd(out);
    }
    private void writeStart(PrintWriter out)
    {
        out.println("<html><head>" +
                "<title>News</title>" +
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
                "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"news-servlet\">Recent news</a>" +
                "                    </li>" +
                "                    <li class=\"nav-item\">" +
                "                        <a class=\"nav-link\" href=\"laptops-servlet\">Models</a>" +
                "                    </li>" +
                "                    <li class=\"nav-item\">" +
                "                        <a class=\"nav-link\" href=\"index.jsp\">Index</a>" +
                "                    </li>" +
                "                </ul>" +
                "            </div>" +
                "        </div>" +
                "    </nav>");
        out.println("<h1 style=\"text-align: center; margin: 10px 0;\">News</h1>");
    }

    private void writeEnd(PrintWriter out)
    {
        out.println("</body></html>");
    }
}
