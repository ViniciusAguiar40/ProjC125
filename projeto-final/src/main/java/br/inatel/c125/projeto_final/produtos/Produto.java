package br.inatel.c125.projeto_final.produtos;

public abstract class Produto {
    private String nome;
    private float preco;
    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public abstract void mostraInfo();

    // GETTER & SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
