import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public enum DadosAplicacao implements Serializable{
    INSTANCIA;
    private LinkedList<Cliente> clientes;

    DadosAplicacao(){
        clientes = new LinkedList<>();
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
}
