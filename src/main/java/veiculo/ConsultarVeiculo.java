package veiculo;

import javax.swing.*;

public class ConsultarVeiculo extends JFrame{
    DefaultListModel listmodel = new DefaultListModel();
    private JList listVeiculos;
    private JPanel painelPrincipal;
    private JLabel lblMatricula;
    private JLabel lblMarca;
    private JLabel lblComb;
    private JLabel lblPortas;
    private JButton voltarButton;
    private JComboBox comboBox1;
    private JLabel lblDonoAnterior;
    private JTextArea textDetalhes;

    public ConsultarVeiculo(){
        setContentPane(painelPrincipal);
        pack();


    }


    public static void main(String[] args) {
        new ConsultarVeiculo().setVisible(true);
    }
}
