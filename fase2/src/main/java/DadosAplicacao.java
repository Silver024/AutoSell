import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public enum DadosAplicacao implements Serializable{
    INSTANCIA;
    private LinkedList<Cliente> clientes;
    private LinkedList<Evento> eventos;
    private LinkedList<Peca> pecas;
    private LinkedList<PedidoPeca> pedidosPecas;

    DadosAplicacao(){
        clientes = new LinkedList<>();
        eventos = new LinkedList<>();
        pecas = new LinkedList<>();
        pedidosPecas = new LinkedList<>();
    }

    public LinkedList<Cliente> getClientes(){
        return clientes;
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

    public LinkedList<Evento> getEventos(){
        return eventos;
    }

    public void registarEvento(Evento evento){
     if(evento == null || eventos.contains(evento)){
         return;
     }

     eventos.add(evento);
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
}
