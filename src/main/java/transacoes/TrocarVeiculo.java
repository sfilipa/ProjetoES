package transacoes;

import pecas.RemoverPeca;

import javax.swing.*;

public class TrocarVeiculo extends JFrame {


    private JPanel painelPrincipal;
    private JLabel trocarVeiculo;
    private JComboBox veiculoEntregarText;
    private JComboBox veiculoReceberBox;
    private JLabel valorVeiculoReceber;
    private JLabel valorVeiculoEntregar;
    private JLabel veioculoReceber;
    private JLabel veiculoEntregar;
    private JTextField valorVeiculoEntregarText;
    private JTextField valorVeiculoReceberText;
    private JButton trocarButton;
    private JButton cancelarButton;
    private JTextField valorPagarReceberText;
    private JLabel valorPagarReceber;

    public TrocarVeiculo(){
        setContentPane(painelPrincipal);
        pack();
    }

    public static void main(String[] args) {
        new TrocarVeiculo().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
