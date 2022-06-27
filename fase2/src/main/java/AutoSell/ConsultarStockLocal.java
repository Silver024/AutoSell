package AutoSell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ConsultarStockLocal extends JFrame{
    private JPanel painelConsultarStockLocal;
    private JPanel painelSelecionarLocal;
    private JComboBox cbSelecionarLocal;
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelTabela;
    private JTable tabelaConsultarStockLocal;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;
    private JPanel painelBotao;
    private JButton btnConsultar;
    private DadosAplicacao dadosAplicacao;
    private LinkedList<Peca> pecasValidas;

    public ConsultarStockLocal(String title){
        super(title);

        setContentPane(painelConsultarStockLocal);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarLocal.setModel(new DefaultComboBoxModel<>(Local.values()));
        cbSelecionarTipo.setModel(new DefaultComboBoxModel<>(TipoPeca.values()));

        pecasValidas = new LinkedList<>();

        cbSelecionarLocal.addActionListener(this::cbSelecionarLocalActionPerformed);
        cbSelecionarTipo.addActionListener(this::cbSelecionarTipoActionPerformed);
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void btnConsultarActionPerformed(ActionEvent actionEvent) {
        pack();
        setVisible(true);

        LinkedList<Peca> pecas = dadosAplicacao.INSTANCIA.getPecas();
        String tipoSelecionado = cbSelecionarTipo.getSelectedItem().toString();
        String localSelecionado = cbSelecionarLocal.getSelectedItem().toString();

        for(Peca peca : pecas){
            String localPeca = peca.getLocal();
            if(localPeca.equals(localSelecionado)){
                String tipoPeca = peca.getTipo();
                if(tipoPeca.equals(tipoSelecionado)){
                    pecasValidas.add(peca);
                }
            }
        }

        criarTabela(pecasValidas);
    }

    private void cbSelecionarLocalActionPerformed(ActionEvent actionEvent) {

    }

    private void cbSelecionarTipoActionPerformed(ActionEvent actionEvent) {

    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void criarTabela(LinkedList<Peca> pecasValidas) {
        String[] cabecalhos = {"Nome", "Quantidade"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);
        modelo.addRow(cabecalhos);

        for (Peca peca : pecasValidas) {
            Object[] objects = {peca.getNome(), peca.getQuantidade()};
            modelo.addRow(objects);
        }

        tabelaConsultarStockLocal.setModel(modelo);
        tabelaConsultarStockLocal.setEnabled(false);
        tabelaConsultarStockLocal.getTableHeader().setReorderingAllowed(false);
    }
}
