package com.ceica.booklikes.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LibrosDTO {
    private int id;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;
    private String autor;

    private int favoritos;
    private String descripcion;

    public String getTitulo() {
        return titulo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int favoritos) {
        this.favoritos = favoritos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @WebServlet(name= "loginServlet" , value= "/login" )

    public static class loginServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            User user= (User) request.getSession().getAttribute("usuarios");
            if (user == null) {
                // Si el usuario no está en la sesión, redirigir al formulario de inicio de sesión
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                // Si el usuario está en la sesión, verificar si es un usuario válido
                if ("usuarios".equals(user.getNombre())) {
                    // Si es un usuario válido, redirigir a la página de usuarios
                    response.sendRedirect("user.jsp");
                } else {
                    // Si no es un usuario válido, redirigir al formulario de inicio de sesión
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String user=request.getParameter("name");
            String pass=request.getParameter("password");
            booklikeController booklikeController=new booklikeController();
            if (booklikeController.login(user,pass)){
                HttpSession session= request.getSession();
                session.setAttribute("usuarios", booklikeController.userLogged);
                response.sendRedirect("user");

            }else{
                request.setAttribute("mensaje", "Usuario o Password incorrecto");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }


        }
}