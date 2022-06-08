import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton btnSair;
    private JButton btnMenuVeiculos;
    private JButton btnMenuTransacoes;
    private JButton btnMenuClientes;
    private JButton btnMenuEventos;
    private JButton btnMenuPecas;
    private JButton estatisticasButton;
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
       /*
        btnMenuTransacoes.addActionListener(this::btnMenuTransacoesActionPerformed);
        btnMenuPecas.addActionListener(this::btnMenuPecasActionPerformed);
    */
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
/*
    private void btnMenuProvasActionPerformed(ActionEvent e){
        new MenuProva();
    }

    private void btnMenuAtletaActionPerformed(ActionEvent e){
        new MenuAtletas("Menu Atletas");
    }

    private void btnMenuEventosActionPerformed(ActionEvent e){
        new MenuEventos("Menu Eventos");
    }

*/

    public static void main(String[] args) {
        new MenuPrincipal("AutoSell").setVisible(true);
    }

}