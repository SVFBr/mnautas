package com.mnautas.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mnautas.domain.DetalhesErro;
import com.mnautas.service.exception.AnuncioNaoEncontradoException;
import com.mnautas.service.exception.AnunciosNaoEncontradosException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(AnunciosNaoEncontradosException.class)
	public ResponseEntity<DetalhesErro> handleAnunciosNaoEncontradosException(AnunciosNaoEncontradosException e,
			HttpServletRequest request) {
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(404l);
		detalhesErro.setTitulo("Não há anúncios cadastrados");
		detalhesErro.setMensagemDesenvolvedor("http://erros.mnautas.com/404");
		detalhesErro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
	}

	@ExceptionHandler(AnuncioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleAnuncioNaoEncontradoException(AnuncioNaoEncontradoException e,
			HttpServletRequest request) {
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(404l);
		detalhesErro.setTitulo("Anúncio não localizado");
		detalhesErro.setMensagemDesenvolvedor("http://erros.mnautas.com/404");
		detalhesErro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
	}

}
