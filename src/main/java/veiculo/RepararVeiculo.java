package veiculo;

import javax.swing.*;

public class RepararVeiculo extends JFrame {
    DefaultListModel listmodelVeiculos = new DefaultListModel();
    DefaultListModel listmodelPecas = new DefaultListModel();
    private JList listVeiculos;
    private JList listPecas;
    private JButton repararButton;
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public RepararVeiculo(){
        setContentPane(painelPrincipal);
        pack();


    }
    public static void main(String[] args) {
        new RepararVeiculo().setVisible(true);
    }
}
