package com.agenda.controller.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.model.Pessoa;
import com.agenda.service.UsuarioService;

@Controller
public class UsuarioController {

	private UsuarioService service;

	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(value = "/busca-contatos")
	public String buscaContatos(Model model) {
		model.addAttribute("contatos", this.service.buscaPessoas());
		return "/lista-contatos";
	}

	@PostMapping(value = "/salva-contato")
	public ModelAndView salvaContato(@ModelAttribute Pessoa pessoa) {
		this.service.salvarOuAtualizar(pessoa);
		return new ModelAndView("redirect:/busca-contatos");
	}
	
	@RequestMapping(value = "/remove-contato")
	public ModelAndView removeContato(@RequestParam long id) {
		this.service.remover(id);
		return new ModelAndView("redirect:/busca-contatos");
	}
	
	@RequestMapping(value = "/editar-contato")
	public String editarContato(@RequestParam long id, Model model) {
		model.addAttribute("pessoa", this.service.buscarPorId(id));
		return "/adiciona-contato";
	}
	
	@RequestMapping(value = "/buscar-contato-por-nome")
	public String buscarContatoPorNome(@RequestParam String nome, Model model) {
		model.addAttribute("contatos", this.service.buscaPessoaPorNome(nome));
		return "/lista-contatos-ajax";
	}

}
