import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Simulando o banco de dados em memória para todas as entidades
    private static List<Produto> bancoProdutos = new ArrayList<>();
    private static List<Pedido> bancoPedidos = new ArrayList<>();
    private static List<Funcionario> bancoFuncionarios = new ArrayList<>();
    private static List<Cliente> bancoClientes = new ArrayList<>();
    private static List<Mesa> bancoMesas = new ArrayList<>();
    private static int contadorPedidos = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        cargaInicial(); // Preenche o sistema com dados de teste

        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DE GESTÃO DE RESTAURANTE ===");
            System.out.println("1. Cadastrar Novo Produto");
            System.out.println("2. Listar Produtos do Cardápio");
            System.out.println("3. Criar Novo Pedido (CRUD e Associações)");
            System.out.println("4. Listar Pedidos Realizados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1: cadastrarProduto(scanner); break;
                    case 2: listarProdutos(); break;
                    case 3: criarPedido(scanner); break;
                    case 4: listarPedidos(); break;
                    case 0: System.out.println("Encerrando o sistema..."); break;
                    default: System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número.");
                scanner.nextLine(); // Limpa a entrada defeituosa
            }
        }
        scanner.close();
    }

    // --- MÉTODOS AUXILIARES E CRUD ---

    private static void cargaInicial() {
        bancoProdutos.add(new Produto("7891", "Prato Feito - Frango", 25.50, 10));
        bancoProdutos.add(new Produto("7892", "Refrigerante Lata", 6.00, 50));

        bancoFuncionarios.add(new Funcionario(1, "Garçom", 1500.0, "Noturno"));
        bancoFuncionarios.add(new Funcionario(2, "Gerente", 3500.0, "Integral"));

        bancoMesas.add(new Mesa(1, 4));
        bancoMesas.add(new Mesa(2, 2));
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.println("\n-- Cadastro de Produto --");
        System.out.print("Código de Barras: ");
        String codigo = scanner.nextLine();
        System.out.print("Categoria/Nome do Prato: ");
        String categoria = scanner.nextLine();
        System.out.print("Preço Unitário (Ex: 15,50): ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade Inicial no Estoque: ");
        int qtd = scanner.nextInt();

        bancoProdutos.add(new Produto(codigo, categoria, preco, qtd));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("\n-- Cardápio / Estoque --");
        for (Produto p : bancoProdutos) {
            System.out.println(p.toString());
        }
    }

    private static void criarPedido(Scanner scanner) {
        System.out.println("\n-- Novo Pedido --");

        // 1. Associar Funcionário (Regra: Atende)
        System.out.print("ID do Atendente (Ex: 1): ");
        int idFunc = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        Funcionario garcom = buscarFuncionario(idFunc);
        if (garcom == null) {
            System.out.println("Erro: Funcionário não encontrado. Cancelando pedido.");
            return;
        }

        // 2. Associar Cliente (Regra: Faz)
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.nextLine();
        Cliente cliente = buscarCliente(telefone);
        if (cliente == null) {
            System.out.print("Cliente novo! Digite o nome para cadastro: ");
            String nome = scanner.nextLine();
            cliente = new Cliente(telefone, nome);
            bancoClientes.add(cliente);
        }

        // 3. Associar Mesa (Regra: Ocupa / Possui)
        System.out.print("Número da Mesa (Ex: 1): ");
        int numMesa = scanner.nextInt();
        scanner.nextLine();
        Mesa mesa = buscarMesa(numMesa);
        if (mesa == null || !mesa.isDisponibilidade()) {
            System.out.println("Erro: Mesa inexistente ou já ocupada. Cancelando pedido.");
            return;
        }

        // 4. Instanciar o Pedido (Composição e Associação aplicadas na prática)
        Pedido novoPedido = new Pedido(contadorPedidos++, mesa, cliente, garcom);

        // 5. Adicionar Produtos
        listarProdutos();
        boolean adicionando = true;
        while (adicionando) {
            System.out.print("\nDigite o Código de Barras do produto (ou 'sair' para finalizar): ");
            String codigo = scanner.nextLine();

            if (codigo.equalsIgnoreCase("sair")) {
                adicionando = false;
                continue;
            }

            Produto produtoEncontrado = buscarProduto(codigo);
            if (produtoEncontrado != null) {
                System.out.print("Quantidade desejada: ");
                int qtd = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                novoPedido.adicionarItem(produtoEncontrado, qtd);
            } else {
                System.out.println("Produto não encontrado.");
            }
        }

        // 6. Finalização
        if (novoPedido.getValorTotal() > 0) {
            bancoPedidos.add(novoPedido);
            novoPedido.exibirCupom();
            System.out.println("Pedido salvo com sucesso!");
        } else {
            System.out.println("Pedido vazio descartado. A mesa foi liberada.");
            mesa.liberar();
            contadorPedidos--;
        }
    }

    private static void listarPedidos() {
        System.out.println("\n-- Pedidos Registrados --");
        if (bancoPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda.");
            return;
        }
        for (Pedido p : bancoPedidos) {
            p.exibirCupom();
        }
    }

    // --- MÉTODOS DE BUSCA ---

    private static Funcionario buscarFuncionario(int id) {
        for (Funcionario f : bancoFuncionarios) {
            if (f.getIdFuncionario() == id) return f;
        }
        return null;
    }

    private static Cliente buscarCliente(String telefone) {
        for (Cliente c : bancoClientes) {
            if (c.getTelefone().equals(telefone)) return c;
        }
        return null;
    }

    private static Mesa buscarMesa(int numero) {
        for (Mesa m : bancoMesas) {
            if (m.getNumeroMesa() == numero) return m;
        }
        return null;
    }

    private static Produto buscarProduto(String codigo) {
        for (Produto p : bancoProdutos) {
            if (p.getCodigoDeBarras().equals(codigo)) return p;
        }
        return null;
    }
}