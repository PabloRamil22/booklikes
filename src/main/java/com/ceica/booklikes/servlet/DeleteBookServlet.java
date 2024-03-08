package com.ceica.booklikes.servlet;

import com.ceica.booklikes.controller.booklikeController;
import com.ceica.booklikes.models.Book;
import com.ceica.booklikes.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name= "DeleteBookServlet" , value= "/deletebookservlet" )
public class DeleteBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        booklikeController booklikeController = new booklikeController();

        String idLibro = request.getParameter("idLibro");

        booklikeController.deleteBook(Integer.parseInt(idLibro));

        response.sendRedirect("user");
    }
}


