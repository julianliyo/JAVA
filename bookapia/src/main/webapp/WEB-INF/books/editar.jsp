<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Libro</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<h1>Editar Libro</h1>
	<form:form action="/books/${libro.id}" method="post" modelAttribute="libro">
		<input type="hidden" name="_method" value="put" >
		<div>
			<form:label path="title">Title</form:label>
			<form:errors class="text-danger" path="title" />
			<form:input path="title" />
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:errors class="text-danger" path="description" />
			<form:textarea path="description" />
		</div>
		<div>
			<form:label path="language">Language</form:label>
			<form:errors class="text-danger" path="language" />
			<form:input path="language" />
		</div>
		<div>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors class="text-danger" path="numberOfPages" />
			<form:input type="number" path="numberOfPages" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
        <div class="row">
            <div class="col-md-6">
                <form action="/books/${libro.id}" method="post" class="d-inline">
                </form>
            </div>
        </div>
</body>
</html>