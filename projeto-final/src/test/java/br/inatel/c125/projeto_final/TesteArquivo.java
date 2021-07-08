package br.inatel.c125.projeto_final;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class TesteArquivo {
    public Path arquivo;
    // TODO
    
    @Test
    public void verificaLinhaNaFormatacaoCorreta(){
        arquivo = Paths.get("projeto-final/farmacia.txt");
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            assertNotNull(Lista);
            for (String prod : Lista) {
                String leitura[]= prod.split(";");
                
                // Todos tem no minimo 5 posicoes
                for(int i = 0;i < 5; i++)
                    assertNotNull(leitura[i]);
                // Tem que ser tipo R, U ou C    
				assertTrue((leitura[1] == "R")||(leitura[1] == "U")||(leitura[1] == "C"));
                
                // Se for tipo R ou U -> 6 posicoes
                if(leitura[1] == "R" || leitura[1] == "C"){
                    assertNotNull(leitura[5]);
                    assertNull(leitura[6]);
                }
                else // Se for tipo C -> 5 posicoes
                    assertNull(leitura[5]);
                
                // leitura[2] tem que ser um numero
                // se nao for um numero, uma excecao sera lancada   
                try{
                    Float.parseFloat(leitura[2]);
                }    
                catch(NumberFormatException e){
                    assertFalse(true);
                }
            }
        }
        catch(IOException e){
            assertFalse(true);
        }
    }
}
