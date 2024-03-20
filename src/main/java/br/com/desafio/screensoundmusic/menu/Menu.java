package br.com.desafio.screensoundmusic.menu;

import java.util.Scanner;

import br.com.desafio.screensoundmusic.model.Artista;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Scanner read;
    private boolean valido;

    public Menu(Scanner read) {
        this.read = read;
    }

    public boolean CadastrarArtista(){
        System.out.println("***CADASTRANDO ARTISTAS***");

        System.out.println("Informe o nome desse artista: ");
        String nome = read.nextLine();

        System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
        String TipoArtista = read.nextLine().toLowerCase();

        do{
            valido = true;
            System.out.println("Cadastrar outro artista? (S/N)");
            String cadastrar = read.nextLine().toLowerCase();
    
            if(cadastrar == "n"){                
                return true;
            } else {
                return false;
            }            
        }while(valido == false);


    }
}
