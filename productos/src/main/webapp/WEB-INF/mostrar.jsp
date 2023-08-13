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

<title>producto</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
		<h1>
			<c:out value="${producto.name }"></c:out>
		</h1>
		<div class="row">
			<div class="col-6">
				<h2>Categorias</h2>
				<ul>
					<c:forEach items="${producto.getCategories()}" var="categoria">
						<li> <c:out value="${categoria.name }"></c:out>  </li>
					</c:forEach>
				</ul>
			</div>
				<h2>categoria:</h2>
				<form:form action="/aso/${producto.id}" method="post"
					modelAttribute="asociacion">
					<form:input type="hidden" path="producto" value="${producto.id}" />
					<form:select class="form-control" path="categoria">
						<c:forEach items="${categorias}" var="categoria">
							<form:option value="${categoria.id} "> ${categoria.name}  
									</form:option>
						</c:forEach>
					</form:select>
					<button>Agregar</button>
				</form:form>
			</div>




</body>