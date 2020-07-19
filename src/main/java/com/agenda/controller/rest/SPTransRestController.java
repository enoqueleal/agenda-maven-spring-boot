package com.agenda.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agenda.service.SPTransService;

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

}
