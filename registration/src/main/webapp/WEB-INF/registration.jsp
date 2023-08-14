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

<title>registro</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>

				<h2>registrate</h2>
				<div>
					<form:errors class="text-danger" path="user.*" />
				</div>

				<form:form method="POST" action="/registration"
					modelAttribute="user">
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" />
					</div>
					<div>
						<form:label path="password">contraseña:</form:label>
						<form:password path="password" />
					</div>
					<div>
						<form:label path="passwordConfirmation">contraseña Confirmacion:</form:label>
						<form:password path="passwordConfirmation" />
					</div>
					<input type="submit" value="Registrarse" />
				</form:form>
				<p class="text-success"> <c:out value="${registro }"></c:out> </p>

				<h2>inicio sesion</h2>

				<div>
					<form:errors class="text-danger" path="login.*" />
				</div>

				<form:form method="POST" action="/login" modelAttribute="login">
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" />
					</div>
					<div>
						<form:label path="password">contraseña:</form:label>
						<form:password path="password" />
					</div>

					<input type="submit" value="iniciar sesion" />
				</form:form>
</body>