package com.mnautas.service.exception;

public class AnuncioNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public AnuncioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AnuncioNaoEncontradoException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

	public AnuncioNaoEncontradoException() {
	}

}
