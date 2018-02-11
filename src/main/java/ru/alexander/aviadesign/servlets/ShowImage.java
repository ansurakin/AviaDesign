package ru.alexander.aviadesign.servlets;

import ru.alexander.aviadesign.controllers.SearchFlightController;
import ru.alexander.aviadesign.objects.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet(name = "ShowImage",
urlPatterns = {"/ShowImage"})
public class ShowImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        try {
            int index = Integer.valueOf(request.getParameter("index"));
            SearchFlightController searchFlightController = (SearchFlightController) request.getSession(false).getAttribute("searchFlightController");
            byte[] image = ((Flight)searchFlightController.getFlights().get(index)).getAircraft().getCompany().getIcon();
            response.setContentLength(image.length);
            out.write(image);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }

    }
}
