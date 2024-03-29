package vista.veiculo;

import modelo.DadosAplicacao;
import modelo.Veiculo;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ConsultarVeiculo extends JDialog {
    private JPanel painelPrincipal;
    private JLabel lblMatricula;
    private JLabel lblMarca;
    private JButton voltarButton;
    private JComboBox comboBoxCombustivel;
    private JComboBox comboBoxTipoCaixa;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxCondicaoGeral;
    private JButton filtrarButton;
    private JList<Veiculo> listaVeiculos;
    private JButton verVeiculoButton;
    private JLabel lblModelo;
    private JLabel lblDonoAnterior;
    private JLabel lblNDonos;
    private JLabel lblCombustivel;
    private JLabel lblCategoria;
    private JLabel lblClasse;
    private JLabel lblNPortas;
    private JLabel lblPotencia;
    private JLabel lblCilindrada;
    private JLabel lblTipoCaixa;
    private JLabel lblTracao;
    private JLabel lblCondicaoGeral;
    private JLabel lblQuilometros;
    private JTextField txtQuilometros;
    private JLabel lblLocalArmazenamento;

    public ConsultarVeiculo(Frame parent, boolean modal) {
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarComboBoxMarca();
        atualizarListaVeiculo();
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        verVeiculoButton.addActionListener(this::btnVerVeiculoActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);

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

    public static void mostrarConsultarVeiculo(Frame parent) {
        ConsultarVeiculo dialog = new ConsultarVeiculo(parent, true);
        dialog.setVisible(true);
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }

    private void btnVerVeiculoActionPerformed(ActionEvent evt) {
        Veiculo veiculoSelecionado = listaVeiculos.getSelectedValue();
        if (veiculoSelecionado == null) {
            Erros.mostrarErro(this, Erros.VEICULO_NAO_SELECIONADO);
            return;
        } else {
            mostrarVeiculo(veiculoSelecionado);
        }

    }

    private void mostrarVeiculo(Veiculo veiculoSelecionado) {
        lblMatricula.setText(veiculoSelecionado.getMatricula());
        lblMarca.setText(veiculoSelecionado.getMarca());
        lblModelo.setText(veiculoSelecionado.getModelo());
        lblDonoAnterior.setText(veiculoSelecionado.getDonoAnterior());
        lblNDonos.setText(String.valueOf(veiculoSelecionado.getnDonos()));
        lblCombustivel.setText(veiculoSelecionado.getCombustivel());
        lblCategoria.setText(veiculoSelecionado.getCategoria());
        lblClasse.setText(String.valueOf(veiculoSelecionado.getClasse()));
        lblNPortas.setText(String.valueOf(veiculoSelecionado.getnPortas()));
        lblPotencia.setText(String.valueOf(veiculoSelecionado.getPotencia()));
        lblCilindrada.setText(String.valueOf(veiculoSelecionado.getCilindrada()));
        lblTipoCaixa.setText(veiculoSelecionado.getTipoDeCaixa());
        lblTracao.setText(veiculoSelecionado.getTracao());
        lblCondicaoGeral.setText(veiculoSelecionado.getCondicaoGeral());
        lblQuilometros.setText(String.valueOf(veiculoSelecionado.getQuilometros()));
        lblLocalArmazenamento.setText(veiculoSelecionado.getLocalArmazenamento());
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
}
