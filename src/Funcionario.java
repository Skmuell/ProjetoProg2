public class Funcionario {
    private int id;
    private String nome;
    private int idade;
    private String funcao;

    public Funcionario(int id, String nome, int idade, String funcao) {
        super();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }

    public String getNome() {
        return nome;

    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public int getIdade() {
        return idade;

    }

    public void setIdade(int idade) {
        this.idade = idade;

    }

    public String getFuncao() {
        return funcao;

    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;

    }
}
