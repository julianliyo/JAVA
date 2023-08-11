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

<title>nueva licencia</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">

<script type="text/javascript" src="/js/app.js"></script>

</head>

<body>


<div class="container p-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
    
      <h2 class="text-center">Nueva Licencia</h2>
      <form:form action="/licencias/new" method="POST" modelAttribute="licencia">
      
        <div class="form-group">
          <form:label path="persona">Persona:</form:label>
          <form:select path="persona">
            <c:forEach items="${personas}" var="p">
              <form:option value="${p.id}">${p.firstName} ${p.lastName}</form:option>
            </c:forEach>
          </form:select>
        </div>
        
        <div class="form-group">
          <form:label path="state">Pais:</form:label>
          <form:errors path="state" />
          <form:input type="text" path="state" />
        </div>
        
        <div class="form-group">
          <form:label path="expirationDate">Fecha Expiracion :</form:label>
          <form:errors path="expirationDate" />
          <form:input type="date" path="expirationDate" />
        </div>
        

          <button>Crear Licencia</button>

        
      </form:form>
    </div>
  </div>
</div>

</body>