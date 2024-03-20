package br.com.desafio.screensoundmusic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.screensoundmusic.model.Artista;
import br.com.desafio.screensoundmusic.model.Musica;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);
    
    @Query("SELECT m FROM Musica m")
    List<Musica> listarMusicas();

    @Query("SELECT m FROM Musica m WHERE m.artista = :artista")
    List<Musica> BuscarMusicaPorArtista(Artista artista);
}
