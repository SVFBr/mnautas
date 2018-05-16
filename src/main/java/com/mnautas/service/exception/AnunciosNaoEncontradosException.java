package com.mnautas.service.exception;

public class AnunciosNaoEncontradosException extends Exception {

	private static final long serialVersionUID = 1L;

	public AnunciosNaoEncontradosException(String mensagem) {
		super(mensagem);
	}

	public AnunciosNaoEncontradosException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

	public AnunciosNaoEncontradosException() {
	}

}
