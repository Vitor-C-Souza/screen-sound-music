package br.com.desafio.screensoundmusic.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.desafio.screensoundmusic.model.Artista;
import br.com.desafio.screensoundmusic.model.Musica;
import br.com.desafio.screensoundmusic.model.TipoArtista;
import br.com.desafio.screensoundmusic.repository.ArtistaRepository;
import br.com.desafio.screensoundmusic.service.ConsultaChatGPT;

public class Menu {
    private Scanner read;
    private ArtistaRepository repositorio;
    private String cadastrar;

    public Menu(Scanner read, ArtistaRepository repositorio) {
        this.read = read;
        this.repositorio = repositorio;
    }

    public void CadastrarArtista() {
        System.out.println("***CADASTRANDO ARTISTAS***");

        do {
            System.out.println("Informe o nome desse artista: ");
            var nome = read.nextLine().toLowerCase();

            System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
            var tipo = read.nextLine().toLowerCase().toUpperCase();

            TipoArtista tipoArtista = TipoArtista.valueOf(tipo);
            Artista artista = new Artista(nome, tipoArtista);

            System.out.println(artista);
            repositorio.save(artista);

            
            System.out.println("Cadastrar outro artista? (S/N)");
            cadastrar = read.nextLine().toLowerCase();

        } while (cadastrar == "s" || cadastrar == "sim");

    }

    public void CadastrarMusica() {
        System.out.println("Digite o nome de um artista: ");
        String nomeArtista = read.nextLine();

        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

        if (artista.isPresent()) {
            System.out.println("Digite o nome da musica: ");
            String nomeMusica = read.nextLine();

            var artistaEncontrado = artista.get();
            List<Musica> musica = new ArrayList<>();

            musica.add(new Musica(nomeMusica));

            artistaEncontrado.setMusicas(musica);

            repositorio.save(artistaEncontrado);

        } else {
            System.out.println("Artista não encontrado!!!!");
        }

    }

    public void ListarMusicas() {
        List<Musica> musicas = repositorio.listarMusicas();

        musicas.stream().forEach(System.out::println);
    }

    public void BuscarMusicaPorArtista() {
        System.out.println("Digite o nome do artista que quer buscar as musicas: ");
        String nomeArtista = read.nextLine();

        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

        List<Musica> musica = repositorio.BuscarMusicaPorArtista(artista.get());

        musica.stream().forEach(System.out::println);
    }

    public void obterDadosArtistas() {
        System.out.println("Digite o nome do artista para obter a informação: ");
        String nomeArtista = read.nextLine();

        String infoArtista = ConsultaChatGPT.obterInformacoes(nomeArtista);

        System.out.println(infoArtista);
    }
}
