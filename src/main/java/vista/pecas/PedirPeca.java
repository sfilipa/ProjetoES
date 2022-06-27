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

public class PedirPeca extends JFrame {
    private JLabel sedeFilealRequisita;
    private JLabel sedeFilealEntrega;
    private JComboBox sedeFilealEntregaBox;
    private JComboBox sedeFilealRequisitaBox;
    private JList list1;
    private JButton requisitarButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;

    private String radioAnswer;

    public PedirPeca(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();

        consumivelRadioButton.addActionListener(this::tipoPeca);
        outroRadioButton.addActionListener(this::tipoPeca);
        requisitarButton.addActionListener(this::btnRequisitarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);

        atualizarListaPeca();

        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        requisitarButton.addActionListener(this::btnRequisitarActionPerformed);
        sedeFilealRequisitaBox.addActionListener(this::localQuePedeActionPerformed);
        sedeFilealEntregaBox.addActionListener(this::localQueEntregaActionPerformed);
        list1.addListSelectionListener(this::pecaSelecionadaActionPerformed);

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

    private void btnRequisitarActionPerformed(ActionEvent event) {
        System.out.println("Requisitar peça");
        System.out.println("peça escolhida + " + list1.getSelectedValue());
        System.out.println("Sede de fileal requisita: " + sedeFilealRequisita);
        System.out.println("Sede de fileal entrega: " + sedeFilealEntrega);
        fechar();

    }

    private void localQuePedeActionPerformed(ActionEvent event) {
        System.out.println("Local que pede");
        System.out.println("Sede/fileal que requisita: " + sedeFilealRequisita);
        String localQuePede = sedeFilealRequisita.getText();
    }

    private void localQueEntregaActionPerformed(ActionEvent event){
        System.out.println("Local que entrega");
        System.out.println("Sede/fileal que entrega: " + sedeFilealEntrega);
        String localQueEntrega = sedeFilealEntrega.getText();
    }

    private void pecaSelecionadaActionPerformed(ListSelectionEvent listSelectionEvent){
        if(list1.getSelectedIndex() == -1){
            Erros.mostrarErro(this,Erros.NAO_SELECIONADO);
        }
        if(list1.getSelectedIndex() != -1){
            String pecaSelecionada = list1.getSelectedValue().toString();
        }
    }


    private void atualizarListaPeca(){
        List<Peca> pecas = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        pecas = dadosAplicacao.getPecas();
        DefaultListModel<Peca> model = new DefaultListModel<>();
        for(Peca peca : pecas){
            model.addElement(peca);
        }
        list1.setModel(model);
    }
    public static Peca mostrarPedirPeca(Frame parent){
        PedirPeca dialog = new PedirPeca(parent,true);
        dialog.setVisible(true);
        return null;
    }

    private void fechar() {
        this.setVisible(false);
    }

}
