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
        List <Farmacia> l = new ArrayList<Farmacia>();
		Farmacia aux;
        Map<String,List<Produto> > mapa = new HashMap<>();
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            for (String prod : Lista) {
                //System.out.println(prod);
				String leitura[]= prod.split(";");
				aux = new Farmacia(leitura[0]);
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
				
				if(!mapa.containsKey(aux.getNome())) // Se eu não tenho a chave "farmacia tal"
					mapa.put(aux.getNome(), new ArrayList<>()); // Crio a "Farmacia tal"

				mapa.get(aux.getNome()).add(novoProduto);
            }

			// Aqui eu já separei as farmacias em um mapa, vou redistribuir numa lista
			for (String chave : mapa.keySet()) {
				aux= new Farmacia(chave);
				aux.setProdutos(mapa.get(chave));
				l.add(aux);
			}
        }
        catch(IOException e){
            System.out.println("Erro na leitura: " + e.getMessage());
        }
        return l;
    }
    /*
    public static List <Atividade> LeituraTxt(Path arquivo) {
		List <Atividade> ListaAtividades = new ArrayList <>();
		NumberFormat total = DecimalFormat.getNumberInstance();
		total.setMaximumFractionDigits(2);
		try {
			List <String> atividades = Files.readAllLines(arquivo);
			atividades.remove(0);
			atividades.forEach((descricao) -> {
				String[] dados = descricao.split(";");
				StringBuilder hora = new StringBuilder();
				hora.append(dados[3]).append("h");
				
				if(Integer.parseInt(dados[4]) < 10)
					hora.append("0");
				hora.append(Integer.parseInt(dados[4])).append("min");
				
				if(Integer.parseInt(dados[5]) < 10)
					hora.append("0");
				hora.append(Integer.parseInt(dados[5])).append("seg");
				
				ListaAtividades.add(new Atividade(dados[0], dados[1], 
						Double.parseDouble(dados[2].replace(",", ".")), hora.toString(), 
						Integer.parseInt(dados[6]), Integer.parseInt(dados[7]), dados[8], dados[9]));
			});
		} catch (IOException erro) {
			System.out.println("Erro no arquivo!\n");
		}
		return ListaAtividades;
	}
    
    */
}
