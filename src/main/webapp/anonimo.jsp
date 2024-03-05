<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 05/03/2024
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vista Anónima</title>
    <link rel="stylesheet" href="assets/ccs/css3.css">
</head>
<body>
    <div>
        <img src="assets/images/booklikes.jpg" alt="">
    </div>
    <div>
        <!-- Enlace para ir a la vista de inicio de sesión -->
        <a href="assets/index.jsp" class="button button-block">Iniciar Sesión</a>
        <!-- Enlace para ir a la vista de registro -->
        <a href="assets/index.jsp" class="button button-block">Registrar</a>
    </div>
    <div>
        <h2>Lista de Libros</h2>
        <table border="1">
            <tr>
                <th>Más Buscados</th>
                <th>Favoritos del Mes</th>
            </tr>
            <tr>
                <td>
                    <strong>Título:</strong> Libro 1<br>
                    <strong>Usuario:</strong> Usuario1
                </td>
                <td>
                    <strong>Título:</strong> Libro 2<br>
                    <strong>Usuario:</strong> Usuario2
                </td>
            </tr>
            <!-- Puedes agregar más filas según sea necesario -->
        </table>
    </div>



</body>
</html>