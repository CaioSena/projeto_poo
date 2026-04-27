public class ItemPedido {
    private Produto produto; // Associação com Produto
    private int quantidade;
    private double precoUnitario; // Salva o preço histórico da venda

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        // Pega o preço no momento exato em que o item é instanciado
        this.precoUnitario = produto.getPreco();
    }

    public double getSubtotal() {
        return this.quantidade * this.precoUnitario;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }

    @Override
    public String toString() {
        return quantidade + "x " + produto.getCategoria() + " | Unidade: R$ " + precoUnitario + " | Subtotal: R$ " + getSubtotal();
    }
}