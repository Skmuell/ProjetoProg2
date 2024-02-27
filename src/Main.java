import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite o ID do funcionário: ");
        int funcionarioId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do funcionário: ");
        String funcionarioNome = scanner.nextLine();
        System.out.println("Digite a idade do funcionário: ");
        int funcionarioIdade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a função do funcionário: ");
        String funcionarioFuncao = scanner.nextLine();

        Funcionario funcionario = new Funcionario(funcionarioId, funcionarioNome, funcionarioIdade, funcionarioFuncao);

        System.out.println("Digite o ID da passagem: ");
        int passagemId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome da passagem: ");
        String passagemNome = scanner.nextLine();
        LocalDateTime passagemDataLocal = LocalDateTime.now();//AQUI TEM EXELASDIYHGASDSA

        Passagem passagem = new Passagem(passagemId, passagemNome, passagemDataLocal);

        System.out.println("Digite o nome do cliente: ");
        String clienteNome = scanner.nextLine();
        System.out.println("Digite a idade do cliente: ");
        int clienteIdade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String clienteCpf = scanner.nextLine();

        Cliente cliente = new Cliente(clienteNome, clienteIdade, clienteCpf);

        System.out.println("Informações do Funcionário: ");
        System.out.println("ID: " + funcionario.getId());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Idade: " + funcionario.getIdade());
        System.out.println("Função: " + funcionario.getFuncao());
        System.out.println();

        System.out.println("Informações da Passagem: ");
        System.out.println("ID: " + passagem.id);
        System.out.println("Nome: " + passagem.nome);
        System.out.println("Data: " + passagem.dataLocal);
        System.out.println();

        System.out.println("Informações do Cliente: ");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Idade: " + cliente.getIdade());
        System.out.println("CPF: " + cliente.getCpf());

        scanner.close();
    }
}
