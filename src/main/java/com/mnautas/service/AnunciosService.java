package com.mnautas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mnautas.domain.Anuncio;
import com.mnautas.domain.anuncioenums.Condicao;
import com.mnautas.repository.AnunciosRepository;
import com.mnautas.service.exception.AnuncioNaoEncontradoException;
import com.mnautas.service.exception.AnunciosNaoEncontradosException;

@Service
public class AnunciosService {

	@Autowired
	private AnunciosRepository anunciosRepository;

	public Anuncio salvar(Anuncio anuncio) {
		anuncio.setId(null);
		return anunciosRepository.save(anuncio);
	}

	public Optional<Anuncio> buscar(Long id) throws AnuncioNaoEncontradoException {
		Optional<Anuncio> anuncio = anunciosRepository.findById(id);
		if (anuncio == null) {
			throw new AnuncioNaoEncontradoException();
		}
		return anuncio;
	}

	public List<Anuncio> listar() throws AnunciosNaoEncontradosException {
		if (anunciosRepository.findAll().isEmpty()) {
			throw new AnunciosNaoEncontradosException();
		}
		return anunciosRepository.findAll();
	}

	public void atualizar(Anuncio anuncio) throws AnuncioNaoEncontradoException {
		verificarExistencia(anuncio);
		anunciosRepository.save(anuncio);
	}

	private void verificarExistencia(Anuncio anuncio) throws AnuncioNaoEncontradoException {
		buscar(anuncio.getId());
	}

	public void deletar(Long id) throws AnuncioNaoEncontradoException {
		try {
			anunciosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AnuncioNaoEncontradoException();
		}
	}

}
