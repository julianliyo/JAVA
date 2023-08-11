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

</head>

<body>


<div class="container p-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
    
      <h2 class="text-center">nuevo contacto</h2>
      <form:form action="/contact/new" method="POST" modelAttribute="contact">
      
        <div class="form-group">
          <form:label path="estudiante">estudiante:</form:label>
          <form:select path="estudiante">
            <c:forEach items="${estudiantes}" var="e">
              <form:option value="${e.id}">${e.firstName} ${e.lastName}</form:option>
            </c:forEach>
          </form:select>
        </div>
        
        <div class="form-group">
          <form:label path="address">direccion:</form:label>
          <form:errors path="address" />
          <form:input type="text" path="address" />
        </div>
        
        <div class="form-group">
          <form:label path="city">ciudad:</form:label>
          <form:errors path="city" />
          <form:input type="text" path="city" />
        </div>
			<div class="form-group">
          <form:label path="state">estado:</form:label>
          <form:errors path="state" />
          <form:input type="text" path="state" />
        </div>
        

          <button>Crear</button>

        
      </form:form>
    </div>
  </div>
</div>



</body>