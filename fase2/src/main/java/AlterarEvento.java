import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.LinkedList;

public class AlterarEvento extends JFrame {
    private JPanel painelAlterarEvento;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelTabela;
    private JTable tabelaAlterarEvento;
    private JPanel painelAlterarDados;
    private JTextField textFieldNome;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel painelVeiculos;
    private JTextField textFieldSelecionarVeiculo;
    private JTextField textFieldTransportarVeiculo;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnTransporteEspecifico;
    private JComboBox cbSelecionarLocal;

    private Evento evento;
    private DadosAplicacao dadosAplicacao;

    public AlterarEvento(String title){
        super(title);
        setContentPane(painelAlterarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarLocal.setModel(new DefaultComboBoxModel<>(Local.values()));

        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();

        for (Evento evento : eventos) {
            String[] eventos_nomes = {evento.getNome()};
            String aux = eventos_nomes[0];
            cbSelecionarEvento.addItem(aux);
        }

        btnTransporteEspecifico.addActionListener(this::btnTransporteEspecificoActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        cbSelecionarEvento.addActionListener(this::cbAlterarEventoActionPerformed);
    }

    private void btnTransporteEspecificoActionPerformed(ActionEvent actionEvent) {
        new TransporteEspecifico("Alterar Transporte Especifico");
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

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();
        String evento_selecionado = (String) cbSelecionarEvento.getSelectedItem();
        for (Evento evento : eventos) {
            if((evento.getNome()).equals(evento_selecionado)) {
                if(!textFieldNome.getText().isEmpty()){
                    evento.setNome(textFieldNome.getText());
                }
                if(!textFieldDataInicio.getText().isEmpty()){
                    String dateFormat = "dd/MM/uuuu";
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                            .ofPattern(dateFormat)
                            .withResolverStyle(ResolverStyle.STRICT);
                    try {
                        LocalDate date = LocalDate.parse(textFieldDataInicio.getText(), dateTimeFormatter);
                    } catch (DateTimeParseException pe) {
                        JOptionPane.showMessageDialog(null,"Data de nascimento: '"+ textFieldDataInicio.getText() +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    evento.setDataInicio(textFieldDataInicio.getText());
                }
                if(!textFieldDataFim.getText().isEmpty()){
                    String dateFormat = "dd/MM/uuuu";
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                            .ofPattern(dateFormat)
                            .withResolverStyle(ResolverStyle.STRICT);
                    try {
                        LocalDate date = LocalDate.parse(textFieldDataFim.getText(), dateTimeFormatter);
                    } catch (DateTimeParseException pe) {
                        JOptionPane.showMessageDialog(null,"Data de nascimento: '"+ textFieldDataFim.getText() +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    evento.setDataFim(textFieldDataFim.getText());
                }
                evento.setLocal(cbSelecionarLocal.getSelectedItem().toString());

                JOptionPane.showMessageDialog(null,"Evento '" + evento_selecionado + "' alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        setVisible(false);
        toBack();
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void criarTabela(Evento evento) {

        String[] cabecalhos = {"Nome", "Data Inicio", "Data Fim", "Local"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


        Object[] objects = {evento.getNome(), evento.getDataInicio(), evento.getDataFim(), evento.getLocal()};
        modelo.addRow(objects);


        tabelaAlterarEvento.setModel(modelo);
        tabelaAlterarEvento.setEnabled(false);
        tabelaAlterarEvento.getTableHeader().setReorderingAllowed(false);
    }
}
