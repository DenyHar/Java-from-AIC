package org.example.pwt_lab4.Laptops;

import java.io.PrintWriter;
import java.util.List;

public class Laptops {
    public static void writeInfo(PrintWriter out, List<Laptop> laptops, String redirect_url)
    {
        out.println("<div class=\"container-fluid\">");
        out.println("<div class=\"row row-cols-3 row-cols-md-3 g-4\">");
        int counter = 0;
        for(Laptop h: laptops)
        {
            out.println("<div class=\"col\">");
            out.println("<div class=\"card h-100\">" +
                    "  <img src=\"" + h.getPhoto_urls().getFirst() + "\" class=\"card-img-top\">" +
                    "  <div class=\"card-body\">" +
                    "    <h5 class=\"card-title\">" + h.getName() + "</h5>" +
                    "    <p class=\"card-text\">" + h.getDescription() + "</p>" +
                    "    <a href=\"" + redirect_url + "?id=" + counter + "\" class=\"btn btn-dark\">Show more</a>" +
                    "  </div>" +
                    "</div>");
            out.println("</div>");
            counter++;
        }
        out.println("</div>");
        out.println("</div>");
    }

    public static boolean writeInfoOne(PrintWriter out, List<Laptop> laptops, int id, String back_url)
    {
        if(id < 0 || id >= laptops.size())
            return false;
        Laptop l = null;
        for (int i = 0; i < laptops.size(); i++)
        {
            if(i == id)
            {
                l = laptops.get(i);
                break;
            }
        }
        if(l == null)
            return false;

        out.println("<div class=\"container-fluid\">");

        out.println("<div class=\"row mt-2\">");
        out.println("<h1>" + l.getName() + "</h1>");
        out.println("<p><b>CPU:</b> " + l.getCpu() + "</p>");
        out.println("<p><b>RAM: </b>" + l.getRam() + "</p>");
        out.println("<p><b>Storage: </b>" + l.getStorage() + "</p>");
        out.println("<p><b>Description:</b><br>" + l.getDescription() + "</p>");
        out.println("</div>");

        out.println("<div class=\"row mt-2\">");
        for(String url: l.getPhoto_urls())
        {
            out.println("<div class=\"col-4\">\n" +
                    "       <img src=\"" + url + "\" class=\"img-fluid\">\n" +
                    "   </div>");
        }
        out.println("</div>");

        out.println("<div class=\"row mt-2\">");
        out.println("<div class=\"col-2\">");
        out.println("<a href=\"" + back_url + "\" class=\"btn btn-dark\">Go back</a>");
        out.println("</div>");
        out.println("</div>");

        out.println("</div>");

        return true;
    }
}
