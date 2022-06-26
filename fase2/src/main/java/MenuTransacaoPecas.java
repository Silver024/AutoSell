import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuTransacaoPecas extends JFrame {
    private JPanel painelMenuTransacaoPecas;
    private JPanel painelBotoes;
    private JButton btnPedirPecas;
    private JButton btnPedidos;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;

    public MenuTransacaoPecas(String title){
        super(title);

        setContentPane(painelMenuTransacaoPecas);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnPedirPecas.addActionListener(this::btnPedirPecasActionPerformed);
        btnPedidos.addActionListener(this::btnPedidosActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void btnPedirPecasActionPerformed(ActionEvent actionEvent) {
        new PedirPeca("Pedir Peça");
    }

    private void btnPedidosActionPerformed(ActionEvent actionEvent) {
        new PedidosPecas("Pedidos de Peças");
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
