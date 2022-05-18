package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        new PedirPeca().setVisible(true);
    }

}
