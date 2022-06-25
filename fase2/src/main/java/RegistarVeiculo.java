import javax.swing.*;
import java.awt.event.*;

public class RegistarVeiculo extends JFrame {
    private JPanel painelRegistarVeiculo;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton btnCancelar;
    private JButton btnGuardar;
    private JTextField textFieldGarantia;
    private JTextField textFieldDonoAnterior;
    private JTextField textFieldMesRegisto;
    private JTextField textFieldAnoRegisto;
    private JTextField textFieldMatricula;
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

    public RegistarVeiculo(String title) {
        super(title);
        setContentPane(painelRegistarVeiculo);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }

    private void btnGuardarActionPerformed(ActionEvent e) {
        validarDados();
        setVisible(false);
        toBack();
    }

    private void validarDados() {
        String matricula = textFieldMatricula.getText();
        String marca = textFieldMarca.getText();
        String modelo = textFieldModelo.getText();
        String garantia = textFieldGarantia.getText();
        String disponibilidade = textFieldDisponibilidade.getText();
        String donoAnteiror = textFieldDonoAnterior.getText();
        String nrDonos = textFieldNrDonos.getText();
        String mesRegisto = textFieldMesRegisto.getText();
        String cilindrada = textFieldCilindrada.getText();
        String segmento = textFieldSegmento.getText();
        String anoRegisto = textFieldAnoRegisto.getText();
        String potencia = textFieldPotencia.getText();
        String nrPortas = textFieldNrPortas.getText();
        String quilometros = textFieldQuilometros.getText();
        String cor = textFieldCor.getText();
        String condicao = textFieldCondicao.getText();

        if (matricula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Matricula: '" + matricula + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (marca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Marca: '" + marca + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Modelo: '" + modelo + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (garantia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Garantia: '" + garantia + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (disponibilidade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Disponibilidade: '" + disponibilidade + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (donoAnteiror.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dono Anterior: '" + donoAnteiror + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (nrDonos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Numero de Donos: '" + nrDonos + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (mesRegisto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mes de Registo: '" + mesRegisto + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (cilindrada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cilindrada: '" + cilindrada + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (segmento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Segmento: '" + segmento + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (anoRegisto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ano Registo: '" + anoRegisto + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (potencia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Potência: '" + potencia + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (nrPortas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Número de Portas: '" + nrPortas + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (quilometros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Quilómetros: '" + quilometros + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (cor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cor: '" + cor + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if (condicao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Condição: '" + condicao + "' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);

        } else {
            DadosAplicacao.INSTANCIA.registarVeiculo(new Veiculo(matricula, marca, modelo, garantia, disponibilidade, donoAnteiror, nrDonos, mesRegisto, anoRegisto, quilometros, cilindrada, potencia, cor, segmento, nrPortas, condicao));
        }
    }
}
