package com.agenda.controller.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.model.Pessoa;
import com.agenda.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioRestController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/pessoas")
	public @ResponseBody Iterable<Pessoa> buscaPessoas() {
		return this.service.buscaPessoas();
	}

	@GetMapping(value = "/pessoas/{id}")
	public @ResponseBody ResponseEntity<Pessoa> buscarContatoPorId(@PathVariable final long id) {
		return ResponseEntity.ok(this.service.buscarPorId(id));
	}

	@DeleteMapping(value = "/pessoas/{id}")
	public @ResponseBody ResponseEntity<?> removerContato(@PathVariable final long id) {
		this.service.remover(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/pessoas")
	public @ResponseBody ResponseEntity<?> cadastrarContato(@RequestBody final Pessoa pessoa) {
		return salvarOuAtualizar(pessoa);
	}

	@PutMapping(value = "/pessoas")
	public @ResponseBody ResponseEntity<?> atualizarContato(@RequestBody final Pessoa pessoa) {
		return salvarOuAtualizar(pessoa);
	}

	private ResponseEntity<?> salvarOuAtualizar(final Pessoa pessoa) {

		Pessoa p = this.service.salvarOuAtualizar(pessoa);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
