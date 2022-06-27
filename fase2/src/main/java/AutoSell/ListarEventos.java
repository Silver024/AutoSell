package AutoSell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ListarEventos extends JFrame {
    private JPanel painelListarEventos;
    private JTable tabelaListaEventos;
    private JPanel painelTabelaListarEventos;
    private JPanel painelTopSpacerListarEventos;
    private JPanel painelBottomSpacerListarEventos;
    private JButton btnVoltar;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;

    private DadosAplicacao dadosAplicacao;

    public ListarEventos(String title){
        super(title);

        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();
        criarTabela(eventos);

        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelListarEventos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void criarTabela(LinkedList<Evento> eventos) {

        String[] cabecalhos = {"Nome", "Data Inicio", "Data Fim", "Local"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);
        modelo.addRow(cabecalhos);

        for (Evento evento : eventos) {
            Object[] objects = {evento.getNome(), evento.getDataInicio(), evento.getDataFim(), evento.getLocal()};
            modelo.addRow(objects);
        }

        tabelaListaEventos.setModel(modelo);
        tabelaListaEventos.setEnabled(false);
        tabelaListaEventos.getTableHeader().setReorderingAllowed(false);
    }

    private void btnVoltarButtonActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }
}
