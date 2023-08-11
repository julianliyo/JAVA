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
<p class="d-flex justify-content-end m-4"><a href="/dashboard">Dashboard</a></p>


   <div class="row">
        <div class="col">
            <table class="table">
                <tr>
                    <th>Titulo:</th>
                    <td><c:out value="${cancion.titulo}"></c:out></td>
                </tr>
                <tr>
                    <th>Artista:</th>
                    <td><c:out value="${cancion.artista}"></c:out></td>
                </tr>
                <tr>
                    <th>calificacion:</th>
                    <td><c:out value="${cancion.calificacion}"></c:out></td>
                </tr>
            </table>
        </div>
        </div>

            <a href="/cancion/${cancion.id}/delete">Delete</a>



</body>