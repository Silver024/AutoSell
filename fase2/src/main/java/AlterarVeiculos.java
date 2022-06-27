import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.LinkedList;

public class AlterarVeiculos extends JFrame {
    private JPanel contentPane;
    private JButton btnCancelar;
    private JButton btnGuardar;
    private JComboBox cbAlterar;
    private JTable listaVeiculoEditar;
    private JTextField textFieldGarantia;
    private JTextField textFieldMesRegisto;
    private JTextField textFieldAnoRegisto;
    private JTextField textFieldDisponibilidade;
    private JTextField textFieldNrDonos;
    private JTextField textFieldCilindrada;
    private JTextField textFieldSegmento;
    private JTextField textFieldPotencia;
    private JTextField textFieldNrPortas;
    private JTextField textFieldQuilometros;
    private JTextField textFieldCor;
    private JTextField textFieldCondicao;
    private JComboBox cbDonoAnterior;

    private DadosAplicacao dadosAplicacao;
    private Veiculo veiculo;

    public AlterarVeiculos(String title, DadosAplicacao dadosAplicacao) {
        super(title);
        setContentPane(contentPane);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();

        for (Veiculo veiculo : veiculos){
            String[] veiculos_matriculas = {veiculo.getMatricula()};
            String aux = veiculos_matriculas[0];
            cbAlterar.addItem(aux);
        }
        for(Cliente cliente : clientes){
            String[] clientesNomes = {cliente.getNome()};
            String aux = clientesNomes[0];
            cbDonoAnterior.addItem(aux);
        }

        btnGuardar.addActionListener(this::btnGuardarButtonActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarButtonActionPerformed);
        cbAlterar.addActionListener(this::cbAlterarActionPerformed);
    }

    private void btnCancelarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }

    private void cbAlterarActionPerformed(ActionEvent e){
        pack();
        setVisible(true);

        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        Object veiculo_selecionado = cbAlterar.getSelectedItem();
        for (Veiculo veiculo : veiculos) {
            if((veiculo.getMatricula()).equals(veiculo_selecionado)) {
                criarTabela(veiculo);
                textFieldGarantia.setText(veiculo.getGarantia());
                cbDonoAnterior.setSelectedItem(veiculo.getDonoAnterior());
                textFieldMesRegisto.setText(veiculo.getMesRegisto());
                textFieldAnoRegisto.setText(veiculo.getAnoRegisto());
                textFieldDisponibilidade.setText(veiculo.getDisponibilidade());
                textFieldNrDonos.setText(veiculo.getNrDonos());
                textFieldCilindrada.setText(veiculo.getCilindrada());
                textFieldSegmento.setText(veiculo.getSegmento());
                textFieldPotencia.setText(veiculo.getPotencia());
                textFieldNrPortas.setText(veiculo.getNrPortas());
                textFieldQuilometros.setText(veiculo.getQuilometros());
                textFieldCor.setText(veiculo.getCor());
                textFieldCondicao.setText(veiculo.getCondicao());
                //break;
            }
        }

    }

    private void btnGuardarButtonActionPerformed(ActionEvent e){
        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        String veiculo_selecionado = (String) cbAlterar.getSelectedItem();
        for (Veiculo veiculo : veiculos) {
            if((veiculo.getMatricula()).equals(veiculo_selecionado)) {

                if(!textFieldGarantia.getText().isEmpty()){
                    veiculo.setGarantia(textFieldGarantia.getText());
                }
                if(!cbDonoAnterior.getSelectedItem().toString().isEmpty()){
                    veiculo.setDonoAnterior(cbDonoAnterior.getSelectedItem().toString());
                }
                if(!textFieldMesRegisto.getText().isEmpty()){
                    veiculo.setMesRegisto(textFieldMesRegisto.getText());
                }

                if(!textFieldAnoRegisto.getText().isEmpty()){
                    veiculo.setAnoRegisto(textFieldAnoRegisto.getText());
                }
                if(!textFieldDisponibilidade.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldDisponibilidade.getText());
                }
                if(!textFieldNrDonos.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldNrDonos.getText());
                }
                if(!textFieldCilindrada.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldCilindrada.getText());
                }
                if(!textFieldSegmento.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldSegmento.getText());
                }
                if(!textFieldPotencia.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldPotencia.getText());
                }
                if(!textFieldNrPortas.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldNrPortas.getText());
                }
                if(!textFieldQuilometros.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldQuilometros.getText());
                }
                if(!textFieldCor.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldCor.getText());
                }
                if(!textFieldCondicao.getText().isEmpty()){
                    veiculo.setDisponibilidade(textFieldCondicao.getText());
                }

            }
        }
        setVisible(false);
        toBack();
    }

    private void criarTabela(Veiculo veiculo){

        String[] cabecalhos = {"Matrícula", "Marca", "Modelo", "Garantia", "Disponibilidade", "Dono Anterior", "Nr de Donos Anteriores", "Mes de Registo", "Ano Registo", "Quilómetros", "Cilindrada", "Potência", "Cor", "Segmento", "Nr de Portas", "Condição"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos, 0);

        Object[] objects = {veiculo.getMatricula(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getGarantia(), veiculo.getDisponibilidade(), veiculo.getDonoAnterior(), veiculo.getNrDonos(), veiculo.getMesRegisto(), veiculo.getAnoRegisto(), veiculo.getQuilometros(), veiculo.getCilindrada(), veiculo.getPotencia(), veiculo.getCor(), veiculo.getSegmento(), veiculo.getNrPortas(), veiculo.getCondicao()};
        modelo.addRow(cabecalhos);
        modelo.addRow(objects);
        modelo.addRow(new Object[]{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,});

        listaVeiculoEditar.setModel(modelo);
        listaVeiculoEditar.setEnabled(false);
        listaVeiculoEditar.getTableHeader().setReorderingAllowed(false);
    }

}