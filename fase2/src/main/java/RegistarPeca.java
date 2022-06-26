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


        cbSelecionarTipo.setModel(new DefaultComboBoxModel<>(TipoPeca.values()));
        cbSelecionarLocal.setModel(new DefaultComboBoxModel<>(Local.values()));

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
        validarDados();
        setVisible(false);
        toBack();
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void validarDados(){
        String nome = textFieldNome.getText();
        String quantidade = textFieldQuantidade.getText();
        String tipo = cbSelecionarTipo.getSelectedItem().toString();
        String local = cbSelecionarLocal.getSelectedItem().toString();

        if(nome.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nome: '"+ nome +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if(quantidade.isEmpty()){
            JOptionPane.showMessageDialog(null,"Quantidade: '"+ quantidade +"' inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DadosAplicacao.INSTANCIA.registarPeca(new Peca(tipo, local, nome, Integer.parseInt(quantidade)));
            JOptionPane.showMessageDialog(null,"#" + quantidade + " peças '" + nome + "' do tipo '" + tipo + "'  registadas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
