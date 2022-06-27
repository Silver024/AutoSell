import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

public class ListarTransacoes extends JFrame {
    private JPanel painelListaTransacoes;
    private JButton btnVoltar;
    private JTable listaTransacoes;
    private Transacao transacao;
    private DadosAplicacao dadosAplicacao;

    public ListarTransacoes(String title, DadosAplicacao dadosAplicacao) {
        super(title);


        LinkedList<Transacao> transacoes = dadosAplicacao.INSTANCIA.getTransacoes();
        criarTabela(transacoes);


        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelListaTransacoes);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


    }

    private void criarTabela(LinkedList<Transacao> transacoes) {

        String[] cabecalhos = {"Nome Cliente", "Matricula Veiculo", "Data", "Preco", "Tipo"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);

        for (Transacao transacao : transacoes) {
            Object[] objects = {transacao.getCliente(), transacao.getVeiculo(), transacao.getData(), transacao.getPreco(), transacao.getVendaCompra()};
            modelo.addRow(objects);
        }

        listaTransacoes.setModel(modelo);
        listaTransacoes.setEnabled(false);
        listaTransacoes.getTableHeader().setReorderingAllowed(false);
    }


    private void btnVoltarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }


}
