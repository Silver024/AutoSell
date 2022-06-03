import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.LinkedList;

public class EliminarCliente extends JFrame {
    private JPanel painelEliminarCliente;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JComboBox cbEliminar;


    private DadosAplicacao dadosAplicacao;
    private Cliente cliente;

    public EliminarCliente(String title, DadosAplicacao dadosAplicacao) {
        super(title);
        setContentPane(painelEliminarCliente);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();

//Show name of clients in combobox
        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbEliminar.addItem(aux);
        }





        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        cbEliminar.addActionListener(this::cbEliminarActionPerformed);
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        setVisible(false);
        toBack();
    }

    private void btnEliminarActionPerformed(ActionEvent e){
        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
       // Cliente clienteEliminar;
        String cliente_selecionado = (String) cbEliminar.getSelectedItem();
        for (Cliente cliente : clientes) {
            if((cliente.getNome()).equals(cliente_selecionado)) {
                String nome = cliente.getNome();
                String morada = cliente.getMorada();
                String genero = cliente.getGenero();
                String dataNascimento = cliente.getDataNascimento();
                String contacto = cliente.getContacto();
                String nif = cliente.getnif();
                String estadoProfissional = cliente.getEstadoProfissional();
                String email = cliente.getEmail();

                //DadosAplicacao.INSTANCIA.eliminarCliente(new Cliente(nome,morada,genero,dataNascimento,contacto,nif,estadoProfissional,email));
                DadosAplicacao.INSTANCIA.eliminarCliente(cliente);
                break;
            }
        }




   // DadosAplicacao.INSTANCIA.eliminarCliente(Cliente(nome,morada,genero,dataNascimento,contacto,nif,estadoProfissional,email));

        setVisible(false);
        toBack();
    }

    private void cbEliminarActionPerformed(ActionEvent e){
    pack();
    setVisible(true);

    }


}
