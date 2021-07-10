package br.inatel.c125.projeto_final;

import java.util.Scanner;

import br.inatel.c125.projeto_final.excecao.EntradaInesperada;
import br.inatel.c125.projeto_final.farma.ListaFarmacias;
import br.inatel.c125.projeto_final.le_arquivo.LeArquivo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
	public static void main(String[] args) {

		Path arquivo = Paths.get("farmacia.txt");

		// Lendo o arquivo e criando a lista
		ListaFarmacias farmacias = new ListaFarmacias(LeArquivo.preencheFarmacias(arquivo));

		int opcao = 0; // usado no menu
		Scanner scanner = new Scanner(System.in); // Entrada
		do{
			try {
				System.out.println("O que você deseja fazer?");
				System.out.println("1- Verificar os produtos de uma farmácia");
				System.out.println("2- Pesquisar algum produto");
				System.out.println("3- Mostrar todos os produtos disponíveis");
				System.out.println("4- Sair\n");
				// Leitura da opção escolhida
				opcao = Integer.parseInt((scanner.nextLine()));

				switch (opcao) {
					case 1:
						// Verificar os produtos de uma farmácia
						System.out.println("Digite o nome da farmácia");
						String nomeFarmacia = scanner.nextLine();
						farmacias.mostraProdutosFarmacia(nomeFarmacia);
						System.out.println("\n");
						break;
	
					case 2:
						// Pesquisar algum produto
						System.out.println("Digite o nome do produto");
						String nomeProduto = scanner.nextLine();
						farmacias.procuraProdutoGeral(nomeProduto);
						System.out.println("\n");
						break;
	
					case 3:
						// Mostrar todos os produtos disponíveis
						farmacias.mostraTodosProdutos();
						System.out.println("\n");
						break;
	
					case 4:
						// Sair
						System.out.println("Obrigado!\n");
						break;
					default:
						// Entrada inesperada, diferente de 1,2,3 e 4
						throw new EntradaInesperada();
				}
			}catch (NumberFormatException e) {
				System.out.println("Digite apenas o número da opção\n");
			}catch (EntradaInesperada e){
				System.out.println(e.getMessage());
			}	
		}while(opcao!=4);
		
		scanner.close(); // fecha o scanner
	}
}
