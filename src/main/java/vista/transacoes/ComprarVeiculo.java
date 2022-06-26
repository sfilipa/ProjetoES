package vista.transacoes;

import modelo.*;
import vista.Erros;
import vista.veiculo.AdicionarVeiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ComprarVeiculo extends JFrame{
    private JPanel painelPrincipal;
    private String combustivel;
    private String tipoCaixa;
    private JTextField matriculaText;
    private JTextField marcaText;
    private JTextField modeloText;
    private JTextField donoAnteriorText;
    private JTextField nDonosText;
    private JTextField categoriaText;
    private JTextField classesText;
    private JTextField nPortasText;
    private JTextField potenciaText;
    private JTextField cilindradaText;
    private JTextField precoText;
    private JRadioButton gasolinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton eletricoRadioButton;
    private JRadioButton automaticaRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JTextField clientText;
    private JRadioButton traseiraRadioButton;
    private JButton cancelarButton;
    private JButton comprarButton;
    private JRadioButton muitoMauRadioButton;
    private JRadioButton mauRadioButton;
    private JRadioButton bomRadioButton;
    private JRadioButton muitoBomRadioButton;
    private JRadioButton médioRadioButton;
    private JComboBox comboBox1;
    private JLabel nome;
    private JLabel nif;
    private JTextField nomeText;
    private JTextField nifText;
    private JButton filtrarButton1;

    private Veiculo veiculo;

    private String tracao;
    private String condicaoGeral;

    public ComprarVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }


    private void condicaoGeralButtonActionPerformed(ActionEvent actionEvent) {
        if (muitoMauRadioButton.isSelected()) {
            condicaoGeral = muitoMauRadioButton.getText();
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
        } else if (eletricoRadioButton.isSelected()) {
            combustivel = eletricoRadioButton.getText();
        }
    }

    private void tipoCaixaButtonActionPerformed(ActionEvent actionEvent) {
        if (automaticaRadioButton.isSelected()) {
            tipoCaixa = automaticaRadioButton.getText();
        } else {
            tipoCaixa = manualRadioButton.getText();
        }
    }

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        System.out.println("Adicionar Veículo");

        /*if (!verificarPreenchido()) {
            return;
        }*/

        boolean valido = MatriculaExiste(matriculaText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.MATRICULA_JA_EXISTE);
            return;
        }

        valido = isNumero(nDonosText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(nPortasText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(potenciaText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(cilindradaText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(classesText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(precoText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(nifText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }

        int nPortas = Integer.parseInt(nPortasText.getText());
        int nDonos = Integer.parseInt(nDonosText.getText());
        int potencia = Integer.parseInt(potenciaText.getText());
        int cilindrada = Integer.parseInt(cilindradaText.getText());
        int classe = Integer.parseInt(classesText.getText());
        int preco = Integer.parseInt(precoText.getText());
        int nif = Integer.parseInt(nifText.getText());

        if (classe > 4 || classe < 1) {
            Erros.mostrarErro(this, Erros.CLASSE_INVALIDA);
            return;
        }
        if (nPortas != 3 && nPortas != 5) {
            Erros.mostrarErro(this, Erros.NUMERO_PORTAS_INVALIDAS);
            return;
        }
/*
        Veiculo veiculo = new Veiculo(matriculaText.getText(), marcaText.getText(), modeloText.getText(), combustivel, tipoCaixa, nPortas, nDonos, potencia, cilindrada, classe, preco, nif, tracao, condicaoGeral);
        fechar();
        */

    }

    /*public boolean verificarPreenchido() {
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
    }*/

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

   /* private void atualizarCombBoxArmazenar() {
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
    }*/

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
        } else {
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