package cliente;

import veiculo.AdicionarVeiculo;
import veiculo.PaginaInicialVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarCliente extends JFrame {
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JRadioButton simRadioButton;
    private JRadioButton nãoRadioButton;
    private JButton adicionarVeículoButton;


    public AdicionarCliente(){
        setContentPane(painelPrincipal);
        pack();
        btnCancelarActionPerformed();
        btnAdicionarVeiculoActionPerformed();

    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialClientes().setVisible(true);
            }
        });
    }

    private void btnAdicionarVeiculoActionPerformed() {
        adicionarVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarVeiculo().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new AdicionarCliente().setVisible(true);
    }


}
