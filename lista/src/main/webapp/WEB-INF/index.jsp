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

<title>Lista</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		<h1>Lista de Estudiantes</h1>
		<div class="mb-2 text-center">
			<a href="/estudiantes/new">Agrega un nuevo estudiante</a>
			<a href="/contact/new">Agrega informacion de contacto</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Edad</th>
					<th>Direccion</th>
					<th>Ciudad</th>
					<th>Estado</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${estudiante}" var="estudiante">
					<tr>
						<td>${estudiante.firstName} ${estudiante.lastName}</td>
						<td>${estudiante.age}</td>
						<td>${estudiante.getcontact().getAddress()}</td>
						<td>${estudiante.getcontact().getCity()}</td>
						<td>${estudiante.getcontact().getState()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>