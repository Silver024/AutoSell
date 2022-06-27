package AutoSell;

import javax.swing.*;
import java.awt.event.*;

public class MenuVeiculos extends JFrame {
    private JPanel painelMenuVeiculos;
    private JButton btnVoltar;
    private JButton btnRegistarVeiculo;
    private JButton btnAlterarVeiculo;
    private JButton btnConsultarVeiculos;
    private JButton btnListarVeiculos;

    public DadosAplicacao dadosAplicacao;

    public MenuVeiculos(String title) {
        super(title);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        btnRegistarVeiculo.addActionListener(this::btnRegistarVeiculoActionPerformed);
        btnAlterarVeiculo.addActionListener(this:: btnAlterarVeiculoActionPerformed);
        btnConsultarVeiculos.addActionListener(this:: btnConsultarVeiculosActionPerformed);
        btnListarVeiculos.addActionListener(this::btnListarVeiculosActionPerformed);

        setContentPane(painelMenuVeiculos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void btnVoltarActionPerformed(ActionEvent e){
        setVisible(false);
        toBack();
    }

    private void btnRegistarVeiculoActionPerformed(ActionEvent e){
        new RegistarVeiculo("Registar Veículo");

    }

    private void btnListarVeiculosActionPerformed(ActionEvent e){
        new ListarVeiculos("Listar Veiculos", dadosAplicacao);

    }

    private void btnConsultarVeiculosActionPerformed(ActionEvent e){
        new ConsultarVeiculo("Consultar Veículos", dadosAplicacao);

    }

    private void btnAlterarVeiculoActionPerformed(ActionEvent e){
        new AlterarVeiculos("Alterar Veículo", dadosAplicacao);

    }


}
