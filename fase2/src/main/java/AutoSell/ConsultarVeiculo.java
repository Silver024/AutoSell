package AutoSell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.LinkedList;

public class ConsultarVeiculo extends JFrame {
    private JPanel contentPane;
    private JButton btnOK;
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
    private JTextField textFieldMarca;
    private JTextField textFieldModelo;
    private JComboBox cbMatricula;
    private JTable listaVeiculoConsultar;
    private JTextField textFieldDonoAnterior;

    private DadosAplicacao dadosAplicacao;
    private Veiculo veiculo;

    public ConsultarVeiculo(String title, DadosAplicacao dadosAplicacao){
        super(title);
        setContentPane(contentPane);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();

        for(Veiculo veiculo : veiculos){
            String [] veiculos_matriculas = {veiculo.getMatricula()};
            String aux = veiculos_matriculas[0];
            cbMatricula.addItem(aux);
        }

        btnOK.addActionListener(this::btnOkButtonActionPerformed);
        cbMatricula.addActionListener(this::cbMatriculaActionPerformed);
    }

    private void btnOkButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }

    private void cbMatriculaActionPerformed(ActionEvent e) {
        pack();
        setVisible(true);

        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        Object veiculo_selecionado = cbMatricula.getSelectedItem();
        for (Veiculo veiculo : veiculos) {
            if ((veiculo.getMatricula()).equals(veiculo_selecionado)) {
                criarTabela(veiculo);
                textFieldGarantia.setText(veiculo.getGarantia());
                textFieldDonoAnterior.setText(veiculo.getDonoAnterior());
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
                textFieldMarca.setText(veiculo.getMarca());
                textFieldModelo.setText(veiculo.getModelo());
                //break;
            }
        }

    }

    private void criarTabela(Veiculo veiculo) {

        String[] cabecalhos = {"Matrícula", "Marca", "Modelo", "Garantia", "Disponibilidade", "Dono Anterior", "Nr de Donos Anteriores", "Mes de Registo", "Ano Registo", "Quilómetros", "Cilindrada", "Potência", "Cor", "Segmento", "Nr de Portas", "Condição"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos, 0);

        Object[] objects = {veiculo.getMatricula(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getGarantia(), veiculo.getDisponibilidade(), veiculo.getDonoAnterior(), veiculo.getNrDonos(), veiculo.getMesRegisto(), veiculo.getAnoRegisto(), veiculo.getQuilometros(), veiculo.getCilindrada(), veiculo.getPotencia(), veiculo.getCor(), veiculo.getSegmento(), veiculo.getNrPortas(), veiculo.getCondicao()};
        modelo.addRow(cabecalhos);
        modelo.addRow(objects);
        modelo.addRow(new Object[]{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,});


        listaVeiculoConsultar.setModel(modelo);
        listaVeiculoConsultar.setEnabled(false);
        listaVeiculoConsultar.getTableHeader().setReorderingAllowed(false);
    }


}
