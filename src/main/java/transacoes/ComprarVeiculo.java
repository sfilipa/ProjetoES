package transacoes;

import pecas.PaginaInicialPecas;
import pecas.RemoverPeca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprarVeiculo extends JFrame{
    private JPanel painelPrincipal;
    private JButton comprarButton;
    private JButton cancelarButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton eletricoRadioButton;
    private JRadioButton automaticaRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JRadioButton traseiraRadioButton;
    private JTextField clientText;
    private JLabel cliente;
    private JLabel comprarVeiculo;
    private JComboBox comboBox1;
    private JLabel nome;
    private JLabel nif;
    private JTextField nomeText;
    private JTextField nifText;
    private JButton filtrarButton1;

    public ComprarVeiculo(){
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
        new ComprarVeiculo().setVisible(true);
    }
}
