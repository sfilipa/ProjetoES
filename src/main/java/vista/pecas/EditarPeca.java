package vista.pecas;

import modelo.DadosAplicacao;
import modelo.Peca;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditarPeca extends JFrame {
    private JLabel editarPeca;
    private JLabel peca;
    private JTextField alterarNomePecaTextField;
    private JLabel tipoPeca;
    private JLabel localArmazenamento;
    private JLabel nomePeca;
    private JRadioButton alterarConsumivelRadioButton;
    private JRadioButton alterarOutroRadioButton;
    private JTextField alterarQuantidadeMinimaSedeText;
    private JTextField alterarQuantidadeMinimaFilealText;
    private JButton editarButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JLabel alterarQuantidadeMinimaSede;
    private JLabel alterarQuantidadeMinimaFileal;
    private JList list1;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list2;

    private String radioAnswer;

    public EditarPeca(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();

        alterarConsumivelRadioButton.addActionListener(this::tipoPeca);
        alterarOutroRadioButton.addActionListener(this::tipoPeca);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);

        alterarConsumivelRadioButton.setSelected(false);
        alterarOutroRadioButton.setSelected(false);
    }

    private void btnCancelarActionPerformed(ActionEvent event) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void btnFiltrarActionPerformed(ActionEvent event) {
        System.out.println("Filtrar");

        String palavras = palavrasFiltragemText.getText();
        String tipoPeca = radioAnswer;
        if (radioAnswer == null) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }

        System.out.println("Palavra: " + palavras);
        System.out.println("Tipo de peça: " + tipoPeca);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Peca> pecas = dadosAplicacao.getPecas();

        pecas = dadosAplicacao.getPecas();

        DefaultListModel<Peca> model = new DefaultListModel<>();
        for (Peca peca : pecas) {
            model.addElement(peca);
        }
        list1.setModel(model);
    }

    private void tipoPeca(ActionEvent event) {
        if (consumivelRadioButton.isSelected()) {
            radioAnswer = "Consumível";
        } else {
            if (outroRadioButton.isSelected()) {
                radioAnswer = "Outro";
            } else {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            }
        }

    }

    private String alterarTipoPeca() {
        if (alterarConsumivelRadioButton.isSelected()) {
            return radioAnswer = "Consumível";
        } else {
            if (alterarOutroRadioButton.isSelected()) {
                return radioAnswer = "Outro";
            } else {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            }
        }

        return null;
    }

    private void btnEditarActionPerformed(ActionEvent event) {
        System.out.println("Editar");
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        List<Peca> pecas = dadosAplicacao.getPecas();
        Peca peca = (Peca) list2.getSelectedValue();
        peca.setNome(alterarNomePecaTextField.getText());
        peca.setLocalArmazenamento((String) list1.getSelectedValue());
        peca.setTipo(radioAnswer);
        peca.setQuantidadeMinimaSede(Integer.parseInt(alterarQuantidadeMinimaSedeText.getText()));
        peca.setQuantidadeMinimaFileal(Integer.parseInt(alterarQuantidadeMinimaFilealText.getText()));
        pecas.set(pecas.indexOf(peca), peca);
        dadosAplicacao.setPecas(pecas);
        setVisible(false);
    }


    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    public boolean verificarPreenchido() {
        if (foiPreenchido(alterarNomePecaTextField.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(alterarQuantidadeMinimaFilealText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(alterarQuantidadeMinimaSedeText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }

        if (foiPreenchido(Objects.requireNonNull(alterarTipoPeca())))
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
        return false;
    }

    public static Peca mostrarEditarPeca (Frame parent) {
        EditarPeca dialog = new EditarPeca(parent, true);
        dialog.setVisible(true);
        return null;
    }


}


