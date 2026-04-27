public class Produto {
    // Encapsulamento restrito com uso de private
    private String codigoDeBarras; // PK baseada no modelo lógico
    private String categoria;
    private double preco;
    private int quantidade; // Representa o estoque

    public Produto(String codigoDeBarras, String categoria, double preco, int quantidade) {
        this.codigoDeBarras = codigoDeBarras;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public String getCodigoDeBarras() { return codigoDeBarras; }
    public void setCodigoDeBarras(String codigoDeBarras) { this.codigoDeBarras = codigoDeBarras; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return "[" + codigoDeBarras + "] " + categoria + " - R$ " + preco + " (Estoque: " + quantidade + ")";
    }
}