package cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarHistoricoTransacaoCliente extends JFrame {
    private JButton voltarButton;
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JButton filtrarButton;
    private JList list1;
    private JList list2;


    public ConsultarHistoricoTransacaoCliente(){
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
        new ConsultarHistoricoTransacaoCliente().setVisible(true);
    }


}
