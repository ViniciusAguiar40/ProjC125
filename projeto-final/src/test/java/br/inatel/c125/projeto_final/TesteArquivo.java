package br.inatel.c125.projeto_final;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class TesteArquivo {
    private Path arquivo;
    
    @Test
    public void verificaExceptionArquivoNaoExistente(){
        arquivo = Paths.get("um-arquivo-inexistente-oh-ceus-oh-vida.txt");
        
    }

    @Test
    public void verificaLinhaNaFormatacaoCorreta(){
        arquivo = Paths.get("projeto-final/farmacia.txt");
        try{
            List <String> Lista = Files.readAllLines(arquivo);
            for (String prod : Lista) {
                System.out.println(prod);
            }
        }
        catch(IOException e){
            System.out.println("Erro na leitura: " + e.getMessage());
        }
    }
}
