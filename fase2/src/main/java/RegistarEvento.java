import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistarEvento extends JFrame {
    private JPanel painelRegistarEvento;
    private JPanel painelInserirDados;
    private JTextField textFieldNome;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public RegistarEvento(String title){
        super(title);
        setContentPane(painelRegistarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        //Código em falta - Guardar dados do evento
        setVisible(false);
        toBack();
    }
    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
