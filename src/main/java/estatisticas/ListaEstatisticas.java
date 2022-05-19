package estatisticas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaEstatisticas extends JFrame{
    private JPanel painelPrincipal;
    private JButton voltarButton;


    public ListaEstatisticas(){
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
        new ListaEstatisticas().setVisible(true);
    }

}
