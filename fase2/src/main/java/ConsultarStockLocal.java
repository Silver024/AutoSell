import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConsultarStockLocal extends JFrame{
    private JPanel painelConsultarStockLocal;
    private JPanel painelSelecionarLocal;
    private JComboBox cbSelecionarLocal;
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelTabela;
    private JTable tabelaConsultarStockLocal;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;

    public ConsultarStockLocal(String title){
        super(title);

        setContentPane(painelConsultarStockLocal);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarLocal.addActionListener(this::cbSelecionarLocalActionPerformed);
        cbSelecionarTipo.addActionListener(this::cbSelecionarTipoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void cbSelecionarLocalActionPerformed(ActionEvent actionEvent) {
        //Falta Codigo
    }

    private void cbSelecionarTipoActionPerformed(ActionEvent actionEvent) {
        //Falta Codigo
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
