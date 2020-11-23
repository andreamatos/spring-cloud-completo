package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.AmazonS3;
import com.example.demo.dto.PeixeDTO;
import com.example.demo.service.PeixeService;

@RestController
@RequestMapping("/peixe/detalhe")
public class PeixesController {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@Autowired
	private PeixeService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public PeixeDTO realizarCompra(@RequestBody PeixeDTO peixe) {
		return service.verificaClassePeixe(peixe);
	}
	
	@PostMapping("/note")
	public void note(@RequestParam String name, @RequestParam String content) {
		amazonS3.putObject("peixe-s3", name + ".txt", content);
	}

}