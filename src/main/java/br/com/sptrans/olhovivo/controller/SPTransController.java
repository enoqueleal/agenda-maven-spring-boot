package br.com.sptrans.olhovivo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.sptrans.olhovivo.model.Bus;
import br.com.sptrans.olhovivo.model.Line;
import br.com.sptrans.olhovivo.model.Location;
import br.com.sptrans.olhovivo.service.SPTransService;

@Controller
public class SPTransController {
	
	private SPTransService service;
	private List<Line> lines;
	
	public SPTransController(SPTransService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/buscar-linha-por-nome")
	public String buscarContatoPorNome(@RequestParam(required = true) String parameter, Model model) {
		
		lines = this.service.getLines(parameter);
		
		if(lines.isEmpty()) {
			model.addAttribute("noResultsFount", true);
		}
		
		model.addAttribute("linhas", this.service.getLines(parameter));
		
		return "/olho-vivo";
		
	}
	
	@RequestMapping(value = "/open-modal")
	public String openModal(@RequestParam Integer identificador, Model model) {
		
		for (Line line : lines) {
			
			if(line.getCodigoIdentificador().equals(identificador)) {
				model.addAttribute("linha", line);
				break;
			}
			
		}
		
		Location location = this.service.getLocation(identificador);
		
		Bus bus = location.getOnibus().get(0);
		
		model.addAttribute("bus", bus);
		
		return "/olho-vivo-modal";
		
	}

}