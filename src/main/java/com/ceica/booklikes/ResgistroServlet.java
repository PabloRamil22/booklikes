package com.ceica.booklikes;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Aquí deberías realizar la lógica de registro, como almacenar los datos en una base de datos.

        // En este ejemplo, simplemente imprimimos los datos registrados.
        PrintWriter out = response.getWriter();
        out.println("Registro exitoso:");
        out.println("Nombres: " + nombres);
        out.println("Apellidos: " + apellidos);
        out.println("Email: " + email);
    }
}
