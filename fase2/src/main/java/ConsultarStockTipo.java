import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ConsultarStockTipo extends JFrame{
    private JPanel painelConsultarStockTipo;
    private JPanel painelSelecionarTipo;
    private JComboBox cbSelecionarTipo;
    private JPanel painelTabela;
    private JTable tabelaConsultarStockTipo;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;
    private DadosAplicacao dadosAplicacao;
    private LinkedList<Peca> pecasValidas;

    public ConsultarStockTipo(String title){
        super(title);

        setContentPane(painelConsultarStockTipo);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarTipo.setModel(new DefaultComboBoxModel<>(TipoPeca.values()));

        pecasValidas = new LinkedList<>();

        cbSelecionarTipo.addActionListener(this::cbSelecionarTipoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void cbSelecionarTipoActionPerformed(ActionEvent actionEvent) {
        pack();
        setVisible(true);

        LinkedList<Peca> pecas = dadosAplicacao.INSTANCIA.getPecas();
        String tipoSelecionado = cbSelecionarTipo.getSelectedItem().toString();

        for(Peca peca : pecas){
            String tipoPeca = peca.getTipo();
            if(tipoPeca.equals(tipoSelecionado)){
                pecasValidas.add(peca);
            }
        }

        criarTabela(pecasValidas);
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void criarTabela(LinkedList<Peca> pecasValidas) {

        String[] cabecalhos = {"Nome", "Quantidade", "Local"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);
        modelo.addRow(cabecalhos);

        for (Peca peca : pecasValidas) {
            Object[] objects = {peca.getNome(), peca.getQuantidade(), peca.getLocal()};
            modelo.addRow(objects);
        }

        tabelaConsultarStockTipo.setModel(modelo);
        tabelaConsultarStockTipo.setEnabled(false);
        tabelaConsultarStockTipo.getTableHeader().setReorderingAllowed(false);
    }
}
