package br.inatel.c125.projeto_final.farma;

import java.util.ArrayList;
import java.util.List;

import br.inatel.c125.projeto_final.produtos.Produto;

public class ListaFarmacias {
    private List<Farmacia> farmacias = new ArrayList<Farmacia>();

    public ListaFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }

    public void mostraTodosProdutos()
    {
        for (Farmacia farmacia : farmacias) {
			farmacia.mostraProdutos();
		}
    }

    public void mostraProdutosFarmacia(String nomeFarmacia)
    {
        boolean achou=false;
        for (Farmacia f: this.farmacias) {
            if(f.getNome().equals(nomeFarmacia))
            {
                f.mostraProdutos();
                achou = true;
                break;
            }
        }
        if(!achou)
        {
            System.out.println("Farmacia inexistente");
        }
    }

    public void procuraProdutoGeral(String nomeProduto)
    {
        List<Produto> produtosFarmaciaAtual;
        for (Farmacia f: this.farmacias) { 
            produtosFarmaciaAtual= f.procuraProduto(nomeProduto);
            if(!produtosFarmaciaAtual.isEmpty())
            {
                System.out.println(nomeProduto + " encontrado(s)(as) na farmácia " + f.getNome());
                for (Produto produto : produtosFarmaciaAtual) {
                    produto.mostraInfo();
                }
            }
            else
                System.out.println(nomeProduto + " não foi encontrado(a) na farmácia " + f.getNome());
        }

        
    }

    // GETTERS & SETTERS
    public List<Farmacia> getFarmacias() {
        return this.farmacias;
    }

    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }


}
