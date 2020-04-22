package com.agenda.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.*;

import com.agenda.controller.mvc.RouterController;

public class RouterControllerControllerTest {

	private RouterController controller;

	@Before
	public void init() {
		controller = new RouterController();
	}

	@Test
	public void test_cadastra_usuario_page() {

		String returnedString = controller.cadastraUsuarioPage();

		assertThat(returnedString).isEqualTo("/adiciona-contato");

	}
	
	@Test
	public void test_home() {

		String returnedString = controller.home();

		assertThat(returnedString).isEqualTo("/index");

	}
	
	@Test
	public void test_index() {

		String returnedString = controller.index();

		assertThat(returnedString).isEqualTo("/index");

	}

}
