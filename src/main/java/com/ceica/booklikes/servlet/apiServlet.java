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
import java.io.PrintWriter;
import java.util.List;

@WebServlet (name= "apiServlet" , value= "/api" )
public class apiServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
       int idlibro= Integer.parseInt(request.getParameter("idlibro"));
       booklikeController likeController=new booklikeController();
       likeController.userLogged=user;
       int favoritos=likeController.createFavoriteBook(idlibro,user.getIdusuario());
        PrintWriter out =response.getWriter();
        String msg="{\"fav\":\""+favoritos+"\"}";
        out.write(msg);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}

