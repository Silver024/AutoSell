import javax.swing.*;
import java.awt.event.*;

public class RealizarTransacao extends JFrame {
    private JPanel painelRealizarTransacao;
    private JButton buttonOK;
    private JButton btnCancelar;
    private JComboBox comboBox1;
    private JCheckBox compraCheckBox;
    private JCheckBox vendaCheckBox;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTable table1;

    public RealizarTransacao(String title) {
        super(title);
        setContentPane(painelRealizarTransacao);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        setVisible(false);
        toBack();
    }


}
