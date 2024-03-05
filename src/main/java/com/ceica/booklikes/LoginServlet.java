package com.ceica.booklikes;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Aquí deberías realizar la lógica de autenticación, como verificar los datos en una base de datos.

        // En este ejemplo, simplemente imprimimos un mensaje de éxito si el usuario y la contraseña son correctos.
        PrintWriter out = response.getWriter();
        if (autenticarUsuario(email, password)) {
            out.println("Inicio de sesión exitoso");
        } else {
            out.println("Inicio de sesión fallido. Verifica tus credenciales.");
        }
    }

    // Este método es solo un ejemplo. Debes implementar tu propia lógica de autenticación.
    private boolean autenticarUsuario(String email, String password) {
        // Aquí deberías verificar los datos en una base de datos.
        // Este método es solo un esquema y debe adaptarse a tu aplicación.
        // Además, considera el uso de algoritmos de hash y almacenamiento seguro para contraseñas.
        return "usuario@dominio.com".equals(email) && "contrasena123".equals(password);
    }
}
