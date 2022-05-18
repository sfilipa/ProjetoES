package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JLabel nome;
    private JLabel tipoPeca;
    private JButton filtrarButton;
    private JTextField nomePecaText;
    private JTextField nomePecaRemover;
    private JLabel nomePeca;
    private JButton removerButton;
    private JButton cancelarButton;
    private JLabel removerStockPecas;
    private JLabel quantidadeRemover;
    private JList list1;
    private JComboBox comboBox1;

    public RemoverStockPeca(){
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
        new RemoverStockPeca().setVisible(true);
    }
}
