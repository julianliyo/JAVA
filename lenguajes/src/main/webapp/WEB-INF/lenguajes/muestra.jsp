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

<link rel="stylesheet" href="/css/main.css">

<script type="text/javascript" src="/js/app.js"></script>

</head>


<body>
<div class="container text-center mt-5">
    <h1 class="mb-4">Lenguaje Detalles</h1>
    <div class="col-md-6 mx-auto">
        <p class="font-weight-bold fs-4">Nombre:</p>
        <p><c:out value="${lenguaje.name}" /></p>
        <p class="font-weight-bold fs-4">Creator:</p>
        <p><c:out value="${lenguaje.creator}" /></p>
        <p class="font-weight-bold fs-4">Versión:</p>
        <p><c:out value="${lenguaje.version}" /></p>
    </div>
</div>

</body>