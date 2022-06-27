package AutoSell;

import java.io.*;
import java.util.LinkedList;


public enum DadosAplicacao implements Serializable{
    INSTANCIA;
    private LinkedList<Cliente> clientes;
    private LinkedList<Veiculo> veiculos;
    private LinkedList<Evento> eventos;
    private LinkedList<Peca> pecas;
    private LinkedList<PedidoPeca> pedidosPecas;
    private LinkedList<Transacao> transacoes;

    DadosAplicacao(){
        clientes = new LinkedList<>();
        veiculos = new LinkedList<>();
        eventos = new LinkedList<>();
        pecas = new LinkedList<>();
        pedidosPecas = new LinkedList<>();
        transacoes = new LinkedList<>();
    }

    public LinkedList<Cliente> getClientes(){
    return clientes;
    }

    public LinkedList<Veiculo> getVeiculos() {
        return veiculos;
    }
    public LinkedList<Transacao> getTransacoes() {
        return transacoes;
    }


    public void registarCliente(Cliente cliente){
        if (cliente == null || clientes.contains(cliente)){
            return;
        }
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        if (cliente == null || !clientes.contains(cliente)){
            return;
        }
        clientes.remove(cliente);
    }

    public void registarVeiculo(Veiculo veiculo){
        if (veiculo == null || veiculos.contains(veiculo)){
            return;
        }
        veiculos.add(veiculo);
    }

    public LinkedList<Evento> getEventos(){
        return eventos;
    }

    public void registarEvento(Evento evento){
        if(evento == null || eventos.contains(evento)){
            return;
        }

        eventos.add(evento);
    }

    public void adicionarVeiculo(Evento evento, Veiculo veiculo) {
        if(veiculo == null || veiculos.contains(veiculo)){
            return;
        }

        veiculos.add(veiculo);
    }

    public void cancelarEvento(Evento evento){
        if(evento == null || !eventos.contains(evento)){
            return;
        }

        eventos.remove(evento);
    }

    public LinkedList<Peca> getPecas(){
        return pecas;
    }

    public void registarPeca(Peca peca){
        if(peca == null || pecas.contains(peca)){
            return;
        }

        pecas.add(peca);
    }

    public LinkedList<PedidoPeca> getPedidosPecas(){
        return pedidosPecas;
    }

    public void registarPedidoPeca(PedidoPeca pedidoPeca){
        if(pedidoPeca == null || pedidosPecas.contains(pedidoPeca)){
            return;
        }

        pedidosPecas.add(pedidoPeca);
    }

    public void removerPedidoPeca(PedidoPeca pedidoPeca){
        if(pedidoPeca == null || !pedidosPecas.contains(pedidoPeca)){
            return;
        }

        pedidosPecas.remove(pedidoPeca);
    }

    public void realizarTransacao(Transacao transacao){
        if (transacao == null || transacoes.contains(transacao)){
            return;
        }
        transacoes.add(transacao);
    }
}
