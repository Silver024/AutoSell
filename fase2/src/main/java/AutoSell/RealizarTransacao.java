package AutoSell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.LinkedList;

public class RealizarTransacao extends JFrame {
    private JPanel painelRealizarTransacao;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JComboBox cbCliente;
    private JTextField textFieldData;
    private JComboBox cbVeiculo;
    private JTextField textFieldPreco;
    private JTable listaClientes;
    private JComboBox cbVendaCompra;

    private DadosAplicacao dadosAplicacao;
    private Cliente cliente;
    private Veiculo veiculo;

    public RealizarTransacao(String title, DadosAplicacao dadosAplicacao) {
        super(title);
        setContentPane(painelRealizarTransacao);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        LinkedList<Veiculo> veiculos = dadosAplicacao.INSTANCIA.getVeiculos();

        for (Cliente cliente : clientes) {
            String[] clientes_nomes = {cliente.getNome()};
            String aux = clientes_nomes[0];
            cbCliente.addItem(aux);
        }

        for (Veiculo veiculo : veiculos) {
            String[] veiculos_matriculas = {veiculo.getMatricula()};
            String aux = veiculos_matriculas[0];
            cbVeiculo.addItem(aux);
        }

        cbVendaCompra.setModel(new DefaultComboBoxModel<>(TipoTransacao.values()));

        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        cbCliente.addActionListener(this::cbEditarActionPerformed);
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        setVisible(false);
        toBack();
    }

    private void cbEditarActionPerformed(ActionEvent e){
        pack();
        setVisible(true);

        LinkedList<Cliente> clientes = dadosAplicacao.INSTANCIA.getClientes();
        Object cliente_selecionado = cbCliente.getSelectedItem();
        for (Cliente cliente : clientes) {
            if((cliente.getNome()).equals(cliente_selecionado)) {
                criarTabela(cliente);
                //break;
            }
        }

    }

    private void btnGuardarActionPerformed(ActionEvent actionEvent) {
        validarDados();
        setVisible(false);
        toBack();
    }

    private void validarDados(){
        String cliente = cbCliente.getSelectedItem().toString();
        String veiculo = cbVeiculo.getSelectedItem().toString();
        String vendaCompra = cbVendaCompra.getSelectedItem().toString();

        String data = textFieldData.getText();
        String preco = textFieldPreco.getText();

        if(data.isEmpty()){
            JOptionPane.showMessageDialog(null,"Data: '"+ data +"' inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if(preco.isEmpty()){
            JOptionPane.showMessageDialog(null,"Preco: '"+ preco +"' inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DadosAplicacao.INSTANCIA.realizarTransacao(new Transacao(cliente,veiculo,vendaCompra,data,preco));
            JOptionPane.showMessageDialog(null,"Transacao  registada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void criarTabela(Cliente cliente) {

        String[] cabecalhos = {"Nome", "Morada", "Género", "Data de Nascimento", "Contacto", "Email", "NIF", "Estado Profissional"};

        DefaultTableModel modelo = new DefaultTableModel(cabecalhos,0);


        Object[] objects = {cliente.getNome(), cliente.getMorada(), cliente.getGenero(), cliente.getDataNascimento(), cliente.getContacto(), cliente.getEmail(), cliente.getnif(), cliente.getEstadoProfissional()};
        modelo.addRow(objects);


        listaClientes.setModel(modelo);
        listaClientes.setEnabled(false);
        listaClientes.getTableHeader().setReorderingAllowed(false);
    }


}
