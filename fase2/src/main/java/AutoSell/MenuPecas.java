package AutoSell;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPecas extends JFrame{
    private JPanel painelMenuPecas;
    private JButton btnRegistarPeca;
    private JButton btnConsultarStockLocal;
    private JButton btnConsultarStockTipo;
    private JButton btnTransacaoPecas;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;

    public MenuPecas(String title){
        super(title);

        setContentPane(painelMenuPecas);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnRegistarPeca.addActionListener(this::btnRegistarPecaActionPerformed);
        btnConsultarStockLocal.addActionListener(this::btnConsultarStockLocalActionPerformed);
        btnConsultarStockTipo.addActionListener(this::btnConsultarTipoLocalActionPerformed);
        btnTransacaoPecas.addActionListener(this::btnTransacaoPecasActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void btnRegistarPecaActionPerformed(ActionEvent actionEvent) {
        new RegistarPeca("Registar Peça");
    }

    private void btnConsultarStockLocalActionPerformed(ActionEvent actionEvent) {
        new ConsultarStockLocal("Consultar Stock por Local");
    }

    private void btnConsultarTipoLocalActionPerformed(ActionEvent actionEvent) {
        new ConsultarStockTipo("Consultar Stock por Tipo");
    }

    private void btnTransacaoPecasActionPerformed(ActionEvent actionEvent) {
        new MenuTransacaoPecas("Menu Transação de Peças");
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
