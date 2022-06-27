import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Arrays;
import java.util.LinkedList;

public class EliminarCliente extends JFrame {
    private JPanel painelEliminarCliente;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JComboBox cbEliminar;
    private JTable ListaClienteEliminar;


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
        String cliente_selecionado = (String) cbEliminar.getSelectedItem();
        for (Cliente cliente : clientes) {
            if((cliente.getNome()).equals(cliente_selecionado)) {
                DadosAplicacao.INSTANCIA.eliminarCliente(cliente);
                JOptionPane.showMessageDialog(null,"Cliente eliminado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                break;
            }
        }
        setVisible(false);
        toBack();
    }

    private void cbEliminarActionPerformed(ActionEvent e){
    pack();
    setVisible(true);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        Object cliente_selecionado = cbEliminar.getSelectedItem();
        for (Cliente cliente : clientes) {
            if((cliente.getNome()).equals(cliente_selecionado)) {
                criarTabela(cliente);
                //break;
            }
        }
    }


    private void criarTabela(Cliente cliente) {

        String[] cabecalhos = {"Nome", "Morada", "Género", "Data de Nascimento", "Contacto", "Email", "NIF", "Estado Profissional"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


            Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
            modelo.addRow(objects);


        ListaClienteEliminar.setModel(modelo);
        ListaClienteEliminar.setEnabled(false);
        ListaClienteEliminar.getTableHeader().setReorderingAllowed(false);
    }



}
