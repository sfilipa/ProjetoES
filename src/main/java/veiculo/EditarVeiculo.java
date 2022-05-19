package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarVeiculo extends JFrame {
    private JButton editarButton;
    private JPanel painelPrincipal;
    private JTextField textModelo;
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
    private JRadioButton muitoBomRadioButton1;
    private JRadioButton bomRadioButton;
    private JRadioButton médioRadioButton;
    private JRadioButton mauRadioButton;
    private JRadioButton muitoMauRadioButton;
    private JList list1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton filtrarButton;
    private JTextField textField5;

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
