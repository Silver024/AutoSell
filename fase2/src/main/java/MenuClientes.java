import javax.swing.*;
import java.awt.event.*;

public class MenuClientes extends JFrame {
    private JPanel painelMenuClientes;
    private JButton btnVoltar;
    private JButton buttonCancel;
    private JButton btnConsultarTransacaoCliente;
    private JButton btnRegistarCliente;
    private JButton btnEliminarCliente;
    private JButton btnListarClientes;
    private JButton btnEditarCliente;

    public MenuClientes(String title) {
        super(title);


        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
       // btnRegistarCliente.addActionListener(this::btnRegistarClienteActionPerformed);

        setContentPane(painelMenuClientes);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    //Voltar
    private void btnVoltarActionPerformed(ActionEvent e){
        setVisible(false);
        toBack();
    }

    private void btnCriarAtletaActionPerformed(ActionEvent e){
        /* new RegistarAtleta("Criar Atleta");
        guardarDadosAtleta();

         */
    }






}
