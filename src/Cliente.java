public class Cliente {
    private String nome_cliente;
    private int idade_cliente;
    private String cpf_cliente;

    public Cliente(String nome_cliente, int idade_cliente, String cpf_cliente) {
        super();
        this.nome_cliente = nome_cliente;
        this.idade_cliente = idade_cliente;
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getIdade_cliente() {
        return idade_cliente;
    }

    public void setIdade_cliente(int idade_cliente) {
        this.idade_cliente = idade_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
}
