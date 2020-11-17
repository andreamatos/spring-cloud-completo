package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.InfoClassePeixe;

public interface ClasseService {

    Optional<InfoClassePeixe> findByCodigoPeixe(Long tipoPeixe);

}
