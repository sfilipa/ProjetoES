import javax.swing.*;

public class RemoverPeca extends JFrame{
    private JButton removerPecaButton;
    private JPanel painelPrincipal;
    private JList list1;


    public RemoverPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new RemoverPeca().setVisible(true);
    }
}

// secalhar em vez de textBox fazer uma lista??? ver