package AutoSell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class TransporteEspecifico extends JFrame {
    private JPanel painelTransporteEspecifico;
    private JPanel painelBotoes;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel painelVeiculos;
    private JPanel painelSelecionarVeiculo;
    private JComboBox cbSelecionarVeiculo;
    private JComboBox cbSelecionarLocalParaTransporte;
    private JPanel painelSelecionarLocalParaTransporte;
    private DadosAplicacao dadosAplicacao;

    public TransporteEspecifico(String title){
        super(title);

        setContentPane(painelTransporteEspecifico);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        cbSelecionarLocalParaTransporte.setModel(new DefaultComboBoxModel<>(Local.values()));
        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        for (Veiculo veiculo : veiculos) {
            String[] veiculosMatriculas = {veiculo.getMatricula()};
            String aux = veiculosMatriculas[0];
            cbSelecionarVeiculo.addItem(aux);
        }

        cbSelecionarVeiculo.addActionListener(this::cbSelecionarVeiculoActionPerformed);
        cbSelecionarLocalParaTransporte.addActionListener(this::cbSelecionarLocalParaTransporteActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private void cbSelecionarLocalParaTransporteActionPerformed(ActionEvent actionEvent) {
        //Falta código - Mostrar lista de locais disponiveis para transporte especifico
    }

    private void cbSelecionarVeiculoActionPerformed(ActionEvent actionEvent) {
        //Falta código - Mostrar lista de veiculos disponiveis para transporte especifico
    }

    private void btnCancelarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        //Falta código para guardar
        setVisible(false);
        toBack();
    }
}
