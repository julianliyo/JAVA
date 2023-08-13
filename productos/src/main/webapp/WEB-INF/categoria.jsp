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

<title>categoria</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
		<h1>nueva categoria</h1>
		<form:form action="/categories/new" method="POST" modelAttribute="categoria">
			<div class="form-group">
				<form:label class="form-label" path="name">Categoria: </form:label>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" class="form-control" path="name" />
			</div>
			<button>Crear Categoria</button>
		</form:form>



</body>