package vista.transacoes;

import modelo.*;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ComprarVeiculo extends JFrame {
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

    private Transacao transacao;

    private String tracao;
    private String condicaoGeral;

    public ComprarVeiculo(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();

        gasolinaRadioButton.addActionListener(this::combustivelButtonActionPerformed);
        dieselRadioButton.addActionListener(this::combustivelButtonActionPerformed);
        eletricoRadioButton.addActionListener(this::combustivelButtonActionPerformed);
        automaticaRadioButton.addActionListener(this::tipoCaixaButtonActionPerformed);
        manualRadioButton.addActionListener(this::tipoCaixaButtonActionPerformed);
        fronteiraRadioButton.addActionListener(this::tracaoButtonActionPerformed);
        traseiraRadioButton.addActionListener(this::tracaoButtonActionPerformed);
        muitoMauRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        mauRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        bomRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        muitoBomRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        médioRadioButton.addActionListener(this::condicaoGeralButtonActionPerformed);
        comprarButton.addActionListener(this::btnComprarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);



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

    private void btnComprarActionPerformed(ActionEvent evt) {
        System.out.println("Comprar Veículo");


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


        Transacao transacao = new Transacao(matriculaText.getText(), marcaText.getText(), modeloText.getText(), donoAnteriorText.getText(), nDonosText.getText(), combustivel, classesText.getText(), nPortasText.getText(), potenciaText.getText(), cilindradaText.getText(), tipoCaixa, tracao, condicaoGeral, precoText.getText(), nifText.getText());

        fechar();
    }

    public boolean verificarPreenchido() {
        if (naofoiPreenchido(matriculaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(marcaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(modeloText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(donoAnteriorText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(nDonosText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(categoriaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(classesText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(nPortasText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(potenciaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(cilindradaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (!gasolinaRadioButton.isSelected() && !dieselRadioButton.isSelected() && !eletricoRadioButton.isSelected()) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    private boolean isNumero(String nVeiculos) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nVeiculos);
    }

    public static Transacao mostrarComprarVeiculo(Frame parent) {
        //todo
        System.out.println("mostrarCriacaoVeiculo");
        var detalhes = new ComprarVeiculo(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getTransacao();
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
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

    public Transacao getTransacao() {
        return transacao;
    }

}