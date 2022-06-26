import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.LinkedList;

public class ListarVeiculos extends JFrame {
    private JPanel painelMostrarVeiculos;
    private JButton btnVoltar;
    private JTable listaVeiculos;
    private Veiculo veiculo;
    private DadosAplicacao dadosAplicacao;

    public ListarVeiculos(String title, DadosAplicacao dadosAplicacao) {
        super(title);


        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        criarTabela(veiculos);

        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelMostrarVeiculos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void criarTabela(LinkedList<Veiculo> veiculos){

        String[] cabecalhos = {"Matrícula", "Marca", "Modelo", "Garantia", "Disponibilidade", "Dono Anterior", "Nr de Donos Anteriores", "Mes de Registo", "Ano Registo", "Quilómetros", "Cilindrada", "Potência", "Cor", "Segmento", "Nr de Portas", "Condição"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos, 0);

        for (Veiculo veiculo : veiculos){
            Object[] objects = {veiculo.getMatricula(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getGarantia(), veiculo.getDisponibilidade(), veiculo.getDonoAnterior(), veiculo.getNrDonos(), veiculo.getMesRegisto(), veiculo.getAnoRegisto(), veiculo.getQuilometros(), veiculo.getCilindrada(), veiculo.getPotencia(), veiculo.getCor(), veiculo.getSegmento(), veiculo.getNrPortas(), veiculo.getCondicao()};
            modelo.addRow(cabecalhos);
            modelo.addRow(objects);
        }


        listaVeiculos.setModel(modelo);
        listaVeiculos.setEnabled(false);
        listaVeiculos.getTableHeader().setReorderingAllowed(false);
    }

    private void btnVoltarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }
}
