import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private double valorTotal;

    // Associações Simples (Substituem as FKs do banco de dados)
    private Mesa mesa; // Um pedido pertence a uma mesa (1:1) [cite: 41, 141]
    private Cliente cliente; // Um pedido tem um cliente [cite: 138]
    private Funcionario garcom; // Resolve a relação "registraPedido"

    // Composição
    private List<ItemPedido> itens;

    // O construtor agora exige quem é o cliente, o garçom e a mesa!
    public Pedido(int idPedido, Mesa mesa, Cliente cliente, Funcionario garcom) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.cliente = cliente;
        this.garcom = garcom;
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();

        this.mesa.ocupar(); // Regra de negócio: ao iniciar um pedido, a mesa é ocupada
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getQuantidade() >= quantidade) {
            ItemPedido novoItem = new ItemPedido(produto, quantidade);
            this.itens.add(novoItem);
            this.valorTotal += novoItem.getSubtotal();
            produto.setQuantidade(produto.getQuantidade() - quantidade);
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    // Getters
    public int getIdPedido() { return idPedido; }
    public double getValorTotal() { return valorTotal; }
    public Mesa getMesa() { return mesa; }
    public Cliente getCliente() { return cliente; }
    public Funcionario getGarcom() { return garcom; }

    public void exibirCupom() {
        System.out.println("\n==================================");
        System.out.println("CUPOM DO PEDIDO #" + idPedido);
        System.out.println("Atendente: " + garcom.getCargo() + " - ID: " + garcom.getIdFuncionario());
        System.out.println("Cliente: " + cliente.getNome() + " (Tel: " + cliente.getTelefone() + ")");
        System.out.println("Mesa: " + mesa.getNumeroMesa());
        System.out.println("----------------------------------");
        for (ItemPedido item : itens) {
            System.out.println(item.toString());
        }
        System.out.println("----------------------------------");
        System.out.println("VALOR TOTAL: R$ " + valorTotal);
        System.out.println("==================================");
    }
}