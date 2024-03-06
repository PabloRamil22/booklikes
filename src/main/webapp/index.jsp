<%@ page import="com.ceica.booklikes.models.ModeloBase" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%
  ModeloBase modeloBase = new ModeloBase() {
    @Override
    protected String getNombreTabla() {
      return null;
    }
  };
  modeloBase.getConnection();
%>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello">Hello Servlet</a>
</body>
</html>