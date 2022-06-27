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

public class RemoverStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JLabel nomePeca;
    private JButton removerButton;
    private JButton cancelarButton;
    private JLabel removerStockPecas;
    private JLabel quantidadeRemover;
    private JList list1;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list2;
    private JRadioButton consumivelRadioButton;
    private JSpinner spinner1;

    private String radioAnswer;

    public RemoverStockPeca() {
        setContentPane(painelPrincipal);
        pack();

        consumivelRadioButton.addActionListener(this::tipoPeca);
        outroRadioButton.addActionListener(this::tipoPeca);
        removerButton.addActionListener(this::btnRemoverPecaActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);

        quantidadeARemover();
        atualizarListaPeca();


        list1.addListSelectionListener(this::pecaSelecionadaActionPerformed);
        list2.addListSelectionListener(this::sedeFilialSelecionadaActionPerformed);

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

        java.util.List<Peca> pecas = dadosAplicacao.getPecas();

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

    private void sedeFilialSelecionadaActionPerformed(ListSelectionEvent listSelectionEvent) {
        if (list2.getSelectedIndex() == -1) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
        if (list2.getSelectedIndex() != -1) {
            String sedeFilialSelecionada = list2.getSelectedValue().toString();
        }
    }

    private void btnRemoverPecaActionPerformed(ActionEvent event) {
        if (list1.getSelectedIndex() == -1) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
        if (list1.getSelectedIndex() != -1) {
            String pecaSelecionada = list1.getSelectedValue().toString();
            remove(Integer.parseInt(pecaSelecionada));
            quantidadeRemover.setText("quantidade removida: " + spinner1.getValue());
        }
    }

    private void quantidadeARemover() {
        spinner1.setValue(0);
        spinner1.getValue();
    }

    private void atualizarListaPeca() {
        List<Peca> pecas = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        pecas = dadosAplicacao.getPecas();
        DefaultListModel<Peca> model = new DefaultListModel<>();
        for (Peca peca : pecas) {
            model.addElement(peca);
        }
        list1.setModel(model);
    }

    public static Peca mostrarRemoverStockPeca(Frame parent) {
        RemoverPeca dialog = new RemoverPeca(parent, true);
        dialog.setVisible(true);
        return null;
    }

    public void remove(int quantidade) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        List<Peca> pecas = dadosAplicacao.getPecas();
        for (Peca peca : pecas) {
            if (peca.getNome().equals(list1.getSelectedValue().toString())) {
                peca.setQuantidade(peca.getQuantidade() - quantidade);
            }
        }
    }
}
