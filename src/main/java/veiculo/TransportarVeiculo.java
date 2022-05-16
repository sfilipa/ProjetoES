package veiculo;

import javax.swing.*;

public class TransportarVeiculo extends JFrame{
    DefaultListModel listmodelVeiculos = new DefaultListModel();
    DefaultListModel listmodelLugares = new DefaultListModel();
    private JPanel painelPrincipal;
    private JList listVeiculos;
    private JList listLugares;
    private JButton transportarButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public TransportarVeiculo(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new TransportarVeiculo().setVisible(true);
    }
}
