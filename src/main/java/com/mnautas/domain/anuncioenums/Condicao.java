package com.mnautas.domain.anuncioenums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Condicao {

	@JsonProperty("novo")
	NOVO("novo"), 
	@JsonProperty("usado")
	USADO("usado");

	private String descricao;

	Condicao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
