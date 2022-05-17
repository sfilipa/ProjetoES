package pecas;

import javax.swing.*;

public class AdicionarPeca extends JFrame{
    private JPanel painelPrincipal;
    private JLabel adicionarPeca;
    private JTextField nomePecaTextField;
    private JList localArmazenamentoList;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField quantidadeMinimaSedeText;
    private JTextField quantidadeMinimaFileal;
    private JButton adicionarPecaButton;
    private JButton cancelarButton;
    private JLabel nomePeca;

    public AdicionarPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new AdicionarPeca().setVisible(true);
    }
}

