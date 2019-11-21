package com.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

	@RequestMapping(value = "/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping(value = "/index")
	public String home() {
		return "/index";
	}
	
	@RequestMapping(value = "/cadastra-usuario")
	public String cadastraUsuarioPage() {
		return "/adiciona-contato";
	}

}
