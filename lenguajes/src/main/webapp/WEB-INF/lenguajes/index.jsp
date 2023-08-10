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

<title>lenguajes</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">

<script type="text/javascript" src="/js/app.js"></script>

</head>

<body>
<div class="p-3 mb-2 bg-light text-dark">
    <h1 class="container mx-auto m-3 p-3 text-center">Todos los Lenguajes</h1>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Creador</th>
                <th scope="col">Versión</th>
                <th scope="col">Acción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lenguaje}" var="lenguaje">
                <tr>
                    <td><a href="/lenguajes/${lenguaje.id}">${lenguaje.name}</a></td>
                    <td><c:out value="${lenguaje.creator}" /></td>
                    <td><c:out value="${lenguaje.version}" /></td>
                    <td class="align-middle">
                        <a href="/lenguajes/${lenguaje.id}/edit" class="btn btn-warning">Editar</a>
                        <form action="/lenguajes/${lenguaje.id}" method="post" class="d-inline">
                            <input type="hidden" name="_method" value="delete"/>
                            <input type="submit" class="btn btn-danger mb-1" value="Borrar Lenguaje"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="container p-3 mb-2 bg-light text-center">
    <h1 class="m-3 p-3">Nuevo Lenguaje</h1>
    <form:form action="/lenguajes" method="post" modelAttribute="lenguajes" class="mx-auto">
        <div class="form-group">
            <label for="name">Nombre</label>
            <input type="text" class="form-control" id="name" name="name" />
            <form:errors class="text-danger" path="name" />
        </div>
        <div class="form-group">
            <label for="creator">Creador</label>
            <textarea class="form-control" id="creator" name="creator"></textarea>
            <form:errors class="text-danger" path="creator" />
        </div>
        <div class="form-group">
            <label for="version">Versión</label>
            <input type="text" class="form-control" id="version" name="version" />
            <form:errors class="text-danger" path="version" />
        </div>
        <input type="submit" value="Guardar" class="btn btn-success m-3"/>
    </form:form>
</div>

</body>