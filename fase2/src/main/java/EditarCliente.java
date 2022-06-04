import javax.swing.*;
import java.awt.event.*;

public class EditarCliente extends JFrame {
    private JPanel painelEditarCliente;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JComboBox comboBox1;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    public EditarCliente(String title, DadosAplicacao dadosAplicacao) {
        super(title);


        btnCancelar.addActionListener(this::btnCancelarButtonActionPerformed);


        setContentPane(painelEditarCliente);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void btnCancelarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }


}
