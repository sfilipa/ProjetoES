package pecas;

import javax.swing.*;

public class RemoverPeca extends JFrame{
    private JLabel removerPeca;
    private JButton removerPecaButton;
    private JButton cancelarButton;
    private JLabel nomePeca;
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
// como fazer para remover os detalhes??