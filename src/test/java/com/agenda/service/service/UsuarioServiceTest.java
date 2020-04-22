package com.agenda.service.service;

import java.util.*;
import org.junit.*;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.agenda.model.Pessoa;
import com.agenda.repository.UsuarioRepository;
import com.agenda.service.UsuarioService;

public class UsuarioServiceTest {
	
	private UsuarioRepository repository;
	private UsuarioService service;

	@Before
	public void init() {
		repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
	}
	
	@Test
	public void test_busca_pessoa_por_nome_com_sucesso() {
		
		List<Pessoa> pessoas = Arrays.asList(new Pessoa());
		
		when(repository.findByNome(anyString())).thenReturn(pessoas);
		
		Iterable<Pessoa> reesponseBody = service.buscaPessoaPorNome(anyString());
		
		assertNotNull(reesponseBody);
		
	}
	
	@Test
	public void test_busca_pessoas_com_sucesso() {
		
		List<Pessoa> pessoas = Arrays.asList(new Pessoa());
		
		when(repository.findAll()).thenReturn(pessoas);
		
		Iterable<Pessoa> reesponseBody = service.buscaPessoas();
		
		assertNotNull(reesponseBody);
		
	}
	
	@Test
	public void test_remover_pessoa_com_sucesso() {
		
		doNothing().when(repository).deleteById(1L);
		
		service.remover(1);
				
		verify(repository).deleteById(1L);
		
	}
	
	@Test
	public void test_buscar_pessoa_por_id_com_sucesso() {
		
		Optional<Pessoa> person = Optional.of(new Pessoa());
		
		when(repository.findById(1L)).thenReturn(person);
		
		Pessoa returnedPerson = service.buscarPorId(1L);
			
		assertNotNull(returnedPerson);
		
	}
	
	@Test
	public void test_salvar_ou_atualizar_com_sucesso() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		
		Mockito.when(repository.save(any())).thenReturn(pessoa);
		
		Pessoa returnedPerson = service.salvarOuAtualizar(pessoa);  
			
		assertNotNull(returnedPerson);
		
	}

}
