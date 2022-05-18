package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarVeiculo extends JFrame {
    private JButton editarButton;
    private JPanel painelPrincipal;
    private JTextField textModelo;
    private JComboBox comboBox1;
    private JButton cancelarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JRadioButton gasolinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton elétricoRadioButton;
    private JRadioButton automáticaRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton traseiraRadioButton;

    public EditarVeiculo(){
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
        new EditarVeiculo().setVisible(true);
    }
}
