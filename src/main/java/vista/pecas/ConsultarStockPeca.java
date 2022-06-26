package vista.pecas;

import modelo.DadosAplicacao;
import modelo.Filial;
import modelo.Peca;
import modelo.Sede;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultarStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JLabel consultarPeca;
    private JLabel nomePeca;
    private JLabel localArmazenamento;
    private JLabel tipoPeca;
    private JLabel tipoPecaText;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaFileal;
    private JLabel quantidadeMinimaSedeText;
    private JList list1;
    private JButton voltarButton;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list2;
    private JButton consultarButton;

    private String radioAnswer;

    public ConsultarStockPeca() {
        setContentPane(painelPrincipal);
        pack();

        consumivelRadioButton.addActionListener(this::tipoPeca);
        outroRadioButton.addActionListener(this::tipoPeca);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        consultarButton.addActionListener(this::btnConsultarActionPerformed);

        consumivelRadioButton.setSelected(false);
        outroRadioButton.setSelected(false);

    }

    private void btnVoltarActionPerformed(ActionEvent event) {
        voltarButton.addActionListener(new ActionListener() {
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

    private void btnConsultarActionPerformed(ActionEvent event) {
        System.out.println("Peca selecionada: ");
        Peca peca = (Peca) list1.getSelectedValue();
        System.out.println(peca.toString());

        System.out.println("Local de armazenamento: ");
        Sede sede = (Sede) list2.getSelectedValue();
        System.out.println(sede.toString());

        tipoPecaText.setText(peca.getTipo());
        System.out.println(peca.getTipo());
        quantidadeMinimaSedeText.setText(peca.getMinimaSede());
        System.out.println(peca.getMinimaSede());

    }

    public static Peca mostrarConsultarStockPeca(Frame parent) {
        ConsultarStockPeca dialog = new ConsultarStockPeca();
        dialog.setVisible(true);
        return null;
    }

}
