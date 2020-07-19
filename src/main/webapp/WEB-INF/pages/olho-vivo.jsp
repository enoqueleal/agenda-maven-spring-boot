<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>SPTrans</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="icon" href="http://www.sptrans.com.br/images/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th class="text-center" >LINHA</th>
						<th>ORIGEM</th>
						<th>DESTINO</th>
					</tr>
	
					<c:forEach var="linha" items="${linhas}">
						<tr>
							<td class="text-center">
								<a class="btn btn-link" onclick="modalValues(${linha.codigoIdentificador})" role="button" href="#" data-toggle="modal" data-target="#modal-detalhe">
									${linha.letreiroParteUm}/${linha.letreiroParteDois}
								</a>
							</td>
							<td>${linha.sentido == 1 ? linha.descritivoIda : linha.descritivoVolta}</td>
							<td>${linha.sentido == 2 ? linha.descritivoIda : linha.descritivoVolta}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<br>
		<c:if test="${noResultsFount}">
			<div class="text-center">
				<span>Nenhum resultado encontrado!</span>
			</div>
		</c:if>
		
		<div class="modal fade" id="modal-detalhe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Detalhes da linha:</h4>
					</div>
					<div class="modal-body">
						<div id="ajax-response"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<script>
	
		function modalValues(codigoIdentificador){ 
			
			$.ajax({
				url : 'open-modal',
				data : {
					identificador : codigoIdentificador
				},
				success : function(responseText) {
					$('#ajax-response').html(responseText);
				}
			});
			
		}
	
	</script>

</body>
</html>