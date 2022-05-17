import javax.swing.*;

public class PedirPeca extends JFrame{
    private JPanel painelPrincipal;
    private JList pecaList;
    private JTextField sedeFilealTextField;
    private JList sedeFilealList;
    private JButton requisitarButton;
    private JLabel peca;

    public PedirPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new PedirPeca().setVisible(true);
    }
}
