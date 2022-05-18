package cliente;

import veiculo.AdicionarVeiculo;
import veiculo.PaginaInicialVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarCliente extends JFrame {
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField2;
    private JButton cancelarButton;
    private JButton adicionarButton;


    public AdicionarCliente(){
        setContentPane(painelPrincipal);
        pack();
        btnCancelarActionPerformed();

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


    public static void main(String[] args) {
        new AdicionarVeiculo().setVisible(true);
    }


}
