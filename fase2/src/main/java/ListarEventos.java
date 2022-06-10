import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ListarEventos extends JFrame {
    private JPanel painelListarEventos;
    private JTable tabelaListaEventos;
    private JPanel painelTabelaListarEventos;
    private JPanel painelTopSpacerListarEventos;
    private JPanel painelBottomSpacerListarEventos;
    private JButton btnVoltar;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;

    public ListarEventos(String title){
        super(title);

        /*LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        criarTabela(clientes);*/

        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelListarEventos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /*private void criarTabela(LinkedList<Cliente> clientes) {

        String[] cabecalhos = {"Nome", "Morada", "Género", "Data de Nascimento", "Contacto", "Email", "NIF", "Estado Profissional"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);

        for (Cliente cliente : clientes) {
            Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
            modelo.addRow(objects);
        }

        listaClientes.setModel(modelo);
        listaClientes.setEnabled(false);
        listaClientes.getTableHeader().setReorderingAllowed(false);
    }*/

    private void btnVoltarButtonActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
