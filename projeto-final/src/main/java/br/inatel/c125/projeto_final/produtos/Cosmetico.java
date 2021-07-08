package br.inatel.c125.projeto_final.produtos;

public class Cosmetico extends Produto{
    private String marca;
    private String tipo;

    public Cosmetico(String nome, float preco,String marca, String tipo) {
        super(nome, preco);
        this.marca=marca;
        this.tipo=tipo;
    }

    @Override
    public void mostraInfo() {
        System.out.printf("Cosmético: %s\n", this.getNome());
        System.out.printf("Valor: R$%.2f\n", this.getPreco());
        System.out.printf("Marca: %s\n", this.marca);
        System.out.printf("Tipo: %s\n\n", this.tipo);        
    }

    // GETTER & SETTERS
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
