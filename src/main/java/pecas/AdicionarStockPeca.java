package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JButton filtrarButton;
    private JTextField textField2;
    private JSpinner spinner1;
    private JList list1;
    private JButton adicionarButton;
    private JButton cancelarButton;

    public AdicionarStockPeca(){
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
        new AdicionarStockPeca().setVisible(true);
    }
}

