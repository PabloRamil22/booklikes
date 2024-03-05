<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 04/03/2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Registro y Login</title>
        <link rel="stylesheet" href="assets/ccs/css3.css">
    </head>
    <body>
    <div>
        <img src="assets/images/booklikes.jpg" alt="">
    </div>

    <div class="form">
        <ul class="tab-group">
            <li class="tab active"><a href="javascript:void(0);" onclick="mostrarFormulario('signup')">Registro</a></li>
            <li class="tab"><a href="javascript:void(0);" onclick="mostrarFormulario('login')">Logearse</a></li>
        </ul>
        <div class="tab-content">
            <div id="signup" class="cont" style="display: block;">
                <!-- Formulario de Registro -->
                <form action="RegistroServlet" method="post">
                    <div class="top-row">
                        <div class="field-wrap">
                            <label>Nombres<span class="req">*</span></label>
                            <input type="text" name="nombres" required autocomplete="off" />
                        </div>
                        <div class="field-wrap">
                            <label>Apellidos<span class="req">*</span></label>
                            <input type="text" name="apellidos" required autocomplete="off" />
                        </div>
                    </div>
                    <div class="field-wrap">
                        <label>Dirección Email<span class="req">*</span></label>
                        <input type="email" name="email" required autocomplete="off" />
                    </div>
                    <div class="field-wrap">
                        <label>Crear Password<span class="req">*</span></label>
                        <input type="password" name="password" required autocomplete="off" />
                    </div>
                    <button type="submit" class="button button-block">Registrar</button>
                </form>
            </div>

            <div id="login" class="cont" style="display: none;">
                <!-- Formulario de Inicio de Sesión -->
                <form action="LoginServlet" method="post">
                    <div class="field-wrap">
                        <label>Dirección Email<span class="req">*</span></label>
                        <input type="email" name="email" required autocomplete="off" />
                    </div>
                    <div class="field-wrap">
                        <label>Password<span class="req">*</span></label>
                        <input type="password" name="password" required autocomplete="off" />
                    </div>
                    <button type="submit" class="button button-block">Iniciar Sesión</button>
                </form>
            </div>
        </div>
    </div>

    <script src="assets/js/blikes.js"></script>
    </body>
    </html>

