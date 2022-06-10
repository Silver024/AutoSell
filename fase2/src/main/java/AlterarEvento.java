import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class AlterarEvento extends JFrame {
    private JPanel painelAlterarEvento;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelTabela;
    private JTable tabelaAlterarEvento;
    private JPanel painelAlterarDados;
    private JTextField textFieldNome;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel painelVeiculos;
    private JTextField textFieldSelecionarVeiculo;
    private JTextField textFieldTransportarVeiculo;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnTransporteEspecifico;

    private Evento evento;

    public AlterarEvento(String title){
        super(title);
        setContentPane(painelAlterarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    /* LinkedList<Evento>
        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();


        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbEditar.addItem(aux);
        }
    */

        btnTransporteEspecifico.addActionListener(this::btnTransporteEspecificoActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        cbSelecionarEvento.addActionListener(this::cbAlterarEventoActionPerformed);
    }

    private void btnTransporteEspecificoActionPerformed(ActionEvent actionEvent) {
        new TransporteEspecifico("Alterar Transporte Especifico");
    }

    private void cbAlterarEventoActionPerformed(ActionEvent actionEvent) {
    /*
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
    */
    }

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void criarTabela(Cliente cliente) {

        String[] cabecalhos = {"Nome", "DataInicio", "DataFim", "Local"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


        Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
        modelo.addRow(objects);


        tabelaAlterarEvento.setModel(modelo);
        tabelaAlterarEvento.setEnabled(false);
        tabelaAlterarEvento.getTableHeader().setReorderingAllowed(false);
    }
}
