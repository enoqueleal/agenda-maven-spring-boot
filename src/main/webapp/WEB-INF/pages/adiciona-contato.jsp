<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>	
	<title>Agenda</title>
	<link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="shortcut icon" href="img/favicon.ico" />
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">Agenda</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="index">Home</a> 
			<a class="p-2 text-dark" href="cadastra-usuario">Cadastrar</a> 
			<a class="p-2 text-dark" href="busca-contatos">Listar</a>
		</nav>
	</div>
	<div class="container">
	
	<div class="text-center">
		<h1 class="display-4">Formulário de cadastro</h1>
    </div>
	
	<form action="salva-contato" id="form-produto" method="post">
	
		<input type="hidden" id="pessoa.id" name="pessoa.id" value="${pessoa.id}">
		<input type="hidden" id="pessoa.endereco.id" name="pessoa.endereco.id" value="${pessoa.endereco.id}">
		<input type="hidden" id="pessoa.contato.id" name="pessoa.contato.id" value="${pessoa.contato.id}">
		
		<div class="card">
			<div class="card-body">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="nome">Nome</label> 
						<input type="text" value="${pessoa.nome}" class="form-control" id="name" name="nome" placeholder="Nome" >
					</div>
					<div class="form-group col-md-6">
						<label for="nome">Nascimento</label> 
						<input type="date" class="form-control" id="dataNascimento" name="dataNascimento" value="<fmt:formatDate  value="${pessoa.dataNascimento}" pattern="yyy-MM-dd" />"/> 
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="card">
			<div class="card-body">
				<div class="form-group col-md-3">
					<label for="tel">Telefone</label> 
					<input type="text" value="${pessoa.contato.telefone}" class="form-control" id="contato.telefone" name="contato.telefone" placeholder="Telefone" data-mask="(99) 9999-9999">
				</div>

				<div class="form-group col-md-3">
					<label for="email">E-mail</label> 
					<input type="email" value="${pessoa.contato.email}" class="form-control" id="contato.email" name="contato.email" placeholder="E-mail">
				</div>
			</div>
		</div>
		<br>
		<div class="card">
			<div class="card-body">
				<div class="form-group col-md-6">
					<label for="end">Logradouro</label> 
					<input type="text" value="${pessoa.endereco.logradouro}" class="form-control" id="endereco.logradouro" name="endereco.logradouro" placeholder="Logradouro">
				</div>
				<div class="form-group col-md-6">
					<label for="end">CEP</label> 
					<input type="text" value="${pessoa.endereco.cep}" class="form-control" id="endereco.cep" name="endereco.cep" placeholder="CEP" data-mask="99999-999">
				</div>
			</div>
		</div>
		<br>
		<div>
			<button class="btn btn-success" id="btnSalvar" type="submit">Salvar</button>
		</div>
	</form>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="js/inputMask.js"></script>
</body>
</html>