import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();
        int proximoIdFuncionario = 1;
        List<Passagem> passagens = new ArrayList<>();
        int proximoIdPassagem = 1;

        System.out.println("Seja bem vindo a 345 Milhas, a maior plataforma de passagens do Sudão!");

        while (true) {
            System.out.println("Digite 1 se você é um cliente, 2 se você é funcionário, 3 para operações com passagem ou 4 para sair:");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Então você é um cliente! Seja muito bem vindo a 345 milhas!");
                System.out.println("Aqui oferecemos todo o tipo de recurso para você viajar! Por um preço que cabe no seu bolso!");

                try {
                    scanner.nextLine();

                    System.out.println("Por favor digite seu nome:");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Por favor digite sua Idade:");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Por favor digite seu Cpf: ");
                    String cpfCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, idadeCliente, cpfCliente);

                    System.out.println("Informações do Cliente: ");
                    System.out.println("Nome: " + cliente.getNome_cliente());
                    System.out.println("Idade: " + cliente.getIdade_cliente());
                    System.out.println("CPF: " + cliente.getCpf_cliente());

                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao cadastrar o cliente: " + e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Então você já faz parte do time, seja muito bem vindo!");
                System.out.println("Caso queira efetuar o cadastro de sua conta no nosso ambiente aperte 1 ");
                System.out.println("Caso queira acessar sua conta aperte 2");

                int escolhaTime = scanner.nextInt();
                scanner.nextLine();

                if (escolhaTime == 1) {
                    System.out.println("Por favor digite seu nome:");
                    String nomeFuncionario = scanner.nextLine();

                    System.out.println("Por favor digite sua idade:");
                    int idadeFuncionario = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Por favor digite sua função:");
                    String cargoFuncionario = scanner.nextLine();

                    Funcionario funcionario = new Funcionario(proximoIdFuncionario++, nomeFuncionario, idadeFuncionario, cargoFuncionario);
                    funcionarios.add(funcionario);

                    System.out.println("Cadastro de funcionário realizado com sucesso! Seu ID é: " + (proximoIdFuncionario - 1));
                } else if (escolhaTime == 2) {
                    System.out.println("Por favor digite seu ID:");
                    int idFuncionario = scanner.nextInt();
                    scanner.nextLine();

                    boolean encontrado = false;
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getId() == idFuncionario) {
                            System.out.println("Bem-vindo de volta, " + funcionario.getNome() + "!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Funcionário não encontrado. Por favor, verifique o ID e tente novamente.");
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (opcao == 3) {
                operacoesPassagem(scanner, passagens, proximoIdPassagem);
                proximoIdPassagem++;
            } else if (opcao == 4) {
                System.out.println("Obrigado por escolher a 345 Milhas, até mais <3");
                break;
            } else {
                System.out.println("Comando não reconhecido. Por favor, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void operacoesPassagem(Scanner scanner, List<Passagem> passagens, int proximoIdPassagem) {
        System.out.println("Digite 1 para cadastrar passagem, 2 para editar passagem, 3 para excluir passagem ou 4 para voltar:");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            cadastrarPassagem(scanner, passagens, proximoIdPassagem);
        } else if (opcao == 2) {
            editarPassagem(scanner, passagens);
        } else if (opcao == 3) {
            excluirPassagem(scanner, passagens);
        } else if (opcao == 4) {
            // Voltar
        } else {
            System.out.println("Comando não reconhecido. Por favor, tente novamente.");
        }
    }

    private static void cadastrarPassagem(Scanner scanner, List<Passagem> passagens, int proximoIdPassagem) {
        System.out.println("Por favor digite o nome da passagem:");
        String nomePassagem = scanner.nextLine();

        Passagem passagem = new Passagem(proximoIdPassagem, nomePassagem);
        passagens.add(passagem);

        System.out.println("Passagem cadastrada com sucesso! ID: " + proximoIdPassagem);
    }

    private static void editarPassagem(Scanner scanner, List<Passagem> passagens) {
        System.out.println("Por favor digite o ID da passagem que deseja editar:");
        int idPassagem = scanner.nextInt();
        scanner.nextLine();

        boolean encontrada = false;
        for (Passagem passagem : passagens) {
            if (passagem.getId_passagem() == idPassagem) {
                System.out.println("Digite o novo nome da passagem:");
                String novoNome = scanner.nextLine();
                passagem.setNome_passagem(novoNome);
                System.out.println("Passagem editada com sucesso!");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Passagem não encontrada.");
        }
    }

    private static void excluirPassagem(Scanner scanner, List<Passagem> passagens) {
        System.out.println("Por favor digite o ID da passagem que deseja excluir:");
        int idPassagem = scanner.nextInt();
        scanner.nextLine();

        boolean removida = false;
        for (Passagem passagem : passagens) {
            if (passagem.getId_passagem() == idPassagem) {
                passagens.remove(passagem);
                System.out.println("Passagem excluída com sucesso!");
                removida = true;
                break;
            }
        }

        if (!removida) {
            System.out.println("Passagem não encontrada.");
        }
    }
}
