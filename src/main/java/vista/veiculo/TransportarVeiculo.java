package vista.veiculo;

import modelo.*;
import vista.Erros;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TransportarVeiculo extends JDialog {
    private JPanel painelPrincipal;
    private JButton transportarButton;
    private JButton cancelarButton;
    private JRadioButton sedeRadioButton;
    private JRadioButton filialLocalDeExposiçãoRadioButton;
    private JComboBox comboBoxFilial;
    private JRadioButton simRadioButton;
    private JRadioButton nãoRadioButton;
    private JList<Veiculo> listaVeiculos;
    private JComboBox comboBoxCombustivel;
    private JComboBox comboBoxTipoCaixa;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxCondicaoGeral;
    private JButton filtrarButton;
    private JComboBox comboBoxLocal;
    private JTextField txtQuilometros;

    private String ondeTrasportar;

    public TransportarVeiculo(Frame parent, boolean modal) {
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        sedeRadioButton.setEnabled(false);
        filialLocalDeExposiçãoRadioButton.setEnabled(false);
        comboBoxFilial.setEnabled(false);
        comboBoxLocal.setEnabled(false);
        simRadioButton.setEnabled(false);
        nãoRadioButton.setEnabled(false);

        atualizarComboBoxMarca();
        atualizarListaVeiculo();
        atualizarCombBoxFiliais();
        atualizarCombBoxLocal();

        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        sedeRadioButton.addActionListener(this::OndeTransportarButtonActionPerformed);
        filialLocalDeExposiçãoRadioButton.addActionListener(this::OndeTransportarButtonActionPerformed);
        simRadioButton.addActionListener(this::TransportarparaLocalForaActionPerformed);
        nãoRadioButton.addActionListener(this::TransportarparaLocalForaActionPerformed);
        listaVeiculos.addListSelectionListener(this::veiculoSelecionadoActionPerformed);
        transportarButton.addActionListener(this::btnTransportarActionPerformed);
        comboBoxFilial.addActionListener(this::FilialSelecionadaActionPerformed);
        comboBoxLocal.addActionListener(this::LocalSelecionadoActionPerformed);

    }

    private void LocalSelecionadoActionPerformed(ActionEvent actionEvent) {
        if (comboBoxLocal.getSelectedItem() != null) {
            ondeTrasportar = comboBoxLocal.getSelectedItem().toString();
        }
    }

    private void FilialSelecionadaActionPerformed(ActionEvent actionEvent) {
        if (filialLocalDeExposiçãoRadioButton.isSelected()) {
            ondeTrasportar = comboBoxFilial.getSelectedItem().toString();
        }
    }

    private void veiculoSelecionadoActionPerformed(ListSelectionEvent listSelectionEvent) {
        if (listaVeiculos.getSelectedIndex() != -1) {
            sedeRadioButton.setEnabled(true);
            filialLocalDeExposiçãoRadioButton.setEnabled(true);
        }
    }

    private void btnTransportarActionPerformed(ActionEvent evt) {
        Veiculo veiculoSelecionado = listaVeiculos.getSelectedValue();
        if (veiculoSelecionado == null) {
            Erros.mostrarErro(this, Erros.VEICULO_NAO_SELECIONADO);
            return;
        } else {
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            dadosAplicacao.transportarVeiculo(veiculoSelecionado, ondeTrasportar);
            fechar();
        }

    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        String marca = comboBoxMarca.getSelectedItem().toString();
        String combustivel = comboBoxCombustivel.getSelectedItem().toString();
        String tipoCaixa = comboBoxTipoCaixa.getSelectedItem().toString();
        String condicaoGeral = comboBoxCondicaoGeral.getSelectedItem().toString();
        if (txtQuilometros.getText().isEmpty()) {
            txtQuilometros.setText("0");
        }
        Integer quilometros = Integer.parseInt(txtQuilometros.getText());

        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Veiculo> veiculos = new ArrayList<>();

        veiculos = dadosAplicacao.getVeiculos(marca, combustivel, tipoCaixa, condicaoGeral, quilometros);

        DefaultListModel<Veiculo> model = new DefaultListModel<>();
        for (Veiculo veiculo : veiculos) {
            model.addElement(veiculo);
        }
        listaVeiculos.setModel(model);
    }

    public static void mostrarTransportarVeiculo(Frame parent) {
        TransportarVeiculo dialog = new TransportarVeiculo(parent, true);
        dialog.setVisible(true);
    }


    private void OndeTransportarButtonActionPerformed(ActionEvent actionEvent) {
        if (filialLocalDeExposiçãoRadioButton.isSelected()) {
            comboBoxFilial.setEnabled(true);
            simRadioButton.setEnabled(true);
            nãoRadioButton.setEnabled(true);
            ondeTrasportar = comboBoxFilial.getSelectedItem().toString();
        }else {
            ondeTrasportar = "Sede";
        }
    }

    private void TransportarparaLocalForaActionPerformed(ActionEvent actionEvent) {
        if (simRadioButton.isSelected()) {
            comboBoxLocal.setEnabled(true);
            comboBoxFilial.setEnabled(false);
            ondeTrasportar = comboBoxLocal.getSelectedItem().toString();
        }
        if (nãoRadioButton.isSelected()) {
            comboBoxLocal.setEnabled(false);
            comboBoxFilial.setEnabled(true);
            ondeTrasportar = comboBoxFilial.getSelectedItem().toString();
        }
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

    private void atualizarCombBoxFiliais() {
        comboBoxFilial.removeAllItems();
        for (Filial filial : Filial.values()) {
            comboBoxFilial.addItem(filial.displayName());
        }
    }

    private void atualizarCombBoxLocal() {
        comboBoxLocal.removeAllItems();
        List<LocalExposicao> localExposicaos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicaos = dadosAplicacao.getLocalExposicoes();


        for (LocalExposicao localExposicao : localExposicaos) {
            comboBoxLocal.addItem(localExposicao.displayName());
        }
    }

}
