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
@WebServlet(name= "EditBookServlet" , value= "/editbookservlet" )
public class EditBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        booklikeController booklikeController = new booklikeController();

        // Obtén el ID, el título y la nueva descripción del libro desde los parámetros de la solicitud
        String idLibro = request.getParameter("idLibro");
        String titulo = request.getParameter("titulo");
        String nuevaDescripcion = request.getParameter("nuevaDescripcion");

        // Lógica para actualizar la descripción del libro
       booklikeController.updateDescriptionBook(nuevaDescripcion, titulo);
            response.sendRedirect("user");

    }
}