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

public class AdicionarStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JSpinner quantidadeAdicionarSpiner;
    private JList filealSedeAdicionarList;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JLabel filealSedeAdicionar;
    private JLabel quantidadeAdicionar;
    private JLabel pecaAdicionar;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list1;

    private String radioAnswer;

    public AdicionarStockPeca(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();

        consumivelRadioButton.addActionListener(this::tipoPeca);
        outroRadioButton.addActionListener(this::tipoPeca);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);

        consumivelRadioButton.setSelected(false);
        outroRadioButton.setSelected(false);

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
        String palavras = palavrasFiltragemText.getText();
        String tipoPeca = radioAnswer;
        if(radioAnswer == null){
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
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
            if(outroRadioButton.isSelected()) {
                radioAnswer = "Outro";
            } else {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            }
        }

    }

    private Integer quantidadeAdicionar() {
        quantidadeAdicionarSpiner.setValue(0);
        return (Integer) quantidadeAdicionarSpiner.getValue();
    }

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        List<Peca> pecas = dadosAplicacao.getPecas();
        Peca peca = (Peca) filealSedeAdicionarList.getSelectedValue();
        Integer quantidade = quantidadeAdicionar();
        if (peca != null && quantidade != 0) {
            DadosAplicacao.adicionarStockPeca(peca, quantidade);
            dadosAplicacao.atualizarPeca(peca);
            setVisible(false);
            new PaginaInicialPecas().setVisible(true);
        } else {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
    }



    public static Peca mostrarStockPeca(Frame parent) {
        AdicionarStockPeca dialog = new AdicionarStockPeca(parent, true);
        dialog.setVisible(true);
        return null;
    }

    /*
    public static void main(String[] args) {
        new AdicionarStockPeca().setVisible(true);
    }

     */
}

