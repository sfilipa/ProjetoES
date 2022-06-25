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

public class ConsultarPeca extends JFrame {
    private JLabel consultarPeca;

    private JButton consultarButton;
    private JButton voltarButton;
    private JLabel tipoPeca;
    private JLabel tipoPecaText;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaSedeText;
    private JLabel quantidadeMinimaFileal;
    private JLabel quantidadeMinimaFilealText;
    private JPanel painelPrincipal;
    private JLabel nomePeca;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list1;

    private String radioAnswer;

    public ConsultarPeca(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();

        consumivelRadioButton.addActionListener(this::tipoPeca);
        outroRadioButton.addActionListener(this::tipoPeca);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        consultarButton.addActionListener(this::btnPecaSelecionadaActionPerformed);

        consumivelRadioButton.setSelected(false);
        outroRadioButton.setSelected(false);

    }

    private void btnVoltarActionPerformed(ActionEvent event) {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
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

    private void btnFiltrarActionPerformed(ActionEvent event) {
        System.out.println("Filtrar");

        String palavras = palavrasFiltragemText.getText();
        String tipoPeca = radioAnswer;
        if(radioAnswer == null){
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }

        System.out.println("Palavra: " + palavras);
        System.out.println("Tipo de peça: " + tipoPeca);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        // dar a lista de peças com nomes parecidos a palavras
        List<Peca> pecas = dadosAplicacao.getPecas();
        List<Peca> pecasFiltradas = new ArrayList<>();
        // ????????????????

        pecas = dadosAplicacao.getPecas();

        DefaultListModel<Peca> model = new DefaultListModel<>();
        for (Peca peca : pecas) {
            model.addElement(peca);
        }
        list1.setModel(model);
    }


    private void btnPecaSelecionadaActionPerformed(ActionEvent event) {
        System.out.println("Peca selecionada");
        Peca peca = (Peca) list1.getSelectedValue();
        System.out.println(peca.toString());

        tipoPecaText.setText(peca.getTipo());
        System.out.println(peca.getTipo());
        quantidadeMinimaSedeText.setText(peca.getMinimaSede());
        System.out.println(peca.getMinimaSede());
        quantidadeMinimaFilealText.setText(peca.getMinimaFilial());
        System.out.println(peca.getMinimaFilial());
    }

    public static Peca mostrarConsultarPeca(Frame parent) {
        ConsultarPeca dialog = new ConsultarPeca(parent, true);
        dialog.setVisible(true);
        return null;
    }
}

