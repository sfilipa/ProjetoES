package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JLabel nomePeca;
    private JButton removerButton;
    private JButton cancelarButton;
    private JLabel removerStockPecas;
    private JLabel quantidadeRemover;
    private JList list1;
    private JComboBox comboBox1;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list2;
    private JRadioButton consumivelRadioButton;

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
