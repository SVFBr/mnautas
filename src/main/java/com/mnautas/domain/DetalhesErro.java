package com.mnautas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetalhesErro {

	private String titulo;

	private Long status;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Long timestamp;

	private String mensagemDesenvolvedor;

}
