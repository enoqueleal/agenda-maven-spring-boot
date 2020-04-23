package com.agenda.controller.rest;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.model.Pessoa;
import com.agenda.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioRestController {

	private UsuarioService service;

	public UsuarioRestController(UsuarioService service) {
		this.service = service;
	}

	@GetMapping(value = "/pessoas")
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
