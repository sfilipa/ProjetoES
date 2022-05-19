package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepararVeiculo extends JFrame {
    private JButton repararButton;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JList list1;
    private JButton adicionarButton;
    private JTextPane textPane1;
    private JSpinner spinner1;
    private JList list2;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JButton fltrarButton;

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
