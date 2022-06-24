import javax.swing.*;
import java.awt.event.*;

public class ListarTransacoes extends JFrame {
    private JPanel painelListaTransacoes;
    private JButton buttonOK;
    private JButton btnVoltar;
    private JTable listaTransacoes;
    private Transacao transacao;
    private DadosAplicacao dadosAplicacao;

    public ListarTransacoes(String title, DadosAplicacao dadosAplicacao) {
        super(title);

        btnVoltar.addActionListener(this::btnVoltarButtonActionPerformed);

        setContentPane(painelListaTransacoes);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


    }


    private void btnVoltarButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        toBack();
    }


}
