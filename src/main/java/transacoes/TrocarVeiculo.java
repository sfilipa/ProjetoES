package transacoes;

import pecas.RemoverPeca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialTransacoes().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new TrocarVeiculo().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
