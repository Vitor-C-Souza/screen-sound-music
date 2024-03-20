
package br.com.desafio.screensoundmusic;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.desafio.screensoundmusic.menu.Menu;
import br.com.desafio.screensoundmusic.repository.ArtistaRepository;

@SpringBootApplication
public class ScreenSoundMusicApplication implements CommandLineRunner {
	@Autowired
	ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner read = new Scanner(System.in);
		
		Menu menu = new Menu(read, repositorio);

		
		boolean validacao;
		do{
			validacao = true;
			System.out.println("""
				***Screen Sound Music
	
				1- Cadastrar artistas

				0- Sair
			""");
			var opcao = Integer.parseInt(read.nextLine());
	
			switch (opcao) {
				case 1:
					validacao = menu.CadastrarArtista();					
					break;

				case 0:
					System.out.println("Finalizando o programa");
					break;
			
				default:
					System.out.println("Opção invalida!!!");
					validacao = false;
					break;
			}
		}while(validacao == false);


		read.close();


	}
}
