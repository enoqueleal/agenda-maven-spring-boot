package com.agenda.service;

import org.springframework.stereotype.Service;

import com.agenda.model.Pessoa;
import com.agenda.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Pessoa salvarOuAtualizar(Pessoa pessoa) {
		return this.repository.save(pessoa);
	}

	public Iterable<Pessoa> buscaPessoas() {
		return this.repository.findAll();
	}

	public Pessoa buscarPorId(Long id) {
		return this.repository.findById(id).get();
	}

	public void remover(long id) {
		this.repository.deleteById(id);
	}

	public Iterable<Pessoa> buscaPessoaPorNome(String nome) {
		return this.repository.findByNome(nome);
	}

}
