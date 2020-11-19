package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PeixeDTO;
import com.example.demo.service.PeixeService;

@RestController
@RequestMapping("/peixe/detalhe")
public class PeixesController {
	
	@Autowired
	private PeixeService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public PeixeDTO realizarCompra(@RequestBody PeixeDTO peixe) {
		return service.verificaClassePeixe(peixe);
	}

}