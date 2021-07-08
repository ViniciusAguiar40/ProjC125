package br.inatel.c125.projeto_final;

import java.util.ArrayList;
import java.util.List;

import br.inatel.c125.projeto_final.farma.Farmacia;
import br.inatel.c125.projeto_final.le_arquivo.LeArquivo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
	public static void main(String[] args) {
		List <Farmacia> farmacias;

		Path arquivo = Paths.get("projeto-final/farmacia.txt");

		farmacias = LeArquivo.preencheFarmacias(arquivo);
		
		for (Farmacia farmacia : farmacias) {
			farmacia.mostraProdutos();
		}
	}
}
