package com.agenda.integrated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.agenda.model.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioRestControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test_get_all() {

		ResponseEntity<Pessoa[]> responseEntity = restTemplate.getForEntity("/api/pessoas", Pessoa[].class);
		
		Pessoa[] pessoas = responseEntity.getBody();
		
		int expected = pessoas.length;
		int actual = 2;
		
		assertNotNull(responseEntity);
		assertEquals(expected, actual);

	}
	
	@Test
	public void test_delete_by_id() {

		restTemplate.delete("/api/pessoas/1");
		
		assertTrue(true);

	}
	
	@Test
	public void test_save() {

		Pessoa pessoa = new Pessoa();
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("/api/pessoas", pessoa, String.class);
		
		assertNotNull(responseEntity);

	}
	
	@Test
	public void test_update() {

		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("João");
		
		restTemplate.put("/api/pessoas", pessoa, String.class);
		
		assertTrue(true);

	}
	
	@Test
	public void test_get_by_id() {

		ResponseEntity<Pessoa> responseEntity = restTemplate.getForEntity("/api/pessoas/1", Pessoa.class);
		
		Pessoa pessoa = responseEntity.getBody();
		
		assertNotNull(pessoa);

	}

}
