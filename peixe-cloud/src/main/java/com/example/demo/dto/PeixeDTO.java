package com.example.demo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PeixeDTO implements Serializable  {
	private static final long serialVersionUID = -7765640077283106831L;

	private Integer codigo;
	private String nome;
	private String classe;
}
