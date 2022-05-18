package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JFrame {
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public AdicionarVeiculo(){
        setContentPane(painelPrincipal);
        pack();
        btnCancelarActionPerformed();

    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialVeiculos().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new AdicionarVeiculo().setVisible(true);
    }
}
//ver