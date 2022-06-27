package AutoSell;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

public class ConsultarTransacoesCliente extends JFrame {
    private JPanel painelTransacoesCliente;
    private JButton btnVoltar;
    private JComboBox cbCliente;
    private JTable listaTransacoes;

    private DadosAplicacao dadosAplicacao;

    public ConsultarTransacoesCliente(String title, DadosAplicacao dadosAplicacao) {
        super(title);


        LinkedList<Transacao> transacoes = dadosAplicacao.INSTANCIA.getTransacoes();
        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();

        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbCliente.addItem(aux);
        }

        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelTransacoesCliente);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);




    }




    private void btnVoltarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }

}
