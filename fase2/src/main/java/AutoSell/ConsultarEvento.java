package AutoSell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ConsultarEvento extends JFrame{
    private JPanel painelConsultarEvento;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelTabela;
    private JTable tabelaConsultarEvento;
    private JButton btnVoltar;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private DadosAplicacao dadosAplicacao;

    public ConsultarEvento(String title){
        super(title);

        setContentPane(painelConsultarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();

        for (Evento evento : eventos) {
            String[] eventos_nomes = {evento.getNome()};
            String aux = eventos_nomes[0];
            cbSelecionarEvento.addItem(aux);
        }

        cbSelecionarEvento.addActionListener(this::cbAlterarEventoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void cbAlterarEventoActionPerformed(ActionEvent actionEvent) {
        pack();
        setVisible(true);

        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();
        Object evento_selecionado = cbSelecionarEvento.getSelectedItem();
        for (Evento evento : eventos) {
            if((evento.getNome()).equals(evento_selecionado)) {
                criarTabela(evento);
                //break;
            }
        }
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void criarTabela(Evento evento) {

        String[] cabecalhos = {"Nome", "Data Inicio", "Data Fim", "Local"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);

        Object[] objects = {evento.getNome(), evento.getDataInicio(), evento.getDataFim(), evento.getLocal()};
        modelo.addRow(cabecalhos);
        modelo.addRow(objects);

        tabelaConsultarEvento.setModel(modelo);
        tabelaConsultarEvento.setEnabled(false);
        tabelaConsultarEvento.getTableHeader().setReorderingAllowed(false);
    }

}
