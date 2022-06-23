package vista.veiculo;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RepararVeiculo extends JDialog {
    private JButton repararButton;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JComboBox comboBoxLocalReparacao;
    private JList listaPecas;
    private JButton adicionarButton;
    private JTextPane textPecasUsadas;
    private JSpinner NPecasUsadas;
    private JList listaVeiculos;
    private JComboBox comboBoxCombustivel;
    private JComboBox comboBoxTipoCaixa;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxCondicaoGeral;
    private JButton fltrarButton;
    private JTextField txtFiltragemPalavras;
    private JRadioButton consumívelRadioButton;
    private JRadioButton outroRadioButton;
    private JButton filtrarButton;
    private JTextField txtQuilometros;

    public RepararVeiculo(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarComboBoxMarca();
        atualizarListaVeiculo();

        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

        String marca = comboBoxMarca.getSelectedItem().toString();
        String combustivel = comboBoxCombustivel.getSelectedItem().toString();
        String tipoCaixa = comboBoxTipoCaixa.getSelectedItem().toString();
        String condicaoGeral = comboBoxCondicaoGeral.getSelectedItem().toString();
        if (txtQuilometros.getText().isEmpty()) {
            txtQuilometros.setText("0");
        }
        Integer quilometros = Integer.parseInt(txtQuilometros.getText());

        System.out.println("quilometros: " + quilometros);
        System.out.println("marca: " + marca);
        System.out.println("combustivel: " + combustivel);
        System.out.println("tipoCaixa: " + tipoCaixa);
        System.out.println("condicaoGeral: " + condicaoGeral);

        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Veiculo> veiculos = new ArrayList<>();

        veiculos = dadosAplicacao.getVeiculos(marca, combustivel, tipoCaixa, condicaoGeral, quilometros);

        DefaultListModel<Veiculo> model = new DefaultListModel<>();
        for (Veiculo veiculo : veiculos) {
            model.addElement(veiculo);
        }
        listaVeiculos.setModel(model);
    }

    public static Veiculo mostrarRepararVeiculo(Frame parent) {
        RepararVeiculo dialog = new RepararVeiculo(parent, true);
        dialog.setVisible(true);
        return null;
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }

    private void atualizarListaVeiculo() {
        List<Veiculo> veiculos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        veiculos = dadosAplicacao.getVeiculos();
        DefaultListModel<Veiculo> model = new DefaultListModel<>();
        for (Veiculo veiculo : veiculos) {
            model.addElement(veiculo);
        }
        listaVeiculos.setModel(model);
        System.out.println("eventos: " + veiculos);
        System.out.println("model: " + model);
    }

    private void atualizarComboBoxMarca() {
        List<Veiculo> veiculos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        veiculos = dadosAplicacao.getVeiculos();
        List<String> marcas = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            comboBoxMarca.addItem(veiculo.getMarca());
        }
    }

    private void atualizarCombBoxLocalReparacao() {
        Sede sede = Sede.getSede();
        comboBoxLocalReparacao.addItem(sede);
        for (Filial filial : Filial.values()) {
            comboBoxLocalReparacao.addItem(filial.displayName());
        }
    }
}
