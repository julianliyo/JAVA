<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Crea tu libro</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
	<span class="d-flex justify-content-end m-2"><a href="/dashboard">Dashboard</a></span>
	<div class="in-line">
		<h2>Top 10 canciones</h2>
	</div>
	<hr>
    <table class="table">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Calificacion</th>
                <th>Accion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${cancion}">
                <tr>
                    <td><a href="/cancion/${cancion.id}"><c:out value="${cancion.titulo}"></c:out></a></td>
                    <td><c:out value="${cancion.calificacion}"></c:out></td>
                    <td>
                        <a href="/cancion/${cancion.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>




</body>