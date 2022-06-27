package AutoSell;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuEventos extends JFrame {
    public MenuEventos(String title){
        super(title);

        btnRegistarEvento.addActionListener(this::btnRegistarEventoActionPerformed);
        btnAlterarEvento.addActionListener(this::btnAlterarEventoActionPerformed);
        btnAlterarEventoDecorrer.addActionListener(this::btnAlterarEventoDecorrerActionPerformed);
        btnConsultarEvento.addActionListener(this::btnConsultarEventoActionPerformed);
        btnListarEvento.addActionListener(this::btnListarEventosActionPerformed);
        btnCancelarEvento.addActionListener(this::btnCancelarEventoActionPerformed);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        setContentPane(painelMenuEventos);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void btnRegistarEventoActionPerformed(ActionEvent actionEvent) {
        new RegistarEvento("Registar Evento");
    }

    private void btnAlterarEventoActionPerformed(ActionEvent actionEvent) {
        new AlterarEvento("Alterar Evento");
    }

    private void btnAlterarEventoDecorrerActionPerformed(ActionEvent actionEvent) {
        new AlterarEventoDecorrer("Alterar Evento a Decorrer");
    }

    private void btnConsultarEventoActionPerformed(ActionEvent actionEvent) {
        new ConsultarEvento("Consultar Evento");
    }

    private void btnListarEventosActionPerformed(ActionEvent actionEvent) {
        new ListarEventos("Listar Eventos");
    }

    private void btnCancelarEventoActionPerformed(ActionEvent actionEvent) {
        new CancelarEvento("Cancelar Evento");
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        toBack();
    }

    private JPanel painelMenuEventos;
    private JPanel painelBotoes;
    private JButton btnRegistarEvento;
    private JButton btnAlterarEvento;
    private JButton btnAlterarEventoDecorrer;
    private JButton btnConsultarEvento;
    private JButton btnListarEvento;
    private JButton btnCancelarEvento;
    private JPanel painelBotaoVoltar;
    private JButton btnVoltar;
}
