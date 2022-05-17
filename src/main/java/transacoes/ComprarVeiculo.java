package transacoes;

import pecas.RemoverPeca;

import javax.swing.*;

public class ComprarVeiculo extends JFrame{
    private JPanel painelPrincipal;
    private JButton comprarButton;
    private JButton cancelarButton;
    private JTextField matriculaText;
    private JTextField marcaText;
    private JTextField modeloText;
    private JTextField donoAnteriorText;
    private JTextField nDonosText;
    private JTextField categoriaText;
    private JTextField classesText;
    private JTextField nPortasText;
    private JTextField potenciaText;
    private JTextField cilindradaText;
    private JTextField precoText;
    private JRadioButton gasolinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton eletricoRadioButton;
    private JRadioButton automaticaRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JRadioButton trazeiraRadioButton;
    private JTextField clientText;
    private JLabel matricula;
    private JLabel marca;
    private JLabel modelo;
    private JLabel donoAnterior;
    private JLabel nDonos;
    private JLabel combustivel;
    private JLabel categoria;
    private JLabel classe;
    private JLabel nPortas;
    private JLabel potencia;
    private JLabel cilindrada;
    private JLabel tipoCaixa;
    private JLabel tracao;
    private JLabel preco;
    private JLabel cliente;
    private JLabel comprarVeiculo;

    public ComprarVeiculo(){
        setContentPane(painelPrincipal);
        pack();
    }

    public static void main(String[] args) {
        new ComprarVeiculo().setVisible(true);
    }
}
