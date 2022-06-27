import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton btnSair;
    private JButton btnMenuVeiculos;
    private JButton btnMenuTransacao;
    private JButton btnMenuClientes;
    private JButton btnMenuEventos;
    private JButton btnMenuPecas;
    private JButton btnMenuEstatisticas;
    private JLabel Logo;
    private JButton buttonCancel;

    public MenuPrincipal(String title) {
        super(title);

        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        getRootPane().setDefaultButton(btnSair);
        setLocationRelativeTo(null);

        //sair
        btnSair.addActionListener(this::btnSairActionPerformed);


        //Menus
        btnMenuClientes.addActionListener(this::btnMenuClientesActionPerformed);
        btnMenuEventos.addActionListener(this::btnMenuEventosActionPerformed);
        btnMenuTransacao.addActionListener(this::btnMenuTransacaoActionPerformed);
        btnMenuVeiculos.addActionListener(this::btnMenuVeiculosActionPerformed);
        btnMenuPecas.addActionListener(this::btnMenuPecasActionPerformed);
        btnMenuEstatisticas.addActionListener(this::btnMenuEstatisticasActionPerformed);
    }


    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnMenuClientesActionPerformed(ActionEvent e){
        new MenuClientes("Menu Clientes");
    }

    private void btnMenuEventosActionPerformed(ActionEvent e){
        new MenuEventos("Menu Eventos");
    }

    private void btnMenuTransacaoActionPerformed(ActionEvent e){
        new MenuTransacao("Menu Transacao");
    }

    private void btnMenuVeiculosActionPerformed(ActionEvent e){
        new MenuVeiculos("Menu Veículos");
    }

    private void btnMenuPecasActionPerformed(ActionEvent e) {
        new MenuPecas("Menu Peças");
    }

    private void btnMenuEstatisticasActionPerformed(ActionEvent e){
        new MenuEstatisticas("Menu Estatísticas");
    }

    public static void main(String[] args) {
        new MenuPrincipal("AutoSell").setVisible(true);
    }

}