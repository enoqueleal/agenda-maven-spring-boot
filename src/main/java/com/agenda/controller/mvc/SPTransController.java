package com.agenda.controller.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.agenda.model.Line;
import com.agenda.service.SPTransService;

@Controller
public class SPTransController {
	
	private SPTransService service;
	
	public SPTransController(SPTransService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/buscar-linha-por-nome")
	public String buscarContatoPorNome(@RequestParam(required = true) String parameter, Model model) {
		
		List<Line> lines = this.service.getLines(parameter);
		
		if(lines.isEmpty()) {
			model.addAttribute("noResultsFount", true);
		}
		
		model.addAttribute("linhas", this.service.getLines(parameter));
		
		return "/olho-vivo";
		
	}

}