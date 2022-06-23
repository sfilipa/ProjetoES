package vista.veiculo;

import modelo.DadosAplicacao;
import modelo.Evento;
import modelo.Veiculo;
import vista.Erros;
import vista.eventos.EditarEvento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditarVeiculo extends JDialog {
    private JButton editarButton;
    private JPanel painelPrincipal;
    private JTextField txtmodelo;
    private JButton cancelarButton;
    private JTextField txtmatricula;
    private JTextField txtmarca;
    private JTextField txtdonoAnterior;
    private JTextField txtnDonos;
    private JTextField txtcategoria;
    private JTextField txtclasse;
    private JTextField txtnPortas;
    private JTextField txtpotencia;
    private JTextField txtcilindrada;
    private JRadioButton gasolinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton elétricoRadioButton;
    private JRadioButton automáticaRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton traseiraRadioButton;
    private JRadioButton muitoBomRadioButton;
    private JRadioButton bomRadioButton;
    private JRadioButton médioRadioButton;
    private JRadioButton mauRadioButton;
    private JRadioButton muitoMauRadioButton;
    private JList<Veiculo> listaVeiculos;
    private JComboBox comboBoxCombustivel;
    private JComboBox comboBoxTipoCaixa;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxCondicaoGeral;
    private JButton filtrarButton;
    private JTextField txtquilometros;
    private JTextField txtQuilometrosFiltro;

    private String tipoCaixa;
    private String combustivel;
    private String tracao;
    private String condicaoGeral;

    public EditarVeiculo(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarListaVeiculo();
        atualizarComboBoxMarca();

        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        automáticaRadioButton.addActionListener(this::tipoCaixaButtonActionPerformed);
        manualRadioButton.addActionListener(this::tipoCaixaButtonActionPerformed);
        gasolinaRadioButton.addActionListener(this::combustivelButtonActionPerformed);
        dieselRadioButton.addActionListener(this::combustivelButtonActionPerformed);
        elétricoRadioButton.addActionListener(this::combustivelButtonActionPerformed);
        fronteiraRadioButton.addActionListener(this::tracaoButtonActionPerformed);
        traseiraRadioButton.addActionListener(this::tracaoButtonActionPerformed);
        muitoBomRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        bomRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        médioRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        mauRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        muitoMauRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);

    }
    private void condicaoGeralButtonActionPerformed(ActionEvent actionEvent) {
        if (mauRadioButton.isSelected()) {
            condicaoGeral = manualRadioButton.getText();
        } else if (médioRadioButton.isSelected()) {
            condicaoGeral = médioRadioButton.getText();
        } else if (bomRadioButton.isSelected()) {
            condicaoGeral = bomRadioButton.getText();
        } else if (muitoBomRadioButton.isSelected()) {
            condicaoGeral = muitoBomRadioButton.getText();
        } else if (muitoMauRadioButton.isSelected()) {
            condicaoGeral = muitoMauRadioButton.getText();
        }
    }

    private void tracaoButtonActionPerformed(ActionEvent actionEvent) {
        if (fronteiraRadioButton.isSelected()) {
            tracao = fronteiraRadioButton.getText();
        } else {
            tracao = traseiraRadioButton.getText();
        }
    }

    private void combustivelButtonActionPerformed(ActionEvent actionEvent) {
        if (gasolinaRadioButton.isSelected()) {
            combustivel = gasolinaRadioButton.getText();
        } else if (dieselRadioButton.isSelected()) {
            combustivel = dieselRadioButton.getText();
        } else if (elétricoRadioButton.isSelected()) {
            combustivel = elétricoRadioButton.getText();
        }
    }

    private void tipoCaixaButtonActionPerformed(ActionEvent actionEvent) {
        if (automáticaRadioButton.isSelected()) {
            tipoCaixa = automáticaRadioButton.getText();
        } else {
            tipoCaixa = manualRadioButton.getText();
        }
    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

        String marca = comboBoxMarca.getSelectedItem().toString();
        String combustivel = comboBoxCombustivel.getSelectedItem().toString();
        String tipoCaixa = comboBoxTipoCaixa.getSelectedItem().toString();
        String condicaoGeral = comboBoxCondicaoGeral.getSelectedItem().toString();
        if (txtQuilometrosFiltro.getText().isEmpty()) {
            txtQuilometrosFiltro.setText("0");
        }
        Integer quilometros = Integer.parseInt(txtQuilometrosFiltro.getText());

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

    private void btnEditarActionPerformed(ActionEvent evt) {
        System.out.println("EditarEvento.btnEditarActionPerformed");
        Veiculo veiculoSelecionado = listaVeiculos.getSelectedValue();
        if (veiculoSelecionado == null) {
            Erros.mostrarErro(this, Erros.VEICULO_NAO_SELECIONADO);
            return;
        } else {
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            if (!verificarPreenchido()) {
                return;
            }

            boolean valido = MatriculaExiste(txtmatricula.getText());
            if (valido) {
                Erros.mostrarErro(this, Erros.MATRICULA_JA_EXISTE);
                return;
            }
            valido = NomeCaracteresEspeciais(txtmarca.getText());
            if (valido) {
                Erros.mostrarErro(this, Erros.CONTEM_CARACTERES_ESPECIAIS);
                return;
            }
            valido = NomeCaracteresEspeciais(txtmodelo.getText());
            if (valido) {
                Erros.mostrarErro(this, Erros.CONTEM_CARACTERES_ESPECIAIS);
                return;
            }
            valido = NomeCaracteresEspeciais(txtdonoAnterior.getText());
            if (valido) {
                Erros.mostrarErro(this, Erros.CONTEM_CARACTERES_ESPECIAIS);
                return;
            }
            valido = NomeCaracteresEspeciais(txtcategoria.getText());
            if (valido) {
                Erros.mostrarErro(this, Erros.CONTEM_CARACTERES_ESPECIAIS);
                return;
            }
            valido = isNumero(txtnDonos.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }
            valido = isNumero(txtnPortas.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }
            valido = isNumero(txtquilometros.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }
            valido = isNumero(txtpotencia.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }
            valido = isNumero(txtcilindrada.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }
            valido = isNumero(txtclasse.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }

            int nPortas = Integer.parseInt(txtnPortas.getText());
            int nDonos = Integer.parseInt(txtnDonos.getText());
            int quilometros = Integer.parseInt(txtquilometros.getText());
            int potencia = Integer.parseInt(txtpotencia.getText());
            int cilindrada = Integer.parseInt(txtcilindrada.getText());
            int classe = Integer.parseInt(txtclasse.getText());

            if (nDonos < 0 || quilometros < 0 || potencia < 0 || cilindrada < 0 || classe < 0) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }

            dadosAplicacao.editarVeiculo(veiculoSelecionado, txtmatricula.getText(), txtmarca.getText(), txtmodelo.getText(), nDonos, txtdonoAnterior.getText(), txtcategoria.getText(), classe, nPortas, potencia, quilometros, cilindrada, tipoCaixa, tracao, condicaoGeral, combustivel);

            atualizarListaVeiculo();
        }
    }

    public boolean verificarPreenchido() {
        if (foiPreenchido(txtmatricula.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtmarca.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtmodelo.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtdonoAnterior.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtnDonos.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtcategoria.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtquilometros.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtclasse.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtnPortas.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtpotencia.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtcilindrada.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (!gasolinaRadioButton.isSelected() && !dieselRadioButton.isSelected() && !elétricoRadioButton.isSelected()) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    private boolean NomeCaracteresEspeciais(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.temCaracteresEspeciais(nome);
    }

    private boolean isNumero(String nVeiculos) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nVeiculos);
    }

    public static Evento mostrarEditarVeiculo(Frame parent) {
        System.out.println("mostrarRemoverVeiculo");
        EditarVeiculo dialog = new EditarVeiculo(parent, true);
        dialog.setVisible(true);
        return null;
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    private boolean MatriculaExiste(String matricula) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeVeiculoComMatricula(matricula);
    }

    private void atualizarListaVeiculo() {
        java.util.List<Veiculo> veiculos = new ArrayList<>();
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
        java.util.List<Veiculo> veiculos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        veiculos = dadosAplicacao.getVeiculos();
        List<String> marcas = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            comboBoxMarca.addItem(veiculo.getMarca());
        }
    }

}
