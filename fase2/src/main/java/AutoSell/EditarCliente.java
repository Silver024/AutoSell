package AutoSell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.LinkedList;

public class EditarCliente extends JFrame {
    private JPanel painelEditarCliente;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JComboBox cbEditar;
    private JTable listaClienteEditar;
    private JTextField textFieldNif;
    private JTextField textFieldContacto;
    private JTextField textFieldEstadoProfissional;
    private JTextField textFieldEmail;
    private JTextField textFieldDataNascimento;
    private JTextField textFieldGenero;
    private JTextField textFieldMorada;
    private JTextField textFieldNome;

    private DadosAplicacao dadosAplicacao;
    private Cliente cliente;

    public EditarCliente(String title, DadosAplicacao dadosAplicacao) {
        super(title);
        setContentPane(painelEditarCliente);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();


        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbEditar.addItem(aux);
        }

        btnGuardar.addActionListener(this::btnGuardarButtonActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarButtonActionPerformed);
        cbEditar.addActionListener(this::cbEditarActionPerformed);


    }

    private void btnCancelarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }

    private void cbEditarActionPerformed(ActionEvent e){
        pack();
        setVisible(true);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        Object cliente_selecionado = cbEditar.getSelectedItem();
        for (Cliente cliente : clientes) {
            if((cliente.getNome()).equals(cliente_selecionado)) {
                criarTabela(cliente);
                //break;
            }
        }

    }

    private void btnGuardarButtonActionPerformed(ActionEvent e){
        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        String cliente_selecionado = (String) cbEditar.getSelectedItem();
        for (Cliente cliente : clientes) {
            if((cliente.getNome()).equals(cliente_selecionado)) {
               if(!textFieldNome.getText().isEmpty()){
                   cliente.setNome(textFieldNome.getText());
               }
               if(!textFieldMorada.getText().isEmpty()){
                cliente.setMorada(textFieldMorada.getText());
               }
                if(!textFieldGenero.getText().isEmpty()){
                    cliente.setGenero(textFieldGenero.getText());
                }
                if(!textFieldDataNascimento.getText().isEmpty()){
                    String dateFormat = "dd/MM/uuuu";
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                            .ofPattern(dateFormat)
                            .withResolverStyle(ResolverStyle.STRICT);


                    try {
                        LocalDate date = LocalDate.parse(textFieldDataNascimento.getText(), dateTimeFormatter);
                    } catch (DateTimeParseException pe) {
                        JOptionPane.showMessageDialog(null,"Data de nascimento: '"+ textFieldDataNascimento.getText() +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    cliente.setDataNascimento(textFieldDataNascimento.getText());
                }
                if(!textFieldContacto.getText().isEmpty()){
                    try {
                        Double.parseDouble(textFieldContacto.getText());
                    } catch(NumberFormatException pe){
                        JOptionPane.showMessageDialog(null,"Contacto: '"+ textFieldContacto.getText() +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        return ;
                    }
                 cliente.setContacto(textFieldContacto.getText());
                }
                if(!textFieldNif.getText().isEmpty()){
                    try {
                        Double.parseDouble(textFieldNif.getText());
                    } catch(NumberFormatException pe){
                        JOptionPane.showMessageDialog(null,"NIF: '"+ textFieldNif.getText() +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        return ;
                    }
                 cliente.setNif(textFieldNif.getText());
                }
                if(!textFieldEstadoProfissional.getText().isEmpty()){
                 cliente.setEstadoProfissional(textFieldEstadoProfissional.getText());
                }
                if(!textFieldEmail.getText().isEmpty()){
                 cliente.setEmail(textFieldEmail.getText());
                }
            }
        }
        setVisible(false);
        toBack();
    }


    private void criarTabela(Cliente cliente) {

        String[] cabecalhos = {"Nome", "Morada", "Género", "Data de Nascimento", "Contacto", "Email", "NIF", "Estado Profissional"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


        Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
        modelo.addRow(objects);


        listaClienteEditar.setModel(modelo);
        listaClienteEditar.setEnabled(false);
        listaClienteEditar.getTableHeader().setReorderingAllowed(false);
    }

}
