package br.inatel.c125.projeto_final.produtos;

public class Remedio extends Produto{
    private String lab;
    private String tarja;

    public Remedio(String nome, float preco, String lab, String tarja) {
        super(nome, preco);
        this.lab = lab;
        this.tarja = tarja;
    }

    @Override
    public void mostraInfo() {
        System.out.printf("Remédio: %s\n", this.getNome());
        System.out.printf("Valor: R$%.2f\n", this.getPreco());
        System.out.printf("Laboratório: %s\n", this.lab);
        System.out.printf("Tarja: %s\n\n", this.tarja);
    }

    // GETTER & SETTERS
    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }
    
}
