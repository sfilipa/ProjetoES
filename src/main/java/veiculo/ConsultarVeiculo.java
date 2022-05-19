package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarVeiculo extends JFrame{
    private JPanel painelPrincipal;
    private JLabel lblMatricula;
    private JLabel lblMarca;
    private JLabel lblComb;
    private JLabel lblPortas;
    private JButton voltarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton filtrarButton;
    private JList list1;
    private JLabel lblDonoAnterior;
    private JTextArea textDetalhes;

    public ConsultarVeiculo(){
        setContentPane(painelPrincipal);
        pack();
        btnVoltarActionPerformed();

    }

    private void btnVoltarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialVeiculos().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new ConsultarVeiculo().setVisible(true);
    }
}
