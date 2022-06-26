import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class PedirPeca extends JFrame {
    private JPanel painelPedirPecas;
    private JPanel painelSelecionarLocal;
    private JComboBox cbSelecionarLocal;
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelSelecionarPeca;
    private JComboBox cbSelecionarPeca;
    private JPanel painelTextField;
    private JTextField textFieldQuantidade;
    private JPanel painelBotoes;
    private JButton btnEfetuarPedido;
    private JButton btnCancelar;
    private JTextField textFieldNome;
    private DadosAplicacao dadosAplicacao;
    private Peca pecaPedida;

    public PedirPeca(String title){
        super(title);

        setContentPane(painelPedirPecas);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarLocal.setModel(new DefaultComboBoxModel<>(Local.values()));
        cbSelecionarTipo.setModel(new DefaultComboBoxModel<>(TipoPeca.values()));

        LinkedList<Peca> pecas = dadosAplicacao.INSTANCIA.getPecas();

        for (Peca peca : pecas) {
            String[] pecasNomes = {peca.getNome()};
            String aux = pecasNomes[0];
            cbSelecionarPeca.addItem(aux);
        }

        btnEfetuarPedido.addActionListener(this::btnEfetuarPedidoActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void btnEfetuarPedidoActionPerformed(ActionEvent actionEvent) {
        validarDados();
        setVisible(false);
        toBack();
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void validarDados(){
        String local = cbSelecionarLocal.getSelectedItem().toString();
        String tipo = cbSelecionarTipo.getSelectedItem().toString();
        String nomePeca = cbSelecionarPeca.getSelectedItem().toString();
        int quantidade = Integer.parseInt(textFieldQuantidade.getText());
        String nomePedido = textFieldNome.getText();

        pecaPedida = new Peca(tipo, local, nomePeca, quantidade);

        if(nomePedido.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nome: '"+ nomePedido +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if(quantidade <= 0){
            JOptionPane.showMessageDialog(null,"Quantidade: '"+ quantidade +"' inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DadosAplicacao.INSTANCIA.registarPedidoPeca(new PedidoPeca(local, tipo, pecaPedida, quantidade, nomePedido));
            JOptionPane.showMessageDialog(null,"#" + quantidade + " peças '" + nomePeca + "' do tipo '" + tipo + "'  pedidas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
