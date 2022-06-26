package vista.pecas;

import modelo.DadosAplicacao;
import modelo.Peca;
import vista.Erros;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverPeca extends JFrame {
    private JLabel removerPeca;
    private JButton removerPecaButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JList list1;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;

    private String radioAnswer;

    public RemoverPeca(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();

        consumivelRadioButton.addActionListener(this::tipoPeca);
        outroRadioButton.addActionListener(this::tipoPeca);
        removerPecaButton.addActionListener(this::btnRemoverPecaActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        list1.addListSelectionListener(this::pecaSelecionadaActionPerformed);


        atualizarListaPeca();

        consumivelRadioButton.setSelected(false);
        outroRadioButton.setSelected(false);
    }

    private void btnCancelarActionPerformed(ActionEvent event) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
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

        // dar a lista de peças com nomes parecidos a palavras
        java.util.List<Peca> pecas = dadosAplicacao.getPecas();
        java.util.List<Peca> pecasFiltradas = new ArrayList<>();
        // ????????????????

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

    private void pecaSelecionadaActionPerformed(ListSelectionEvent listSelectionEvent) {
        if (list1.getSelectedIndex() == -1) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
        if (list1.getSelectedIndex() != -1) {
            String pecaSelecionada = list1.getSelectedValue().toString();
        }
    }

    private void btnRemoverPecaActionPerformed(ActionEvent event) {
        if (list1.getSelectedIndex() == -1) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
        if (list1.getSelectedIndex() != -1) {
            String pecaSelecionada = list1.getSelectedValue().toString();
            remove(Integer.parseInt(pecaSelecionada));
        }
    }

    private void atualizarListaPeca() {
        List<Peca> pecas = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        pecas = dadosAplicacao.getPecas();
        DefaultListModel<Peca> model = new DefaultListModel<>();
        for (Peca peca : pecas) {
            model.removeElement(peca);
        }
        list1.setModel(model);
    }

    public static Peca mostrarRemoverPeca (Frame parent) {
        RemoverPeca dialog = new RemoverPeca(parent, true);
        dialog.setVisible(true);
        return null;
    }


}

