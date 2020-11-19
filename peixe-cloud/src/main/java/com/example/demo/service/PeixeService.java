package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.InfoClassePeixeDTO;
import com.example.demo.dto.PeixeDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PeixeService {
	
	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaClient;

	@HystrixCommand(fallbackMethod="verificaClassePeixeFallBack")
	public PeixeDTO verificaClassePeixe(PeixeDTO peixe) {
		PeixeDTO peixeDTO = new PeixeDTO();
		ResponseEntity<InfoClassePeixeDTO> exchange = 
				client
				.exchange(("http://peixe-classe/classe/" + peixe.getCodigo()), HttpMethod.GET, null, InfoClassePeixeDTO.class);
		
		eurekaClient.getInstances("peixe-classe").stream().forEach(peixeClasse -> {
//			System.out.println("localhost:" + peixeClasse.getPort());	
		});
		
//		System.out.println(exchange.getBody().getClassePeixe());
		
//		try {
//			Thread.sleep(1000);
//		}catch(Exception e ){
//			e.printStackTrace();
//		}
		
		peixeDTO.setNome(exchange.getBody().getNomePeixe());
		return peixeDTO;
	}
	
	public PeixeDTO verificaClassePeixeFallBack(PeixeDTO peixe) {
		PeixeDTO peixeDTOFallBack = new PeixeDTO();
		peixeDTOFallBack.setCodigo(peixe.getCodigo());
		return peixeDTOFallBack;
	}
	
}
