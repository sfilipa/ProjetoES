package veiculo;

import javax.swing.*;

public class RemoverVeiculo extends JFrame {
    DefaultListModel listmodel = new DefaultListModel();
    private JList listVeiculos;
    private JButton removerButton;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JComboBox comboBox1;

    public RemoverVeiculo(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new RemoverVeiculo().setVisible(true);
    }
}
