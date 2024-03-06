package com.ceica.booklikes.servlet;

import com.ceica.booklikes.controller.booklikeController;
import com.ceica.booklikes.dto.BookDto;
import com.ceica.booklikes.models.Book;
import com.ceica.booklikes.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name= "favoritebookServlet" , value= "/favoritebook" )

public class favoritebookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user = (User) request.getSession().getAttribute("favoritebook");
        if (user == null) {
            response.sendRedirect("login");
        } else {

            booklikeController booklikeController=new booklikeController();
            booklikeController.userLogged=user;
            List<BookDto> bookDtoList=booklikeController.getallFavoriteBook();
            request.setAttribute("name",user.getNombre());
            request.setAttribute("favoritebook", bookDtoList );
            request.getRequestDispatcher("favoritebook.jsp").forward(request,response);


        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    }
