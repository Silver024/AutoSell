import javax.swing.*;
import java.awt.event.ActionEvent;

public class PedidosPecas extends JFrame {
    private JPanel painelPedidos;
    private JPanel painelSelecionarPedido;
    private JComboBox cbSelecionarPedido;
    private JPanel painelTextFields;
    private JTextField textFieldTipo;
    private JTextField textFieldNome;
    private JPanel painelQuantidades;
    private JTextField textFieldQuantidadePedida;
    private JTextField textFieldQuantidadeDisponivel;
    private JPanel painelBotoes;
    private JButton btnAceitarPedido;
    private JButton btnRecusarPedido;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;

    public PedidosPecas(String title){
        super(title);

        setContentPane(painelPedidos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnAceitarPedido.addActionListener(this::btnAceitarPedidoActionPerformed);
        btnRecusarPedido.addActionListener(this::btnRecusarPedidoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void btnAceitarPedidoActionPerformed(ActionEvent actionEvent) {

    }

    private void btnRecusarPedidoActionPerformed(ActionEvent actionEvent) {

    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
