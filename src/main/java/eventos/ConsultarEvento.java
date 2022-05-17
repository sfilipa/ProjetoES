package eventos;

import javax.swing.*;

public class ConsultarEvento extends JFrame {
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JComboBox comboBox1;
    private JButton voltarButton;

    public ConsultarEvento(){
        setContentPane(painelPrincipal);
        pack();


    }


    public static void main(String[] args) {
        new ConsultarEvento().setVisible(true);
    }
}
