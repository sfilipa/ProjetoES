package vista.cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverCliente extends JFrame{
    private JPanel painelPrincipal;
    private JButton removerButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JButton filtrarButton;
    private JList list1;

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
        new RemoverCliente().setVisible(true);
    }

}
