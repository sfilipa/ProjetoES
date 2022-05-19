package eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarLocalExposicao extends JFrame{
    private JPanel painelPrincipal;
    private JList list1;
    private JComboBox comboBox1;
    private JButton voltarButton;


    public ConsultarLocalExposicao(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();

    }


    private void btnCancelarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEventos().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new ConsultarLocalExposicao().setVisible(true);
    }
}
