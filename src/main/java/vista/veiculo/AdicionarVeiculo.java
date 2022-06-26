package vista.veiculo;

import modelo.*;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AdicionarVeiculo extends JDialog {
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JTextField txtmatricula;
    private JTextField txtmarca;
    private JTextField txtmodelo;
    private JTextField txtdonoAnterior;
    private JTextField txtnDonos;
    private JTextField txtcategoria;
    private JTextField txtquilometros;
    private JTextField txtclasse;
    private JTextField txtnPortas;
    private JTextField txtpotencia;
    private JTextField txtcilindrada;
    private JRadioButton gasolinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton elétricoRadioButton;
    private JRadioButton automáticaRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JRadioButton traseiraRadioButton;
    private JRadioButton muitoBomRadioButton;
    private JRadioButton bomRadioButton;
    private JRadioButton médioRadioButton;
    private JRadioButton mauRadioButton;
    private JRadioButton muitoMauRadioButton;
    private JComboBox comboBoxArmazenar;

    private Veiculo veiculo;
    private String tipoCaixa;
    private String combustivel;
    private String tracao;
    private String condicaoGeral;


    public AdicionarVeiculo(Frame parent, boolean modal) {
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarCombBoxArmazenar();

        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
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

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        System.out.println("Adicionar Veículo");

        if (!verificarPreenchido()) {
            return;
        }

        boolean valido = MatriculaExiste(txtmatricula.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.MATRICULA_JA_EXISTE);
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
        valido = checkNViaturasLocal(comboBoxArmazenar.getSelectedItem().toString());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NUMERO_VIATURAS_EXCEDIDO);
            return;
        }

        int nPortas = Integer.parseInt(txtnPortas.getText());
        int nDonos = Integer.parseInt(txtnDonos.getText());
        int quilometros = Integer.parseInt(txtquilometros.getText());
        int potencia = Integer.parseInt(txtpotencia.getText());
        int cilindrada = Integer.parseInt(txtcilindrada.getText());
        int classe = Integer.parseInt(txtclasse.getText());

        if (classe > 4 || classe < 1) {
            Erros.mostrarErro(this, Erros.CLASSE_INVALIDA);
            return;
        }
        if (nPortas != 3 && nPortas != 5) {
            Erros.mostrarErro(this, Erros.NUMERO_PORTAS_INVALIDAS);
            return;
        }

        veiculo = new Veiculo(txtmatricula.getText(), txtmarca.getText(), txtmodelo.getText(),nDonos, txtdonoAnterior.getText(),txtcategoria.getText(), classe, nPortas, potencia, quilometros, cilindrada, tipoCaixa, tracao, condicaoGeral, combustivel, comboBoxArmazenar.getSelectedItem().toString());

        fechar();
    }

    public boolean verificarPreenchido() {
        if (naofoiPreenchido(txtmatricula.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtmarca.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtmodelo.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtdonoAnterior.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtnDonos.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtcategoria.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtquilometros.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtclasse.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtnPortas.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtpotencia.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(txtcilindrada.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (!gasolinaRadioButton.isSelected() && !dieselRadioButton.isSelected() && !elétricoRadioButton.isSelected()) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    private boolean isNumero(String nVeiculos) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nVeiculos);
    }

    public static Veiculo mostrarCriacaoVeiculo(Frame parent) {
        //todo
        System.out.println("mostrarCriacaoVeiculo");
        var detalhes = new AdicionarVeiculo(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getVeiculo();
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }

    private boolean naofoiPreenchido(String text) {
        return text.isEmpty();
    }

    private boolean MatriculaExiste(String matricula) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.naoExisteVeiculoComMatricula(matricula);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    private void atualizarCombBoxArmazenar() {
        Sede sede = Sede.getSede();
        comboBoxArmazenar.addItem(sede);
        for (Filial filial : Filial.values()) {
                comboBoxArmazenar.addItem(filial.displayName());
        }
        List<LocalExposicao> localExposicaos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicaos = dadosAplicacao.getLocalExposicoes();


        for(LocalExposicao localExposicao : localExposicaos) {
                comboBoxArmazenar.addItem(localExposicao.displayName());
        }
    }

    private boolean checkNViaturasLocal(String localArmazenamento) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        int nViaturas = 0;
        for (Veiculo veiculo : dadosAplicacao.getVeiculos()) {
            if (veiculo.getLocalArmazenamento().equals(localArmazenamento)) {
                nViaturas++;
            }
        }
        if (localArmazenamento.equals("Sede")) {
            Sede sede = Sede.getSede();
            if (nViaturas >= Sede.Sede.getViaturasMax()) {
                return false;
            }
        }else{
            for (Filial filial : Filial.values()) {
               if (localArmazenamento.equals(filial.displayName())) {
                   if (nViaturas >= filial.ViaturasMax()) {
                       return false;
                   }
               }
            }
        }
        return true;
    }


}