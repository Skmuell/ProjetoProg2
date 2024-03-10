import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Passagem> passagens = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        carregarDados(clientes, passagens, funcionarios); 

        while (true) {
            System.out.println("Bem-vindo! Você é um Cliente ou um Funcionário?");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionário");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                System.out.println("Você já está cadastrado?");
                System.out.println("1. Sim");
                System.out.println("2. Não, quero me cadastrar");
                int cadastro = scanner.nextInt();
                if (cadastro == 1) {
                    System.out.println("Digite seu CPF:");
                    scanner.nextLine();
                    String cpf = scanner.nextLine();
                    Cliente clienteEncontrado = buscarClientePorCPF(clientes, cpf);
                    if (clienteEncontrado != null) {
                        comprarPassagem(clienteEncontrado, passagens, scanner);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                } else if (cadastro == 2) {
                    cadastrarNovoCliente(clientes);
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (escolha == 2) {
                exibirMenuFuncionario(clientes, passagens, funcionarios);
            } else if (escolha == 3) {
                salvarDados(clientes, passagens, funcionarios); 
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    public static Cliente buscarClientePorCPF(List<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf_cliente().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static void cadastrarNovoCliente(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite a idade do cliente:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, idade, cpf);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public static void comprarPassagem(Cliente cliente, List<Passagem> passagens, Scanner scanner) {
        System.out.println("Bem-vindo, " + cliente.getNome_cliente() + "!");

        System.out.println("Lista de Passagens: ");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.getId_passagem() + ". " + passagem.getNome_passagem());
        }

        System.out.println("Digite o ID da passagem que deseja comprar ou digite 0 para criar uma nova passagem:");
        int idPassagem = scanner.nextInt();

        if (idPassagem == 0) {
            scanner.nextLine();
            System.out.println("Digite o nome da nova passagem:");
            String novoNome = scanner.nextLine();
            Passagem novaPassagem = new Passagem(passagens.size() + 1, novoNome);
            passagens.add(novaPassagem);
            System.out.println("Nova passagem criada com sucesso!");
            System.out.println("Passagem comprada com sucesso!");
        } else {
            Passagem passagemEscolhida = buscarPassagemPorID(passagens, idPassagem);
            if (passagemEscolhida != null) {
                System.out.println("Passagem comprada com sucesso!");
            } else {
                System.out.println("Passagem não encontrada.");
            }
        }
    }

    public static Passagem buscarPassagemPorID(List<Passagem> passagens, int id) {
        for (Passagem passagem : passagens) {
            if (passagem.getId_passagem() == id) {
                return passagem;
            }
        }
        return null;
    }

    public static void exibirMenuFuncionario(List<Cliente> clientes, List<Passagem> passagens, List<Funcionario> funcionarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo, Funcionário!");

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Editar Passagens");
            System.out.println("2. Excluir Passagens");
            System.out.println("3. Criar Cliente");
            System.out.println("4. Editar Cliente");
            System.out.println("5. Excluir Cliente");
            System.out.println("6. Listar Passagens");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Voltar ao Menu Principal");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                editarPassagens(passagens);
            } else if (escolha == 2) {
                excluirPassagens(passagens);
            } else if (escolha == 3) {
                cadastrarNovoCliente(clientes);
            } else if (escolha == 4) {
                editarCliente(clientes);
            } else if (escolha == 5) {
                excluirCliente(clientes);
            } else if (escolha == 6) {
                listarPassagens(passagens);
            } else if (escolha == 7) {
                listarClientes(clientes);
            } else if (escolha == 8) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    public static void editarPassagens(List<Passagem> passagens) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de Passagens:");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.getId_passagem() + ". " + passagem.getNome_passagem());
        }
        System.out.println("Digite o ID da passagem que deseja editar:");
        int idPassagem = scanner.nextInt();
        Passagem passagem = buscarPassagemPorID(passagens, idPassagem);
        if (passagem != null) {
            scanner.nextLine();
            System.out.println("Digite o novo nome da passagem:");
            String novoNome = scanner.nextLine();
            passagem.setNome_passagem(novoNome);
            System.out.println("Passagem editada com sucesso.");
        } else {
            System.out.println("Passagem não encontrada.");
        }
    }

    public static void excluirPassagens(List<Passagem> passagens) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de Passagens:");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.getId_passagem() + ". " + passagem.getNome_passagem());
        }
        System.out.println("Digite o ID da passagem que deseja excluir:");
        int idPassagem = scanner.nextInt();
        Passagem passagem = buscarPassagemPorID(passagens, idPassagem);
        if (passagem != null) {
            passagens.remove(passagem);
            System.out.println("Passagem excluída com sucesso.");
        } else {
            System.out.println("Passagem não encontrada.");
        }
    }

    public static void editarCliente(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente que deseja editar:");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = buscarClientePorCPF(clientes, cpfCliente);
        if (cliente != null) {
            System.out.println("Digite o novo nome do cliente:");
            String novoNome = scanner.nextLine();
            cliente.setNome(novoNome);
            System.out.println("Digite a nova idade do cliente:");
            int novaIdade = scanner.nextInt();
            cliente.setIdade_cliente(novaIdade);
            System.out.println("Cliente editado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void excluirCliente(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente que deseja excluir:");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = buscarClientePorCPF(clientes, cpfCliente);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void listarPassagens(List<Passagem> passagens) {
        System.out.println("Lista de Passagens:");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.getId_passagem() + ". " + passagem.getNome_passagem());
        }
    }

    public static void listarClientes(List<Cliente> clientes) {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome_cliente() + ", CPF: " + cliente.getCpf_cliente());
        }
    }

    public static void salvarDados(List<Cliente> clientes, List<Passagem> passagens, List<Funcionario> funcionarios) {
        try (ObjectOutputStream clienteOutput = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
             ObjectOutputStream passagemOutput = new ObjectOutputStream(new FileOutputStream("passagens.txt"));
             ObjectOutputStream funcionarioOutput = new ObjectOutputStream(new FileOutputStream("funcionarios.txt"))) {

            clienteOutput.writeObject(clientes);
            passagemOutput.writeObject(passagens);
            funcionarioOutput.writeObject(funcionarios);

            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    public static void carregarDados(List<Cliente> clientes, List<Passagem> passagens, List<Funcionario> funcionarios) {
        try {
            ObjectInputStream clienteInput = new ObjectInputStream(new FileInputStream("clientes.txt"));
            ObjectInputStream passagemInput = new ObjectInputStream(new FileInputStream("passagens.txt"));
            ObjectInputStream funcionarioInput = new ObjectInputStream(new FileInputStream("funcionarios.txt"));

            clientes.addAll((List<Cliente>) clienteInput.readObject());
            passagens.addAll((List<Passagem>) passagemInput.readObject());
            funcionarios.addAll((List<Funcionario>) funcionarioInput.readObject());

            clienteInput.close();
            passagemInput.close();
            funcionarioInput.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
