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

<title>cancion</title>

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


</head>

<body>

  
<form:form action="/cancion/nuevo" method="post" modelAttribute="cancion">



        <div class="row mb-3">
            <div class="col">
                <span class="d-flex justify-content-end m-4"><a href="/dashboard">Dashboard</a></span>
                <h1 class="text-center">AGREGA LA CANCION</h1>
            </div>
        </div>
        <form action="/cancion/new" method="post" modelAttribute="cancion">
            <table>
                <thead>
                    <tr>
                        <td>titulo:</td>
                        <td>
                            <form:errors path="titulo"  />
                            <form:input  path="titulo" />
                        </td>
                    </tr>
                    <tr>
                        <td>Artista:</td>
                        <td>
                            <form:errors path="artista"  />
                            <form:input  path="artista" />
                        </td>
                    </tr>
                    <tr>
                        <td>califica la cancion del 1 al 10</td>
                        <td>
                            <form:errors path="calificacion"/>
                            <form:input  type="number" path="calificacion" />
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="agrega la cancion" /></td>
                    </tr>
                </thead>
            </table>
        </form>

	
	

</form:form>


</body>