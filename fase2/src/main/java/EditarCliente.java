import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.LinkedList;

public class EditarCliente extends JFrame {
    private JPanel painelEditarCliente;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JComboBox cbEditar;
    private JTable listaClienteEditar;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    private DadosAplicacao dadosAplicacao;
    private Cliente cliente;

    public EditarCliente(String title, DadosAplicacao dadosAplicacao) {
        super(title);
        setContentPane(painelEditarCliente);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();


        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbEditar.addItem(aux);
        }

        btnCancelar.addActionListener(this::btnCancelarButtonActionPerformed);
        cbEditar.addActionListener(this::cbEditarActionPerformed);


    }

    private void btnCancelarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }

    private void cbEditarActionPerformed(ActionEvent e){
        pack();
        setVisible(true);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        Object cliente_selecionado = cbEditar.getSelectedItem();
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


        listaClienteEditar.setModel(modelo);
        listaClienteEditar.setEnabled(false);
        listaClienteEditar.getTableHeader().setReorderingAllowed(false);
    }

}
