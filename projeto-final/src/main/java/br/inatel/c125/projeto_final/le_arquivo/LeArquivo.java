package br.inatel.c125.projeto_final.le_arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.inatel.c125.projeto_final.farma.Farmacia;
import br.inatel.c125.projeto_final.produtos.Cosmetico;
import br.inatel.c125.projeto_final.produtos.Produto;
import br.inatel.c125.projeto_final.produtos.Remedio;
import br.inatel.c125.projeto_final.produtos.Utensilio;

public class LeArquivo {
    public static List <Farmacia> preencheFarmacias(Path arquivo){
        List <Farmacia> lista = new ArrayList<Farmacia>();
		Farmacia farmacia;
        Map<String,List<Produto> > mapa = new HashMap<>();
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            for (String prod : Lista) {
				String leitura[]= prod.split(";");
				farmacia = new Farmacia(leitura[0]);
				Produto novoProduto;
				if(leitura[1].equals("R")) // Se for remedio
				{
					novoProduto = new Remedio(leitura[3], Float.parseFloat(leitura[2]),leitura[4], leitura[5]);
				}
				else if(leitura[1].equals("U"))
				{
					novoProduto = new Utensilio(leitura[3], Float.parseFloat(leitura[2]), leitura[4]);
				}
				else // leitura[1] = "C"
				{
					novoProduto = new Cosmetico(leitura[3], Float.parseFloat(leitura[2]), leitura[4], leitura[5]);
				}
				
				if(!mapa.containsKey(farmacia.getNome())) // Se eu não tenho a chave "farmacia tal"
					mapa.put(farmacia.getNome(), new ArrayList<>()); // Crio a "Farmacia tal"

				mapa.get(farmacia.getNome()).add(novoProduto);
            }

			// Aqui eu já separei as farmacias em um mapa, vou redistribuir numa lista
			for (String chave : mapa.keySet()) {
				farmacia= new Farmacia(chave);
				farmacia.setProdutos(mapa.get(chave));
				lista.add(farmacia);
			}
        }
        catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
        return lista;
    }
}
