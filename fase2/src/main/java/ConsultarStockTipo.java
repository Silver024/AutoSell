import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConsultarStockTipo extends JFrame{
    private JPanel painelConsultarStockTipo;
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelTabela;
    private JTable tabelaConsultarStockTipo;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;

    public ConsultarStockTipo(String title){
        super(title);

        setContentPane(painelConsultarStockTipo);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarTipo.addActionListener(this::cbSelecionarTipoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void cbSelecionarTipoActionPerformed(ActionEvent actionEvent) {
        //Falta Codigo
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
