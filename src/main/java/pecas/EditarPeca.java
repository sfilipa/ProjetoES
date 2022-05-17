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
    private JTextField alterarQuantidadeMinimaSede;
    private JTextField alterarQuantidadeMinimaFileal;
    private JButton editarButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;

    public EditarPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new EditarPeca().setVisible(true);
    }
}

