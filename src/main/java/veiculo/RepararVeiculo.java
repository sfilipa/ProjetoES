package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepararVeiculo extends JFrame {
    private JButton repararButton;
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JList list1;

    public RepararVeiculo(){
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
        new RepararVeiculo().setVisible(true);
    }
}
