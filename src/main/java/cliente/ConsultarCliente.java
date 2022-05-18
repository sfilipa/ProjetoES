package cliente;

import eventos.ConsultarEvento;

import javax.swing.*;

public class ConsultarCliente extends JFrame {
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JComboBox comboBox1;
    private JButton voltarButton;

    public ConsultarCliente(){
        setContentPane(painelPrincipal);
        pack();

    }


    public static void main(String[] args) {
        new ConsultarEvento().setVisible(true);
    }

    public void setVisible(boolean b) {
    }
}
