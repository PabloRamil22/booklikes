package com.ceica.booklikes;

import java.io.*;

import com.ceica.booklikes.controller.booklikeController;
import com.ceica.booklikes.models.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //booklikeController booklikeController = new booklikeController();
        //booklikeController.createUser( 5, "Pepe", "123456");



        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}