import java.time.LocalDateTime;

public class Passagem {
    int id;
    String nome;
    LocalDateTime dataLocal = LocalDateTime.now();

    public Passagem(int id, String nome, LocalDateTime dataLocal) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataLocal = dataLocal;
    }
}
