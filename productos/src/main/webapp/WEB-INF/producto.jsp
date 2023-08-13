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
		<h1>producto nuevo</h1>
		<form:form action="/products/new" method="POST" modelAttribute="producto">
			<div class="form-group">
				<form:label class="form-label" path="name">nombre:  </form:label>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" class="form-control" path="name" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="Descripcion">Descripcion: </form:label>
				<form:errors class="text-danger" path="Descripcion" />
				<form:input type="text" class="form-control" path="Descripcion" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="precio">precio:  </form:label>
				<form:errors class="text-danger" path="precio" />
				<form:input type="number" class="form-control" path="precio" />
			</div>
			<button>Crear Producto</button>
		</form:form>
</body>