package cliente;

import veiculo.AdicionarVeiculo;
import veiculo.PaginaInicialVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverCliente extends JFrame{
    private JPanel painelPrincipal;
    private JComboBox comboBox1;
    private JButton removerButton;
    private JButton cancelarButton;

    public RemoverCliente(){
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
