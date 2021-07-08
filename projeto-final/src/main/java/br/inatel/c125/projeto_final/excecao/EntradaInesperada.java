package br.inatel.c125.projeto_final.excecao;

public class EntradaInesperada extends RuntimeException{
    public EntradaInesperada(){
        super();
    }

    @Override
    public String getMessage() {
        return "Digite um número entre 1 e 4, inclusive!\n";
    }
}
