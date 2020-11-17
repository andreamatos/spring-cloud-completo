package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InfoClassePeixe;

@Repository
public interface InfoClasseRepository extends CrudRepository<InfoClassePeixe, Long>{
	Optional<InfoClassePeixe> findByCodigoPeixe(Long codigoClassePeixe);
}
