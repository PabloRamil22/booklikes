<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 04/03/2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Listado de Libros de BookLikes</title>
    <link rel="stylesheet" href="assets/ccs/css3.css">
</head>
<body>
<div class="container">
    <div>
        <img src="assets/images/booklikes.jpg" alt="">
    </div>
    <div>
        <!-- Enlace para ir a la vista de inicio de sesión -->
        <a href="login" class="button button-block">Iniciar Sesión</a>
        <!-- Enlace para ir a la vista de registro -->
        <a href="register" class="button button-block">Registrar</a>
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
                            <td><c:out value="${libro.id}"/></td>
                            <td><c:out value="${libro.titulo}"/></td>
                            <td><c:out value="${libro.descripcion}"/></td>
                            <td><c:out value="${libro.autor}"/></td>
                            <td><c:out value="${libro.favoritos}"/></td>

                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>