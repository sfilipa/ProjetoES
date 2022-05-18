package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new RemoverPeca().setVisible(true);
    }
}
// como fazer para remover os detalhes??