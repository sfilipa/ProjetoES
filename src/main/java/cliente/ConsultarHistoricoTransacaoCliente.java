package cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarHistoricoTransacaoCliente extends JFrame {
    private JComboBox comboBox1;
    private JButton voltarButton;
    private JPanel painelPrincipal;


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
