<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>SPTrans</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="icon" href="http://www.sptrans.com.br/images/favicon.png" />
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/olho-vivo">
					<img style="width: 70px;" alt="SPTrans" src="http://www.sptrans.com.br/images/header/logo-sptrans.png">
				</a>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="text-center">
			<h1>Olho Vivo | SPTrans</h1>
		</div>
		<hr>

		<form action="buscar-linha-por-nome" method="POST" >
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</div>
					<input type="text" class="form-control" name="parameter" placeholder="Digite o prefixo ou nome da linha desejada..." required="required" >
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-default">Buscar</button>
			</div>
		</form>
		
		<c:if test="${not empty linhas}">
			<br>
			<table class="table">
				<tr>
					<th>LINHA</th>
					<th>DE</th>
					<th>PARA</th>
					<th>CIRCULAR</th>
				</tr>

				<c:forEach var="linha" items="${linhas}">
					<tr>
						<td>${linha.letreiroParteUm}/${linha.letreiroParteDois}</td>
						<td>${linha.descritivoIda}</td>
						<td>${linha.descritivoVolta}</td>
						<td>${linha.linhaCircular ? "SIM" : "NÃO"}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br>
		<c:if test="${noResultsFount}">
			<div class="text-center">
				<span>Nenhum resultado encontrado!</span>
			</div>
		</c:if>

	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

</body>
</html>