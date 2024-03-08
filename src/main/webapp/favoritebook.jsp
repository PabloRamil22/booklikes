<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06/03/2024
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorites Book</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<a href="user"><p>${name}</p></a>

<table>
    <tr>
        <th> Id</th>
        <th>Título</th>
        <th>Autor</th>
        <th>Favoritos</th>
        <th></th>
    </tr>
    <tbody id="tableTask">
    <c:forEach items="${favoritebook}" var="libro">
    <tr>
        <td><c:out value="${libro.idlibro}"/></td>
        <td><c:out value="${libro.titulo}"/></td>
        <td><c:out value="${libro.autor}"/></td>
        <td id="fav${libro.idlibro}"><c:out value="${libro.favoritos}"/></td>
        <td><i onclick="favorito(${libro.idlibro})" class="fa-solid fa-heart"></i></td>

    </tr>
    </c:forEach>
    </tbody>
</table>

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
</script>
</body>
</html>
