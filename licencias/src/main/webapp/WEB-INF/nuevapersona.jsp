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

<title>nueva persona</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">

<script type="text/javascript" src="/js/app.js"></script>

</head>

<body>

	<div class="container">
		<h2>Nueva Persona</h2>
		<form:form action="/personas/new" method="POST" modelAttribute="persona">
			<div class="form-group">
				<form:label path="firstName">nombre</form:label>
				<form:errors class="text-danger" path="firstName" />
				<form:input path="firstName" />
			</div>
			<div class="form-group">
				<form:label path="lastName">apellido</form:label>
				<form:errors class="text-danger" path="lastName" />
				<form:input path="lastName" />
			</div>
			<button> Crear Persona</button>	
	</form:form>
	</div>


</body>