package estatisticas;

import paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstatisticasPagina2 extends  JFrame{
    private JPanel painelPrincipal;
    private JButton voltarButton;
    private JList list1;
    private JList list2;
    private JList list3;

    public EstatisticasPagina2(){
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
        new EstatisticasPagina2().setVisible(true);
    }

}
