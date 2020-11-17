package com.example.demo.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.InfoClassePeixe;
import com.example.demo.repository.InfoClasseRepository;
import com.example.demo.service.ClasseService;

@Service
public class ClasseServiceImpl implements ClasseService {

    private InfoClasseRepository repository;
    
    public ClasseServiceImpl(InfoClasseRepository repository) {
        this.repository = repository;
    }

	@Override
	public Optional<InfoClassePeixe> findByCodigoPeixe(Long tipoPeixe) {
		return repository.findByCodigoPeixe(tipoPeixe);
	}

}
