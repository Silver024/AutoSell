import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistarPeca extends JFrame {
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelRegistarPeca;
    private JPanel painelSelecionarLocal;
    private JComboBox cbSelecionarLocal;
    private JPanel painelTextFields;
    private JTextField textFieldNome;
    private JTextField textFieldQuantidade;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public RegistarPeca(String title){
        super(title);

        setContentPane(painelRegistarPeca);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarTipo.addActionListener(this::cbSelecionarTipoActionPerformed);
        cbSelecionarLocal.addActionListener(this::cbSelecionarLocalActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void cbSelecionarTipoActionPerformed(ActionEvent actionEvent) {
        //Falta código para selecionar o tipo de peça
    }

    private void cbSelecionarLocalActionPerformed(ActionEvent actionEvent) {
        //Falta código para selecionar o local
    }

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        //Falta código para guardar a peça
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
