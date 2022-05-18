package pecas;

import javax.swing.*;

public class PedirPeca extends JFrame {
    private JLabel pedirPecaText;
    private JLabel peca;
    private JLabel sedeFilealRequisita;
    private JLabel sedeFilealEntrega;
    private JComboBox sedeFilealEntregaBox;
    private JComboBox sedeFilealRequisitaBox;
    private JList list1;
    private JButton requisitarButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;

    public PedirPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new PedirPeca().setVisible(true);
    }

}
