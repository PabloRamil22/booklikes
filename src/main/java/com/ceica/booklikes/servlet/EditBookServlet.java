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
        User user = (User) request.getSession().getAttribute("user");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String autor = request.getParameter("autor");
        booklikeController.createBook(titulo,descripcion,autor,user);
        List<Book> bookList = booklikeController.getallBook();
        request.setAttribute("listaLibros", bookList );
        response.sendRedirect("user");
    }
}
