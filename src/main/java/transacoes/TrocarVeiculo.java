package transacoes;

import pecas.RemoverPeca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrocarVeiculo extends JFrame {


    private JPanel painelPrincipal;
    private JLabel trocarVeiculo;
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
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox3;
    private JComboBox comboBox6;
    private JButton filtrarButton;
    private JLabel cliente;
    private JLabel nif;
    private JLabel nome;
    private JTextField nomeText;
    private JTextField nifText;
    private JButton filtrarButton1;
    private JList clienteList;
    private JList veiculoEntregarList;
    private JLabel clientee;
    private JList veiculoReceberList;

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

}
