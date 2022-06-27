package AutoSell;

import java.io.Serializable;
import java.lang.ref.Cleaner;

public class Transacao implements Serializable {
    private String cliente;
    private String veiculo;
    private String data;
    private String vendaCompra;
    private String preco;

    public Transacao(String cliente, String veiculo, String data,String vendaCompra, String preco){
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.data = data;
        this.preco = preco;
        this.vendaCompra = vendaCompra;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getData() {
        return data;
    }

    public String getPreco() {
        return preco;
    }

    public String getVendaCompra() {
        return vendaCompra;
    }



    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setVendaCompra(String vendaCompra) {
        this.vendaCompra = vendaCompra;
    }

}
