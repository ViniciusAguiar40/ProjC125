package br.inatel.c125.projeto_final.le_arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.inatel.c125.projeto_final.farma.Farmacia;
import br.inatel.c125.projeto_final.produtos.Produto;

public class LeArquivo {
    public static List <Farmacia> preencheFarmacias(Path arquivo){
        List <Farmacia> l = new ArrayList<Farmacia>();
        Map<String,List<Produto> > mapa = new HashMap<>();
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            for (String prod : Lista) {
                System.out.println(prod);
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
