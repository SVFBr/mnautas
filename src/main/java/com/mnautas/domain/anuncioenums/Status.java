package com.mnautas.domain.anuncioenums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

	@JsonProperty("ativo")
	ATIVO("ativo"),
	@JsonProperty("pausado")
	PAUSADO("pausado"),
	@JsonProperty("finalizado")
	FINALIZADO("finalizado");
	
	private String descricao;
	
	Status(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
