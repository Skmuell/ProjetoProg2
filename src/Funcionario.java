import java.io.Serializable;

public class Funcionario implements Serializable {
    private int id_funcionario;
    private String nome_funcionario;
    private int idade_funcionario;
    private String funcao_funcionario;

    public Funcionario(int id_funcionario, String nome_funcionario, int idade_funcionario, String funcao_funcionario) {
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.idade_funcionario = idade_funcionario;
        this.funcao_funcionario = funcao_funcionario;
    }

    public int getId() {
        return id_funcionario;
    }

    public void setId(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public int getIdade_funcionario() {
        return idade_funcionario;
    }

    public void setIdade_funcionario(int idade_funcionario) {
        this.idade_funcionario = idade_funcionario;
    }

    public String getFuncao_funcionario() {
        return funcao_funcionario;
    }

    public void setFuncao_funcionario(String funcao_funcionario) {
        this.funcao_funcionario = funcao_funcionario;
    }
}
