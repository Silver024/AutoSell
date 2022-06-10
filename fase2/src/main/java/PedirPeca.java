import javax.swing.*;
import java.awt.event.ActionEvent;

public class PedirPeca extends JFrame {
    private JPanel painelPedirPecas;
    private JPanel painelSelecionarLocal;
    private JComboBox cbSelecionarLocal;
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelSelecionarPeca;
    private JComboBox cbSelecionarPeca;
    private JPanel painelTextField;
    private JTextField textFieldQuantidade;
    private JPanel painelBotoes;
    private JButton btnEfetuarPedido;
    private JButton btnCancelar;

    public PedirPeca(String title){
        super(title);

        setContentPane(painelPedirPecas);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnEfetuarPedido.addActionListener(this::btnEfetuarPedidoActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void btnEfetuarPedidoActionPerformed(ActionEvent actionEvent) {

    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
