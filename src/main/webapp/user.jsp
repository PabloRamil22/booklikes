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
    <link rel="stylesheet" href="assets/ccs/userlogged.css">
</head>
<body>
<div class="container">
    <div>
     <a href="index.jsp"><img src="assets/images/booklikes.jpg" alt=""></a>
        <a href = "favoritebook">Libros Favoritos</a>
    </div>
    <div>
        <table>
            <tr>
                <th> Id</th>
                <th>Título</th>
                <th>Descripción</th>
                <th>Autor</th>
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
                            <td>
                                <form action="editbookservlet" method="post">
                                    <input type="hidden" name="idLibro" value="${libro.idLibro}">
                                    <input type="hidden" name="titulo" value="${libro.titulo}">
                                    <label for="nuevaDescripcion">Nueva Descripción:</label>
                                    <textarea id="nuevaDescripcion" name="nuevaDescripcion" required></textarea>
                                    <button class="edit" type="submit">Editar</button>
                                </form>
                            </td>
                            <td>

                                    <button onclick="borrar(${libro.idLibro})" type="button">Borrar</button>

                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
    <div>
        <form action="addbookservlet" method="post">

            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" required>
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required>

            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion" required></textarea>


            <button type="submit">Agregar Libro</button>
        </form>
    </div>
</div>
<script>

    function favorito(idLibro){
        var baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes_war/api?idlibro="+idLibro;

        fetch(baseUrl, {
            method: 'GET', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
            headers: {
                'Content-Type': 'application/json', // Puedes ajustar el tipo de contenido según tu necesidad
                //'Content-Type':'text',
            },
            // Puedes agregar otros parámetros como body si estás enviando datos
        })
            .then(response => response.json()) // Procesamos la respuesta como JSON
            .then(data => {
                let element="fav"+idLibro;
                document.getElementById(element).innerText=data.fav;
                console.log(data.fav); // Aquí puedes hacer lo que quieras con los datos



            })
            .catch(error => {
                console.error('Error:', error); // Manejamos los errores
            });
    }

    function borrar(idLibro){
        var baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes_war/api?borraridlibro="+idLibro;

        fetch(baseUrl, {
            method: 'GET', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
            headers: {
                'Content-Type': 'application/json', // Puedes ajustar el tipo de contenido según tu necesidad
                //'Content-Type':'text',
            },
            // Puedes agregar otros parámetros como body si estás enviando datos
        })
            .then(response => response.json()) // Procesamos la respuesta como JSON
            .then(data => {

                console.log(data); // Aquí puedes hacer lo que quieras con los datos
                location.reload();


            })
            .catch(error => {
                console.error('Error:', error); // Manejamos los errores
            });
    }
</script>
</body>
</html>
