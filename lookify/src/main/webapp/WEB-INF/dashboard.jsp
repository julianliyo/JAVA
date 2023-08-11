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


    <h1 class="m-5" style="font-size: 24px;">Canciones</h1>
    <div class="row mb-3">
        <div class="col">
            <a href="/cancion/nuevo">agregar nueva canción</a>
        </div>
        <div class="col">
            <a href="/top10">Top 10</a>
        </div>
        <div class="col">
		<form class="form-inline" action="/buscar" method="get">
		<div class="input-group">
		<input class="form-control" type="text" id="artista" name="q" placeholder="buscar artista"/>
		<div class="input-group-append">
		<button type="submit">buscar</button>
		</div>
		</div>
		</form>
	    </div>
    </div>
    <table class="table">
        <thead class="table-header">
            <tr>
                <th>nombre</th>
                <th>calificación</th>
                <th>acción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${cancion}" varStatus="loop">
                    <tr style="background-color: ${loop.index % 2 == 0 ? '#f2f2f2' : 'white'};">
                    <td><a href="/cancion/${cancion.id}"><c:out value="${cancion.titulo}"></c:out></a></td>
                    <td><c:out value="${cancion.calificacion}"></c:out></td>
                    <td><a href="/cancion/${cancion.id}/delete">delete</a></td>
			</tr>
            </c:forEach>
        </tbody>
    </table>


</body>

