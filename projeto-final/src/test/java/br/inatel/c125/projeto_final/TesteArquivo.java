package br.inatel.c125.projeto_final;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
    public void verificaLeituraDoArquivo(){
        try{
            Files.readAllLines(arquivo);
        }catch(IOException e){
            // se houver uma exception, nao foi possivel abrir o arquivo
            fail();
        }
    }

    @Test
    public void verificaTipoDeProdutoValidoENumeroDeInformacoesPorLinha(){
        try{
            List <String> Lista = Files.readAllLines(arquivo);

            for (String prod : Lista) {
                String leitura[]= prod.split(";");

                // Tds tem no minimo 5 informacoes
                assertTrue(leitura.length >= 5);

                // Tem que ser tipo R, U ou C 
				assertTrue((leitura[1].equals("R"))||(leitura[1].equals("U"))||(leitura[1].equals("C")));
                
                // Se for tipo R ou C -> 6 posicoes
                if(leitura[1].equals("R") || leitura[1].equals("C"))
                    assertEquals(6, leitura.length);
                else // Se for tipo U -> 5 posicoes
                    assertEquals(5, leitura.length);
            }
        }catch(IOException e){}
    }

    @Test
    public void verificaSeOPrecoEhUmNumero(){
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            
            for (String prod : Lista) {
                String leitura[]= prod.split(";");

                // leitura[2] tem que ser um numero
                // se nao for um numero, uma exception sera lancada
                try{
                    Float.parseFloat(leitura[2]);
                }    
                catch(NumberFormatException e){
                    fail();
                }
            }
        }catch(IOException e){}
    }
}
