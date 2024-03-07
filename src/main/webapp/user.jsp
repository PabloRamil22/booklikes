<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 06/03/2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vista de Usuario Logeado de BookLikes</title>
    <link rel="stylesheet" href="assets/ccs/css3.css">
</head>
<body>
<div class="container">
    <div>
        <img src="assets/images/booklikes.jpg" alt="">
    </div>
    <div>
        <table>
            <tr>
                <th> Id</th>
                <th>Título</th>
                <th>Descripción</th>
                <th>Autor</th>
                <th>Favoritos</th>
            </tr>
            <tbody id="tableTask">
            <c:choose>
                <c:when test="${empty listaLibros}">
                    <tr>
                        <td colspan="3">No hay Libros .</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${listaLibros}" var="libro">
                        <tr>
                            <td><c:out value="${libro.idLibro}"/></td>
                            <td><c:out value="${libro.titulo}"/></td>
                            <td><c:out value="${libro.descripcion}"/></td>
                            <td><c:out value="${libro.autor}"/></td>


                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
    <div>
        <form action="AgregarLibroServlet" method="post">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required>

            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion" required></textarea>

            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" required>

            <label for="favoritos">Favoritos:</label>
            <input type="text" id="favoritos" name="favoritos" required>

            <button type="submit">Agregar Libro</button>
        </form>
    </div>

    <c:forEach items="${listaLibros}" var="libro">
    <tr>
        <td><c:out value="${libro.idLibro}"/></td>
        <td><c:out value="${libro.titulo}"/></td>
        <td><c:out value="${libro.descripcion}"/></td
        <td><c:out value="${libro.autor}"/></td>

        <td>
            <form action="EditarLibroServlet" method="post">
                <input type="hidden" name="id" value="${libro.idLibro}">
                <button type="submit">Editar</button>
            </form>
        </td>
    </tr>
    </c:forEach>

</body>
</html>
