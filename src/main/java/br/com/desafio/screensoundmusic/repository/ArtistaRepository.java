package br.com.desafio.screensoundmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.screensoundmusic.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    
}
