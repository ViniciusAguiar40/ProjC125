package br.inatel.c125.projeto_final;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TesteArquivo {
    private Path arquivo;
    @Before
    public void init() {
        arquivo = Paths.get("farmacia.txt");
    }
    @Test
    public void verificaLinhaNaFormatacaoCorreta(){
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            assertNotNull(Lista);
            for (String prod : Lista) {
                String leitura[]= prod.split(";");
                
                assertTrue(leitura.length >= 5);
                // Tem que ser tipo R, U ou C    
				assertTrue((leitura[1].equals("R"))||(leitura[1].equals("U"))||(leitura[1].equals("C")));
                
                // Se for tipo R ou C -> 6 posicoes
                if(leitura[1].equals("R") || leitura[1].equals("C"))
                    assertEquals(6, leitura.length);
                else // Se for tipo U -> 5 posicoes
                    assertEquals(5, leitura.length);
                
                // leitura[2] tem que ser um numero
                // se nao for um numero, uma excecao sera lancada   
                try{
                    Float.parseFloat(leitura[2]);
                }    
                catch(NumberFormatException e){
                    assertTrue(false);
                }
            }
        }
        catch(IOException e){
            assertTrue(false);
        }
    }
}
