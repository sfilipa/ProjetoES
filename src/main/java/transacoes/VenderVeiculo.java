package transacoes;

import javax.swing.*;

public class VenderVeiculo extends JFrame {
    private JComboBox veiculoBox;
    private JLabel veiculo;
    private JLabel venderVeiculo;
    private JTextField precoText;
    private JLabel preco;
    private JButton venderVeiculoButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;

    public VenderVeiculo(){
        setContentPane(painelPrincipal);
        pack();
    }

    public static void main(String[] args) {
        new VenderVeiculo().setVisible(true);
    }
}
