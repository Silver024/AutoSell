import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class CancelarEvento extends JFrame {
    private JPanel painelCancelarEvento;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelBotoes;
    private JButton btnCancelar;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;
    private JPanel painelTabela;
    private JTable tabelaListaEvento;

    public CancelarEvento(String title){
        super(title);

        setContentPane(painelCancelarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        /* LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();

//Show name of clients in combobox
        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbEliminar.addItem(aux);
        }
*/

        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {

    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    /*private void criarTabela(Cliente cliente) {

        String[] cabecalhos = {"Nome", "Morada", "Género", "Data de Nascimento", "Contacto", "Email", "NIF", "Estado Profissional"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


        Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
        modelo.addRow(objects);


        ListaClienteEliminar.setModel(modelo);
        ListaClienteEliminar.setEnabled(false);
        ListaClienteEliminar.getTableHeader().setReorderingAllowed(false);
    }*/
}
