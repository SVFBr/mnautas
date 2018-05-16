package com.mnautas.domain.anuncioenums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Exposicao {

	@JsonProperty("baixa exposição")
	BAIXA_EXPOSICAO("baixa exposição"),
	@JsonProperty("alta exposição")
	ALTA_EXPOSICAO("alta exposição");

	private String descricao;

	Exposicao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
