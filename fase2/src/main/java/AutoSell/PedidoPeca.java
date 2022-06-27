package AutoSell;

public class PedidoPeca {
    private String local; //A quem se pede a peça
    private String tipo;
    private Peca peca;
    private int quantidadePedida;
    private String nome;

    public PedidoPeca(String local, String tipo, Peca peca, int quantidadePedida, String nome){
        this.local = local;
        this.tipo = tipo;
        this.peca = peca;
        this.quantidadePedida = quantidadePedida;
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

    public int getQuantidadePedida() {
        return quantidadePedida;
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

    public void setQuantidadePedida(int quantidadePedida) {
        this.quantidadePedida = quantidadePedida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
