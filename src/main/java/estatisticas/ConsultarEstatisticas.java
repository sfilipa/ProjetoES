package estatisticas;

import eventos.ConsultarEvento;
import eventos.PaginaInicialEventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarEstatisticas extends  JFrame{
    private JComboBox comboBox1;
    private JPanel painelPrincipal;
    private JButton voltarButton;

    public ConsultarEstatisticas(){
        setContentPane(painelPrincipal);
        pack();

        btnVoltarActionPerformed();
    }

    private void btnVoltarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEstatisticas().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new ConsultarEstatisticas().setVisible(true);
    }

}
