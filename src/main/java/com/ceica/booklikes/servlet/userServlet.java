package com.ceica.booklikes.servlet;

import com.ceica.booklikes.controller.booklikeController;
import com.ceica.booklikes.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.util.List;

@WebServlet (name= "userServlet" , value= "/user" )
public class userServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("usuarios");
        if (user == null) {
            response.sendRedirect("user");
        } else {

            if (user.getNombre().equals("usuarios")) {
                request.setAttribute("nombre", user.getNombre());
                booklikeController booklikeController=new booklikeController();
                booklikeController.userLogged=user;
                List<User> userList=booklikeController.getallUser();
                request.setAttribute("nombre",user.getNombre());
                request.setAttribute("usuarios",userList);
                request.getRequestDispatcher("user.jsp").forward(request,response);

            } else {
                response.sendRedirect("user");
            }
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("usuarios");
        if (user == null) {
            response.sendRedirect("login");
        } else {
            booklikeController booklikeController=new booklikeController();
            booklikeController.userLogged=user;
            String nombre= request.getParameter("nombre");
            String password=request.getParameter("password");
            booklikeController.createUser(nombre,password);
            response.sendRedirect("usuarios");
        }
    }
}

