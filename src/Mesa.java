public class Mesa {
    // Atributos baseados no modelo lógico [cite: 100, 101]
    private int numeroMesa;
    private int capacidade;
    private boolean disponibilidade;

    public Mesa(int numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.disponibilidade = true; // Por padrão, começa disponível
    }

    public int getNumeroMesa() { return numeroMesa; }
    public void setNumeroMesa(int numeroMesa) { this.numeroMesa = numeroMesa; }
    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }
    public boolean isDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }

    // Método de negócio para alterar o status da mesa
    public void ocupar() { this.disponibilidade = false; }
    public void liberar() { this.disponibilidade = true; }

    @Override
    public String toString() {
        String status = disponibilidade ? "Disponível" : "Ocupada";
        return "Mesa " + numeroMesa + " [Capacidade: " + capacidade + "] - Status: " + status;
    }
}