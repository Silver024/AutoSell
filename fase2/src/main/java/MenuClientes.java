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

    public DadosAplicacao dadosAplicacao;

    public MenuClientes(String title) {
        super(title);


        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnRegistarCliente.addActionListener(this::btnRegistarClienteActionPerformed);
        btnListarClientes.addActionListener(this::btnListarClienteActionPerformed);
        btnEliminarCliente.addActionListener(this::btnEliminarClienteActionPerformed);
        btnEditarCliente.addActionListener(this::btnEditarClienteActionPerformed);

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

    private void btnRegistarClienteActionPerformed(ActionEvent e){
         new RegistarCliente("Registar Cliente");
        //guardarDadosAtleta();

    }

    private void btnListarClienteActionPerformed(ActionEvent e){
        new ListarClientes("Listar Cliente", dadosAplicacao);

    }

    private void btnEliminarClienteActionPerformed(ActionEvent e){
        new EliminarCliente("Eliminar Cliente", dadosAplicacao);

    }

    private void btnEditarClienteActionPerformed(ActionEvent e){
        new EditarCliente("Editar Cliente", dadosAplicacao);

    }




}
