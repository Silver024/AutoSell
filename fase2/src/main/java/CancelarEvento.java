import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class CancelarEvento extends JFrame {
    private JPanel painelCancelarEvento;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelBotoes;
    private JButton btnCancelar;
    private JPanel painelVoltar;
    private JPanel painelBtnVoltar;
    private JButton btnVoltar;
    private JPanel painelTabela;
    private JTable tabelaListaEvento;

    private DadosAplicacao dadosAplicacao;

    public CancelarEvento(String title){
        super(title);

        setContentPane(painelCancelarEvento);
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

        cbSelecionarEvento.addActionListener(this::cbSelecionarEventoActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
    }

    private void cbSelecionarEventoActionPerformed(ActionEvent actionEvent) {
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

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();
        String evento_selecionado = (String) cbSelecionarEvento.getSelectedItem();
        for (Evento evento : eventos) {
            if((evento.getNome()).equals(evento_selecionado)) {
                DadosAplicacao.INSTANCIA.cancelarEvento(evento);
                JOptionPane.showMessageDialog(null,"Evento '" + evento_selecionado + "' cancelado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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

    private void criarTabela(Evento evento) {

        String[] cabecalhos = {"Nome", "Data Inicio", "Data Fim", "Local"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


        Object[] objects = {evento.getNome(), evento.getDataInicio(), evento.getDataFim(), evento.getLocal()};
        modelo.addRow(objects);


        tabelaListaEvento.setModel(modelo);
        tabelaListaEvento.setEnabled(false);
        tabelaListaEvento.getTableHeader().setReorderingAllowed(false);
    }
}
