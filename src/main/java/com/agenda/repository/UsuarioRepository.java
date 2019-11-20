package com.agenda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agenda.model.Pessoa;

@Repository
public interface UsuarioRepository extends CrudRepository<Pessoa, Long> {

	Iterable<Pessoa> findByNome(String nome);

}
