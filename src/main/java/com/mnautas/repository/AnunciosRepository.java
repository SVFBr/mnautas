package com.mnautas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnautas.domain.Anuncio;

@Repository
public interface AnunciosRepository extends JpaRepository<Anuncio, Long> {

}
