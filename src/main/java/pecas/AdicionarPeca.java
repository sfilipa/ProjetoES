package pecas;

import javax.swing.*;

public class AdicionarPeca extends JFrame{
    private JPanel painelPrincipal;
    private JLabel adicionarPeca;
    private JTextField nomePecaTextField;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField quantidadeMinimaSedeText;
    private JTextField quantidadeMinimaFilealText;
    private JButton adicionarPecaButton;
    private JButton cancelarButton;
    private JLabel nomePeca;
    private JLabel localArmazenamento;
    private JLabel tipoPeca;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaFileal;
    private JList localArmazenamentoList;

    public AdicionarPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new AdicionarPeca().setVisible(true);
    }
}

