import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class AlterarEventoDecorrer extends JFrame {
    private JPanel painelAlterarEventoDecorrer;
    private JPanel painelSelecionarEvento;
    private JComboBox cbSelecionarEvento;
    private JPanel painelTabela;
    private JTable tabelaAlterarEvento;
    private JPanel painelAlterarDados;
    private JTextField textFieldDataFim;
    private JPanel painelVeiculos;
    private JTextField textFieldSelecionarVeiculo;
    private JTextField textFieldTransportarVeiculo;
    private JButton btnTransporteEspecifico;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private DadosAplicacao dadosAplicacao;

    public AlterarEventoDecorrer(String title){
        super(title);
        setContentPane(painelAlterarEventoDecorrer);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();

        //Falta verificação para só aparecer eventos que já tenham começado, ou seja, com sysDate > dataInicio

        for (Evento evento : eventos) {
            String[] eventos_nomes = {evento.getNome()};
            String aux = eventos_nomes[0];
            cbSelecionarEvento.addItem(aux);
        }


        btnTransporteEspecifico.addActionListener(this::btnTransporteEspecificoActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        cbSelecionarEvento.addActionListener(this::cbSelecionarEventoActionPerformed);
    }

    private void btnTransporteEspecificoActionPerformed(ActionEvent actionEvent) {
        new TransporteEspecifico("Alterar Transporte Especifico");
    }

    private void cbSelecionarEventoActionPerformed(ActionEvent actionEvent) {
        pack();
        setVisible(true);

        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();
        Object evento_selecionado = cbSelecionarEvento.getSelectedItem();
        for (Evento evento : eventos) {
            if((evento.getNome()).equals(evento_selecionado)) {
                //Validar as datas - Pode faltar verificar se a dataInicio > dataFim
                String dateFormat = "dd/MM/uuuu";
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                        .ofPattern(dateFormat)
                        .withResolverStyle(ResolverStyle.STRICT);

                DateFormat dateFormater = new SimpleDateFormat(dateFormat);

                Date atual = Calendar.getInstance().getTime();

                String dataAtual = dateFormater.format(atual);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/uuuu");

                try {
                    if(sdf.parse(dataAtual).before(sdf.parse(evento.getDataInicio()))){
                        JOptionPane.showMessageDialog(null,"Data Inicio '"+ evento.getDataInicio() +"' inválida. O evento ainda não começou", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Erro ão verificar se as datas são válidas!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

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
