package com.mnautas.domain.anuncioenums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Garantia {

	@JsonProperty("com garantia")
	COM_GARANTIA("com garantia"), 
	@JsonProperty("sem garantia")
	SEM_GARANTIA("sem garantia");

	private String descricao;

	Garantia(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
