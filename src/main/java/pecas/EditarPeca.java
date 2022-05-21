package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JRadioButton comsumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list2;

    public EditarPeca(){
        setContentPane(painelPrincipal);
        pack();

        btnVCancelarActionPerformed();
    }

    private void btnVCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new EditarPeca().setVisible(true);
    }
}

