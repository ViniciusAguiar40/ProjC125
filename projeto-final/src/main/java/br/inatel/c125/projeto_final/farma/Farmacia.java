package br.inatel.c125.projeto_final.farma;
import java.util.ArrayList;
import java.util.List;
import br.inatel.c125.projeto_final.produtos.*;

public class Farmacia {
    private String nome;
    private List <Produto> produtos = new ArrayList<Produto>();

    public Farmacia(String nome) {
        this.nome = nome;
    }

    public void addProduto(Produto novoProduto){
        produtos.add(novoProduto);
    }

    public void mostraProdutos(){
        System.out.println("Produtos da farmácia " + this.nome);
        for (Produto produto : produtos) {
            produto.mostraInfo();
        }
    }

    public void procuraProduto(String nomeProduto){
        for (Produto produto : produtos) {
            if(produto.getNome().equals(nomeProduto))
                produto.mostraInfo();
        }
    }

    // GETTERS & SETTERS
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


}
