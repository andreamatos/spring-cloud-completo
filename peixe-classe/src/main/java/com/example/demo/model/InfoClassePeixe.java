package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class InfoClassePeixe {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoPeixe;

	@Column
	private String nomePeixe;
	
	@Column
	private String classePeixe;
}
