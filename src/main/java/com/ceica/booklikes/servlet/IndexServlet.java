package com.ceica.booklikes.servlet;

import java.io.*;
import java.util.List;

import com.ceica.booklikes.controller.booklikeController;
import com.ceica.booklikes.dto.BookDto;
import com.ceica.booklikes.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "")
public class IndexServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



        booklikeController booklikeController = new booklikeController();
        List<BookDto> bookDtoList=booklikeController.getallFavoriteBook();
        request.setAttribute("listaLibros",bookDtoList);
        request.getRequestDispatcher("index.jsp").forward(request,response);







    }

    public void destroy() {
    }
}