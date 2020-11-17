package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.InfoClassePeixeDTO;
import com.example.demo.dto.PeixeDTO;

@Service
public class PeixeService {
	
	@Autowired
	private RestTemplate client;

	public void verificaClassePeixe(PeixeDTO peixe) {
		
		ResponseEntity<InfoClassePeixeDTO> exchange = 
				client
				.exchange(("http://peixe-classe/classe/" + peixe.getCodigo()), HttpMethod.GET, null, InfoClassePeixeDTO.class);
		
		System.out.println(exchange.getBody().getClassePeixe());
	}
}
