package vista.veiculo;

import modelo.*;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class RepararVeiculo extends JDialog {
    private JButton repararButton;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JComboBox comboBoxLocalReparacao;
    private JList<Peca> listaPecas;
    private JButton adicionarButton;
    private JTextPane textPecasUsadas;
    private JSpinner NPecasUsadas;
    private JList<Veiculo> listaVeiculos;
    private JComboBox comboBoxCombustivel;
    private JComboBox comboBoxTipoCaixa;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxCondicaoGeral;
    private JButton filtrarVeiculoButton;
    private JTextField txtFiltragemPalavras;
    private JRadioButton consumívelRadioButton;
    private JRadioButton outroRadioButton;
    private JButton filtrarPecasButton;
    private JTextField txtQuilometros;

    private String radioAnswer;

    public RepararVeiculo(Frame parent, boolean modal) {
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarComboBoxMarca();
        atualizarListaVeiculo();
        atualizarComboBoxLocalReparacao();
        atualizarListaPecas();

        filtrarVeiculoButton.addActionListener(this::btnFiltrarVeiculoActionPerformed);
        filtrarPecasButton.addActionListener(this::btnFiltrarPecasActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        repararButton.addActionListener(this::btnRepararActionPerformed);

        consumívelRadioButton.setSelected(false);
        outroRadioButton.setSelected(false);

    }

    private void atualizarComboBoxLocalReparacao() {
        Sede sede = Sede.getSede();
        comboBoxLocalReparacao.addItem(sede);
        for (Filial filial : Filial.values()) {
            comboBoxLocalReparacao.addItem(filial.displayName());
        }
    }

    private void btnFiltrarPecasActionPerformed(ActionEvent actionEvent) {
        String palavras = txtFiltragemPalavras.getText();
        String tipoPeca = radioAnswer;
        if (radioAnswer == null) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }

        String[] palavrasArray = palavras.split(" ");

        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Peca> pecas = dadosAplicacao.getPecas();

        DefaultListModel<Peca> model = new DefaultListModel<>();
        for (Peca peca : pecas) {
            if (palavras.isEmpty()) {
                if (tipoPeca.equals(peca.getTipo())) {
                    model.addElement(peca);
                }
            }else {
                    for (String palavra : palavrasArray) {
                        if (peca.getNome().contains(palavra) && peca.getTipo().equals(tipoPeca)) {
                            model.addElement(peca);
                    }
                }
            }
        }
        listaPecas.setModel(model);
    }

        private void btnAdicionarActionPerformed (ActionEvent actionEvent){
            String peca = listaPecas.getSelectedValue().toString();
            if (peca == null) {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            } else {

                textPecasUsadas.setText(textPecasUsadas.getText() + NPecasUsadas.getValue().toString() + " - " + peca + "\n");
            }
        }

        private void btnRepararActionPerformed (ActionEvent actionEvent){
            String localReparacao = comboBoxLocalReparacao.getSelectedItem().toString();
            String pecasUsadas = textPecasUsadas.getText();
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            Veiculo veiculoSelecionado = listaVeiculos.getSelectedValue();
            if (veiculoSelecionado == null) {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            } else {
                String[] pecasUsadasArray = pecasUsadas.split("\n");

                dadosAplicacao.repararVeiculo(veiculoSelecionado, pecasUsadasArray, localReparacao);

                fechar();
            }
        }

        private void btnFiltrarVeiculoActionPerformed (ActionEvent evt){
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

        public static void mostrarRepararVeiculo (Frame parent){
            RepararVeiculo dialog = new RepararVeiculo(parent, true);
            dialog.setVisible(true);
        }

        private void btnCancelarActionPerformed (ActionEvent evt){
            fechar();
        }

        private void fechar () {
            this.setVisible(false);
        }

        private void atualizarListaVeiculo () {
            List<Veiculo> veiculos = new ArrayList<>();
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            veiculos = dadosAplicacao.getVeiculos();
            DefaultListModel<Veiculo> model = new DefaultListModel<>();
            for (Veiculo veiculo : veiculos) {
                model.addElement(veiculo);
            }
            listaVeiculos.setModel(model);
        }

        private void atualizarListaPecas () {
            List<Peca> pecas = new ArrayList<>();
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            pecas = dadosAplicacao.getPecas();
            DefaultListModel<Peca> model = new DefaultListModel<>();
            for (Peca peca : pecas) {
                model.addElement(peca);
            }
            listaPecas.setModel(model);
        }

        private void atualizarComboBoxMarca () {
            List<Veiculo> veiculos = new ArrayList<>();
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            veiculos = dadosAplicacao.getVeiculos();
            List<String> marcas = new ArrayList<>();
            for (Veiculo veiculo : veiculos) {
                comboBoxMarca.addItem(veiculo.getMarca());
            }
        }

    }
