package transacoes;

import pecas.RemoverPeca;

import javax.swing.*;

public class TrocarVeiculo extends JFrame {


    private JPanel painelPrincipal;
    private JLabel trocarVeiculo;
    private JComboBox veiculoEntregarText;
    private JComboBox veiculoReceberBox;
    private JLabel dinheiroPagar;
    private JLabel dinheiroReceber;
    private JLabel veioculoReceber;
    private JLabel veiculoEntregar;
    private JTextField dinheiroReceberText;
    private JTextField dinheiroPagarText;
    private JButton trocarButton;
    private JButton cancelarButton;

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
