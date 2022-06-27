import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class RegistarEvento extends JFrame {
    private JPanel painelRegistarEvento;
    private JPanel painelInserirDados;
    private JTextField textFieldNome;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel painelVeiculos;
    private JButton btnTransporteEspecifico;
    private JComboBox cbSelecionarLocal;
    private JComboBox cbSelecionarVeiculos;
    private JComboBox cbSelecionarLocalTransporte;
    private DadosAplicacao dadosAplicacao;
    private Veiculo veiculoAdd;

    public RegistarEvento(String title){
        super(title);
        setContentPane(painelRegistarEvento);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarLocal.setModel(new DefaultComboBoxModel<>(Local.values()));
        cbSelecionarLocalTransporte.setModel(new DefaultComboBoxModel<>(Local.values()));
        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        for (Veiculo veiculo : veiculos) {
            String[] veiculosMatriculas = {veiculo.getMatricula()};
            String aux = veiculosMatriculas[0];
            cbSelecionarVeiculos.addItem(aux);
        }

        btnTransporteEspecifico.addActionListener(this::btnTransporteEspecificoActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void btnTransporteEspecificoActionPerformed(ActionEvent actionEvent) {
        new TransporteEspecifico("Registar Transporte Especifico");
    }

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        validarDados();
        setVisible(false);
        toBack();
    }
    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void validarDados(){
        String nome = textFieldNome.getText();
        String dataInicio = textFieldDataInicio.getText();
        String dataFim = textFieldDataFim.getText();
        String local = cbSelecionarLocal.getSelectedItem().toString();

        //veiculos
        String veiculoSelecionado = cbSelecionarVeiculos.getSelectedItem().toString();
        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        for(Veiculo veiculo : veiculos){
            String veiculoMatricula = veiculo.getMatricula();
            if(veiculoMatricula.equals(veiculoSelecionado)){

                veiculoAdd = new Veiculo(veiculo.getMatricula(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getGarantia(), veiculo.getDisponibilidade(),
                                         veiculo.getDonoAnterior(), veiculo.getNrDonos(), veiculo.getMesRegisto(), veiculo.getAnoRegisto(), veiculo.getQuilometros(),
                                         veiculo.getCilindrada(), veiculo.getPotencia(), veiculo.getCor(), veiculo.getSegmento(), veiculo.getNrPortas(), veiculo.getCondicao()
                );
                break;
            }
        }

        //Validar as datas - Pode faltar verificar se a dataInicio > dataFim
        String dateFormat = "dd/MM/uuuu";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);

        DateFormat dateFormater = new SimpleDateFormat(dateFormat);

        Date atual = Calendar.getInstance().getTime();

        String dataAtual = dateFormater.format(atual);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/uuuu");
        /*try {
            if(sdf.parse(dataInicio).before(sdf.parse(dataAtual))){
                JOptionPane.showMessageDialog(null,"Data Inicio: '"+ dataInicio +"' inválida. Não é possível registar um evento que já tenha começad", "Erro", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"Erro ão verificar se as datas são válidas!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }*/

        try {
            if(sdf.parse(dataFim).before(sdf.parse(dataInicio))){
                JOptionPane.showMessageDialog(null,"Data Fim: '"+ dataFim +"' inválida. O evento não pode acabar antes de começar!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch(Exception exception) {
            JOptionPane.showMessageDialog(null,"Erro ão verificar se as datas são válidas!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(nome.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nome: '"+ nome +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if(dataInicio.isEmpty()){
            JOptionPane.showMessageDialog(null,"Data Inicio: '"+ dataInicio +"' inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (dataFim.isEmpty()){
            JOptionPane.showMessageDialog(null,"Data Fim: '"+ dataFim +"' inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DadosAplicacao.INSTANCIA.registarEvento(new Evento(nome, dataInicio, dataFim, local));
            LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();
            for(Evento evento : eventos){
                String eventoNome = evento.getNome();
                if(eventoNome.equals(nome)){
                    DadosAplicacao.INSTANCIA.adicionarVeiculo(evento, veiculoAdd);
                }
            }
            JOptionPane.showMessageDialog(null,"Evento '" + nome + "' registado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            //falta veículos
        }
    }
}
