package pecas;

import javax.swing.*;

public class EditarPeca extends JFrame {
    private JLabel editarPeca;
    private JComboBox pecaList;
    private JLabel peca;
    private JTextField alterarNomePecaTextField;
    private JComboBox alterarLocalArmazenamentoBox;
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

    public EditarPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new EditarPeca().setVisible(true);
    }
}

