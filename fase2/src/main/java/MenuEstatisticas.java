import org.w3c.dom.Node;

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

        setContentPane(contentPaneEstatisticas);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnOk.addActionListener(this::btnOkActionPerformed);

        int contador = 0;

        for (Veiculo veiculo : veiculos){
            contador ++;
        }
        textFieldVeiculos.setText(String.valueOf(contador));
    }

    private void btnOkActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }



}
