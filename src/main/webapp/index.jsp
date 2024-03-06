<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista de Libros</title>
0
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Lista de Libros</h1>
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
        <td><c:out value="${libro.autor}" /></td>
        <td><c:out value="${libro.favoritos}" /></td>

      </tr>
    </c:forEach>
  </c:otherwise>
</c:choose>
</tbody>

</table>



</body>
</html>