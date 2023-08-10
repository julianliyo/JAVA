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
    <h1 class="m-3 p-3">Editar Lenguaje</h1>
    <div class="col-md-6 mx-auto">
        <form:form action="/lenguajes/${lenguaje.id}" method="post" modelAttribute="lenguaje">
            <input type="hidden" name="_method" value="put">
            <div class="form-group">
                <form:label path="name">Nombre</form:label>
                <form:errors path="name" cssClass="text-danger"/>
                <form:input class="form-control" path="name"/>
            </div>
            <div class="form-group">
                <form:label path="creator">Creador</form:label>
                <form:errors path="creator" cssClass="text-danger"/>
                <form:textarea class="form-control" path="creator" rows="3"/>
            </div>
            <div class="form-group">
                <form:label path="version">Versión</form:label>
                <form:errors path="version" cssClass="text-danger"/>
                <form:input class="form-control" path="version"/>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form:form>
    </div>
    <a href="/lenguajes" class="mt-3 btn btn-secondary">Volver al Inicio</a>
</div>



</body>