public class PedidoPeca {
    private String local; //A quem se pede a peça
    private String tipo;
    private Peca peca;
    private int quantidade;
    private String nome;

    public PedidoPeca(String local, String tipo, Peca peca, int quantidade, String nome){
        this.local = local;
        this.tipo = tipo;
        this.peca = peca;
        this.quantidade = quantidade;
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public String getTipo() {
        return tipo;
    }
    public Peca getPeca() {
        return peca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
