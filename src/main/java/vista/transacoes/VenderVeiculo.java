package vista.transacoes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VenderVeiculo extends JFrame {
    private JLabel veiculo;
    private JLabel venderVeiculo;
    private JTextField precoText;
    private JLabel preco;
    private JButton venderVeiculoButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox3;
    private JComboBox comboBox6;
    private JButton filtrarButton;
    private JList clienteList;
    private JList list1;
    private JLabel cliente;
    private JLabel nome;
    private JLabel nif;
    private JTextField nomeText;
    private JTextField nifText;
    private JButton filtrarButton1;

    public VenderVeiculo(){
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
        new VenderVeiculo().setVisible(true);
    }
}
