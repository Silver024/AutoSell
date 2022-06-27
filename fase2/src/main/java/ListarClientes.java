import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.LinkedList;

public class ListarClientes extends JFrame {
    private JPanel painelListarClientes;
    private JButton btnVoltar;
    private JTable listaClientes;
    private Cliente cliente;
    private DadosAplicacao dadosAplicacao;

    public ListarClientes(String title, DadosAplicacao dadosAplicacao) {



        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        criarTabela(clientes);

        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelListarClientes);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void criarTabela(LinkedList<Cliente> clientes) {

        String[] cabecalhos = {"Nome", "Morada", "Género", "Data de Nascimento", "Contacto", "Email", "NIF", "Estado Profissional"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);

        for (Cliente cliente : clientes) {
            Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
            modelo.addRow(objects);
        }

        listaClientes.setModel(modelo);
        listaClientes.setEnabled(false);
        listaClientes.getTableHeader().setReorderingAllowed(false);
    }

        private void btnVoltarButtonActionPerformed(ActionEvent e) {
            setVisible(false);
            toBack();
        }




}
