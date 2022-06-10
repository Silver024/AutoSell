import java.io.Serializable;

public class Peca implements Serializable {
    private String tipo;
    private String local;
    private String nome;
    private int quantidade;

    public Peca(String tipo, String local, String nome, int quantidade){
        this.tipo = tipo;
        this.local = local;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
