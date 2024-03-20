package br.com.desafio.screensoundmusic.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.desafio.screensoundmusic.model.Artista;
import br.com.desafio.screensoundmusic.repository.ArtistaRepository;

public class Menu {
    private Scanner read;
    private boolean valido;
    private ArtistaRepository repositorio;

    public Menu(Scanner read, ArtistaRepository repositorio) {
        this.read = read;
        this.repositorio = repositorio;
    }

    public boolean CadastrarArtista(){
        System.out.println("***CADASTRANDO ARTISTAS***");

        System.out.println("Informe o nome desse artista: ");
        String nome = read.nextLine();

        System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
        String TipoArtista = read.nextLine().toLowerCase();

        Artista artista = new Artista(nome, TipoArtista);

        System.out.println(artista);
        repositorio.save(artista);        


        do{
            valido = true;
            System.out.println("Cadastrar outro artista? (S/N)");
            String cadastrar = read.nextLine().toLowerCase();
    
            if(cadastrar == "n"){                
                return false;
            } else {
                return true;
            }            
        }while(valido == false);


    }
}
