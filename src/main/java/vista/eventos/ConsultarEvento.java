package vista.eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarEvento extends JFrame {
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JButton voltarButton;
    private JButton filtrarButton;
    private JList list1;
    private JComboBox comboBox2;
    private JComboBox comboBox5;

    public ConsultarEvento(){
        setContentPane(painelPrincipal);
        pack();
        btnVoltarActionPerformed();


    }

    private void btnVoltarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEventos().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new ConsultarEvento().setVisible(true);
    }
}
