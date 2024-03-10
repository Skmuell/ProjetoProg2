import java.io.Serializable;

public class Passagem implements Serializable {
    private int id_passagem;
    private String nome_passagem;

    public Passagem(int id_passagem, String nome_passagem) {
        this.id_passagem = id_passagem;
        this.nome_passagem = nome_passagem;
    }

    public int getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }

    public String getNome_passagem() {
        return nome_passagem;
    }

    public void setNome_passagem(String nome_passagem) {
        this.nome_passagem = nome_passagem;
    }
}
