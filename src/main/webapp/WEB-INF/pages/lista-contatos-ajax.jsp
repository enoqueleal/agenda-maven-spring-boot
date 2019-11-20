<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${empty contatos}">
	<div class="text-center">
		<hr>
		<p class="lead">Usaremos para o gerenciamento de contatos.</p>
	</div>
</c:if>

<c:if test="${not empty contatos}">
	<input type="text" id="nome-search" placeholder="Search for names...">
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Data de Nascimento</th>
			<th></th>
		</tr>

		<c:forEach var="pessoa" items="${contatos}">
			<tr>
				<td>${pessoa.nome}</td>
				<td><fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy" /></td>
				<td>
					<a href="#" onclick="saveContactId(${pessoa.id})" data-toggle="modal" data-target="#modalExemplo">Remover</a> 
					<span> | </span> 
					<a href="editar-contato?id=${pessoa.id}">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>