package br.inatel.c125.projeto_final.produtos;

public class Utensilio extends Produto{
    private String marca;
    public Utensilio(String nome, float preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    @Override
    public void mostraInfo() {
        System.out.printf("Utensílio: %s\n", this.getNome());
        System.out.printf("Valor: R$%.2f\n", this.getPreco());
        System.out.printf("Marca: %s\n\n", this.marca);
    }
    
    //GETTERS & SETTERS
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
