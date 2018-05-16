package com.mnautas.resource;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mnautas.domain.Anuncio;
import com.mnautas.domain.anuncioenums.Condicao;
import com.mnautas.domain.anuncioenums.Exposicao;
import com.mnautas.domain.anuncioenums.Garantia;
import com.mnautas.service.AnunciosService;
import com.mnautas.service.exception.AnuncioNaoEncontradoException;
import com.mnautas.service.exception.AnunciosNaoEncontradosException;

@RestController
@RequestMapping("/anuncios")
public class AnunciosResource {

	@Autowired
	private AnunciosService anunciosService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Anuncio anuncio, Garantia garantia, Exposicao exposicao,
			Condicao condicaoDoProduto) {
		anuncio = anunciosService.salvar(anuncio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anuncio.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Anuncio>> listar() throws AnunciosNaoEncontradosException {
		return ResponseEntity.status(HttpStatus.OK).body(anunciosService.listar());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) throws AnuncioNaoEncontradoException {
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(anunciosService.buscar(id));
	}

}
