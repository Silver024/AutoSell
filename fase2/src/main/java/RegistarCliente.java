import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

public class RegistarCliente extends JFrame {
    private JPanel getPainelRegistarCliente;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JTextField textFieldNome;
    private JTextField textFieldMorada;
    private JTextField textFieldGenero;
    private JTextField textFieldDataNascimento;
    private JTextField textFieldContacto;
    private JTextField textFieldEmail;
    private JTextField textFieldNif;
    private JTextField textFieldEstadoProfissional;
    private JPanel painelRegistarCliente;



    public RegistarCliente(String title) {
        super(title);
        setContentPane(painelRegistarCliente);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        //dadosAplicacao = new DadosAplicacao();

        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        setVisible(false);
        toBack();
    }

    private void btnGuardarActionPerformed(ActionEvent e){
        validarDados();
        setVisible(false);
        toBack();
    }

    private void validarDados(){
        String nome = textFieldNome.getText();
        String morada = textFieldMorada.getText();
        String genero = textFieldGenero.getText();
        String dataNascimento = textFieldDataNascimento.getText();
        String contacto = textFieldContacto.getText();
        String nif = textFieldNif.getText();
        String estadoProfissional = textFieldEstadoProfissional.getText();
        String email = textFieldEmail.getText();

//verify date format
        String dateFormat = "dd/MM/uuuu";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(dataNascimento, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null,"Data de nascimento: '"+ dataNascimento +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        return;
        }

        //verify if nif is a number
        try {
            Double.parseDouble(nif);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"NIF: '"+ nif +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return ;
        }

        //verify if contacto is a number
        try {
            Double.parseDouble(contacto);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Contacto: '"+ contacto +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return ;
        }


        if (nome.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nome: '"+ nome +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (morada.isEmpty()){
            JOptionPane.showMessageDialog(null,"Morada: '"+ morada +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (genero.isEmpty()){
            JOptionPane.showMessageDialog(null,"Género: '"+ genero +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (dataNascimento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data de nascimento: '" + dataNascimento + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (contacto.isEmpty()){
            JOptionPane.showMessageDialog(null,"Contacto: '"+ contacto +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (email.isEmpty()){
            JOptionPane.showMessageDialog(null,"Email: '"+ email +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (nif.isEmpty()){
            JOptionPane.showMessageDialog(null,"NIF: '"+ nif +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (estadoProfissional.isEmpty()){
            JOptionPane.showMessageDialog(null,"Estado Profissional: '"+ estadoProfissional +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);

        } else {
            DadosAplicacao.INSTANCIA.registarCliente(new Cliente(nome,morada,genero,dataNascimento,contacto,email,nif,estadoProfissional));
            JOptionPane.showMessageDialog(null,"Cliente  registado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }
    }



}
