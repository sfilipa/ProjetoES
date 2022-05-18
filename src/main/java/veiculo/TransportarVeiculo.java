package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransportarVeiculo extends JFrame{
    private JPanel painelPrincipal;
    private JButton transportarButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JRadioButton sedeRadioButton;
    private JRadioButton filialRadioButton;
    private JComboBox comboBox2;
    private JRadioButton simRadioButton;
    private JRadioButton nãoRadioButton;
    private JComboBox comboBox3;

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
