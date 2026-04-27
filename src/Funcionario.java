public class Funcionario {
    // Atributos baseados no modelo lógico [cite: 83, 84, 85, 86, 87]
    private int idFuncionario;
    private String cargo;
    private double salario;
    private String turno;

    public Funcionario(int idFuncionario, String cargo, double salario, String turno) {
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
    }

    // Getters e Setters
    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    @Override
    public String toString() {
        return "Funcionário #" + idFuncionario + " (" + cargo + " - " + turno + ")";
    }
}