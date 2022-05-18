package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverVeiculo extends JFrame {
    private JButton removerButton;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JComboBox comboBox1;

    public RemoverVeiculo(){
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
        new RemoverVeiculo().setVisible(true);
    }
}
