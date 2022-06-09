import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ConsultarEvento extends JFrame{
    private JPanel painelConsultarEvento;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelTabela;
    private JTable tabelaAlterarEvento;
    private JButton btnVoltar;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;

    public ConsultarEvento(String title){
        super(title);

        /*LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        criarTabela(clientes);*/

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        setContentPane(painelConsultarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
