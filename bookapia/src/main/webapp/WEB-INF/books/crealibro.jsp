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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<h1>New Book</h1>
	<form:form action="/books" method="post" modelAttribute="libro">
		<div class="mb-3">
			<form:label class="form-label" path="title">Title</form:label>
			<form:errors class="text-danger" path="title" />
			<form:input class="form-control" path="title" />
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="description">Description</form:label>
			<form:errors class="text-danger"  path="description" />
			<form:textarea class="form-control" path="description" />
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="language">Language</form:label>
			<form:errors class="text-danger" path="language" />
			<form:input class="form-control" path="language" />
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="numberOfPages">Pages</form:label>
			<form:errors class="text-danger" path="numberOfPages" />
			<form:input  class="form-control" type="number" path="numberOfPages" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>