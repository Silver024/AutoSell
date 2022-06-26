import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class PedidosPecas extends JFrame {
    private JPanel painelPedidos;
    private JPanel painelSelecionarPedido;
    private JComboBox cbSelecionarPedido;
    private JPanel painelTextFields;
    private JTextField textFieldTipo;
    private JTextField textFieldNome;
    private JPanel painelQuantidades;
    private JTextField textFieldQuantidadePedida;
    private JTextField textFieldQuantidadeDisponivel;
    private JPanel painelBotoes;
    private JButton btnAceitarPedido;
    private JButton btnRecusarPedido;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;

    private DadosAplicacao dadosAplicacao;

    public PedidosPecas(String title){
        super(title);

        setContentPane(painelPedidos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<PedidoPeca> pedidos = dadosAplicacao.INSTANCIA.getPedidosPecas();
        for (PedidoPeca pedidoPeca : pedidos) {
            String[] pedidosNomes = {pedidoPeca.getNome()};
            String aux = pedidosNomes[0];
            cbSelecionarPedido.addItem(aux);
        }

        cbSelecionarPedido.addActionListener(this::cbSelecionarPedidoActionPerformed);
        btnAceitarPedido.addActionListener(this::btnAceitarPedidoActionPerformed);
        btnRecusarPedido.addActionListener(this::btnRecusarPedidoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void cbSelecionarPedidoActionPerformed(ActionEvent actionEvent) {
        String nomePedido = cbSelecionarPedido.getSelectedItem().toString();

        LinkedList<PedidoPeca> pedidoPecas = dadosAplicacao.INSTANCIA.getPedidosPecas();
        for(PedidoPeca pedidoPeca : pedidoPecas){
            if(pedidoPeca.getNome().equals(nomePedido)){
                textFieldTipo.setText(pedidoPeca.getTipo());
                textFieldNome.setText(pedidoPeca.getPeca().getNome());
                textFieldQuantidadePedida.setText(String.valueOf(pedidoPeca.getQuantidadePedida()));
                textFieldQuantidadeDisponivel.setText(String.valueOf(pedidoPeca.getPeca().getQuantidade()));
            }
        }
    }

    private void btnAceitarPedidoActionPerformed(ActionEvent actionEvent) {
        String nomePedido = cbSelecionarPedido.getSelectedItem().toString();

        LinkedList<PedidoPeca> pedidosPecas = dadosAplicacao.INSTANCIA.getPedidosPecas();
        for(PedidoPeca pedidoPeca : pedidosPecas){
            if((pedidoPeca.getNome()).equals(nomePedido)){
                if(pedidoPeca.getQuantidadePedida() > pedidoPeca.getPeca().getQuantidade()){
                    JOptionPane.showMessageDialog(null, "Não é possivel aceitar o pedido! Não existe stock suficiente");
                    break;
                }

                dadosAplicacao.INSTANCIA.removerPedidoPeca(pedidoPeca);
                JOptionPane.showMessageDialog(null, "Pedido aceite!");
                break;
            }
        }

        setVisible(false);
        toBack();
    }

    private void btnRecusarPedidoActionPerformed(ActionEvent actionEvent) {
        String nomePedido = cbSelecionarPedido.getSelectedItem().toString();

        LinkedList<PedidoPeca> pedidosPecas = dadosAplicacao.INSTANCIA.getPedidosPecas();
        for(PedidoPeca pedidoPeca : pedidosPecas){
            if((pedidoPeca.getNome()).equals(nomePedido)){
                DadosAplicacao.INSTANCIA.removerPedidoPeca(pedidoPeca);
                JOptionPane.showMessageDialog(null, "Pedido recusado!");
                break;
            }
        }

        setVisible(false);
        toBack();
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
