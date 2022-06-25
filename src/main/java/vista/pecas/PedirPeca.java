package vista.pecas;

import modelo.DadosAplicacao;
import modelo.Peca;
import vista.Erros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PedirPeca extends JFrame {
    private JLabel pedirPecaText;
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

    public PedirPeca(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
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

    private void requisitarPecaActionPerformed(ActionEvent event){
        System.out.println("Requisitar peça");
        System.out.println("peça escolhida + " + list1.getSelectedValue());
        System.out.println("Sede de fileal requisita: " + sedeFilealRequisita);
        System.out.println("Sede de fileal entrega: " + sedeFilealEntrega);

        /*
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.adicionarPeca(nomePeca, quantidadeMinimaFileal, quantidadeMinimaSede, sedeFilealRequisita, sedeFilealEntrega, tipoPeca);
        setVisible(false);
        new PaginaInicialPecas().setVisible(true);
        */
         
    }
}
