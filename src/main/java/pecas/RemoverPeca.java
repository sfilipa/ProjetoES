package pecas;

import javax.swing.*;

public class RemoverPeca extends JFrame{
    private JLabel removerPeca;
    private JList nomePecaList;
    private JButton removerPecaButton;
    private JButton cancelarButton;
    private JLabel nomeText;
    private JPanel painelPrincipal;

    public RemoverPeca(){
        setContentPane(painelPrincipal);
        pack();
    }

    public static void main(String[] args) {
        new RemoverPeca().setVisible(true);
    }
}
// como fazer para remover os detalhes??