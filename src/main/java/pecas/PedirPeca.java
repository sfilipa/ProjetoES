import javax.swing.*;

public class PedirPeca extends JFrame{
    private JPanel painelPrincipal;
    private JList pecaList;
    private JList sedeFilealList;
    private JButton requisitarButton;
    private JLabel peca;
    private JLabel pedirPecaText;
    private JButton cancelarButton;
    private JList list1;

    public PedirPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new PedirPeca().setVisible(true);
    }
}
