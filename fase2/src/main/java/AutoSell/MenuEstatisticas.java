package AutoSell;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

public class MenuEstatisticas extends JFrame {
    private JPanel contentPaneEstatisticas;
    private JButton btnOk;
    private JTextField textFieldClientes;
    private JTextField textFieldVeiculos;
    private JTextField textFieldPecas;
    private JTextField textFieldEventos;
    private DadosAplicacao dadosAplicacao;
    public MenuEstatisticas(String title) {
        super(title);

        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();
        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        LinkedList<Peca> pecas = dadosAplicacao.INSTANCIA.getPecas();
        LinkedList<Evento> eventos = dadosAplicacao.INSTANCIA.getEventos();

        setContentPane(contentPaneEstatisticas);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnOk.addActionListener(this::btnOkActionPerformed);

        int contadorVeiculos = 0;
        for (Veiculo veiculo : veiculos){
            contadorVeiculos ++;
        }
        textFieldVeiculos.setText(String.valueOf(contadorVeiculos));

        int contadorClientes = 0;
        for (Cliente cliente : clientes){
            contadorClientes ++;
        }
        textFieldClientes.setText(String.valueOf(contadorClientes));

        int contadorPecas = 0;
        for (Peca peca : pecas){
            contadorPecas ++;
        }
        textFieldPecas.setText(String.valueOf(contadorPecas));

        int contadorEventos = 0;
        for (Evento evento : eventos){
            contadorEventos++;
        }
        textFieldEventos.setText(String.valueOf(contadorEventos));
    }

    private void btnOkActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }



}