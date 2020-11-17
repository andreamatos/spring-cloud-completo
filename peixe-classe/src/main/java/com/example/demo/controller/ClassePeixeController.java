package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.InfoClassePeixeDTO;
import com.example.demo.service.ClasseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/classe")
@RequiredArgsConstructor
public class ClassePeixeController {
	
	private final ClasseService service;
    private final ModelMapper modelMapper;
	
    @GetMapping("{tipoPeixe}")
	public InfoClassePeixeDTO get(@PathVariable  Long tipoPeixe ) {
        return service
        		.findByCodigoPeixe(tipoPeixe)
                .map( classePeixe -> modelMapper.map(classePeixe, InfoClassePeixeDTO.class)  )
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
}