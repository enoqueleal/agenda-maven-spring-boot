package br.com.sptrans.olhovivo.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.sptrans.olhovivo.service.SPTransService;

@RestController
@RequestMapping(value = "/sptrans")
public class SPTransRestController {
	
	private SPTransService service;
	
	public SPTransRestController(SPTransService service) {
		this.service = service;
	}

	@GetMapping(value = "/line")
	public ResponseEntity<?> line(@RequestParam(required = true) String parameter) {
		return ResponseEntity.ok().body(service.getLines(parameter));
	}
	
	@GetMapping(value = "/location")
	public ResponseEntity<?> location(@RequestParam(required = true) Integer parameter) {
		return ResponseEntity.ok().body(service.getLocation(parameter));
	}

}
