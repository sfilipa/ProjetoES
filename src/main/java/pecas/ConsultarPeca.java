package pecas;

import javax.swing.*;

public class ConsultarPeca extends JFrame {
    private JLabel consultarPeca;
    private JComboBox pecaBox;
    private JButton voltarButton;
    private JLabel localArmazenamento;
    private JLabel localArmazenamentoText;
    private JLabel tipoPeca;
    private JLabel tipoPecaText;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaSedeText;
    private JLabel quantidadeMinimaFileal;
    private JLabel quantidadeMinimaFilealText;
    private JPanel painelPrincipal;

    public ConsultarPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new ConsultarPeca().setVisible(true);
    }
}

