package com.mnautas.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.mnautas.domain.anuncioenums.Condicao;
import com.mnautas.domain.anuncioenums.Exposicao;
import com.mnautas.domain.anuncioenums.Garantia;
import com.mnautas.domain.anuncioenums.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @NotBlank(message = "O título é obrigatório")
	// @Size(min = 50, message = "O tamanho máximo da descrição é de 50")
	private String titulo;

	// @NotBlank(message = "A descrição é obrigatória")
	// @Size(max = 1500, message = "O tamanho máximo da descrição é de 1500")
	// @Size(min = 50, message = "O tamanho máximo da descrição é de 50")
	private String descricao;

	// @NotNull(message = "Informe a quantidade de itens em estoque")
	// @Min(value = 1, message = "A quantidade deve ser maior que 0")
	// @Max(value = 9999, message = "A quantidade de ser menor que 9999")
	private Integer quantidade;

	// @NotNull(message = "Informe o preço de venda do seu produto")
	// @DecimalMin(value = "0.50", message = "O valor do produto deve ser maior que
	// R$0,50")
	// @DecimalMax(value = "9999999.99", message = "O valor do produto deve ser
	// menor que R$9.999.999,99")
	private BigDecimal preco;

	private String link;

	// @NotNull(message = "Informe se esto produto é novo ou usado")
	@Enumerated(EnumType.STRING)
	private Condicao condicao;

	// @NotNull(message = "Informado se o seu produto tem ou não garantia")
	@Enumerated(EnumType.STRING)
	private Garantia garantia;

	// @NotNull(message = "Informe o tipo de exposição que deseja para o seu
	// anúncio")
	@Enumerated(EnumType.STRING)
	private Exposicao exposicao;
	
	@Enumerated(EnumType.STRING)
    private Status status;

	@PrePersist
	@PreUpdate
	private void prePersisteUpdate() {
		titulo = titulo.toLowerCase();
		descricao = descricao.toLowerCase();
		link = link.toLowerCase();
	}

}
