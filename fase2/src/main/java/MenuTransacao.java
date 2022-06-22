import javax.swing.*;
import java.awt.event.*;

public class MenuTransacao extends JFrame {
    private JPanel painelMenuTransacao;
    private JButton btnVoltar;
    private JButton btnrealizarTransacao;
    private JButton btnlistarTransacoes;

    public DadosAplicacao dadosAplicacao;

    public MenuTransacao(String title) {
        super(title);
        setContentPane(painelMenuTransacao);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnrealizarTransacao.addActionListener(this::btnRealizarTransacaoActionPerformed);

    }


//Voltar
        private void btnVoltarActionPerformed(ActionEvent e){
            setVisible(false);
            toBack();
        }

    private void btnRealizarTransacaoActionPerformed(ActionEvent e){
        new RealizarTransacao("Realizar Transacao");

    }



}
