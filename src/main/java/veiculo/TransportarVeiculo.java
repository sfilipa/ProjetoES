package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransportarVeiculo extends JFrame{
    private JPanel painelPrincipal;
    private JButton transportarButton;
    private JButton cancelarButton;
    private JRadioButton sedeRadioButton;
    private JRadioButton filialLocalDeExposiçãoRadioButton;
    private JComboBox comboBox2;
    private JRadioButton simRadioButton;
    private JRadioButton nãoRadioButton;
    private JList list1;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JButton filtrarButton;
    private JComboBox comboBox9;

    public TransportarVeiculo(){
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
        new TransportarVeiculo().setVisible(true);
    }
}
