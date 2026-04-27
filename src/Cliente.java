public class Cliente {
    // Atributos baseados no modelo lógico [cite: 90, 91]
    private String telefone; // Atua como identificador natural [cite: 122]
    private String nome;

    public Cliente(String telefone, String nome) {
        this.telefone = telefone;
        this.nome = nome;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return nome + " (Tel: " + telefone + ")";
    }
}