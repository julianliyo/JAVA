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

<title>Bienvenido</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
		<div class="container">
		<h1>Bienvenido</h1>
		
		<div class="col mx-auto ">
			<a href="/categories/new"> Nueva Categora</a> 
			<a href="/products/new"> Nuevo Producto</a>
		</div>
		
		<h2>productos</h2>
		<ul>
		<c:forEach items="${productos }" var="producto">
			<li> <a href="product/${producto.id }"> <c:out value="${producto.name}"></c:out>  </a> </li>
		</c:forEach>
		</ul>
	</div>
</body>