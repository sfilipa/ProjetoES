package cliente;

import eventos.ConsultarEvento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarCliente extends JFrame {
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JButton voltarButton;
    private JTextField textField1;
    private JList list1;
    private JButton filtrarButton;

    public ConsultarCliente(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();

    }

    private void btnCancelarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialClientes().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new ConsultarCliente().setVisible(true);
    }



}
