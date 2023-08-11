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

<title>Licencias</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">

<script type="text/javascript" src="/js/app.js"></script>

</head>

<body>

	<a href="/personas/new"> Agrega una nueva persona</a>
	<a href="/licencias/new">Agrega una nueva licencia</a>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Numero Licencia</th>
				<th>Fecha Expiracion</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${todos }" var="persona">
				<tr>
					<td>${persona.firstName } ${persona.lastName }</td>
					<td>${persona.getLicencia().getNumberComoString() }</td>
					<td><fmt:formatDate pattern="MM/dd/yyy"
							value="${persona.getLicencia().getExpirationDate()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>