package estatisticas;

import cliente.PaginaInicialClientes;
import paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialEstatisticas extends JFrame{
    private JButton listagemDeEstatisticasButton;
    private JPanel painelPrincipal;
    private JButton consultarEstatisticasButton;
    private JButton voltarButton;


    public PaginaInicialEstatisticas(){
        setContentPane(painelPrincipal);
        pack();

        btnListaEstatisticasActionPerfomed();
        btnConsultarEstatisticaActionPerformed();
        btnVoltarActionPerformed();
    }

    private void btnListaEstatisticasActionPerfomed() {
        listagemDeEstatisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListaEstatisticas().setVisible(true);
            }
        });
    }



    private void btnConsultarEstatisticaActionPerformed() {
        consultarEstatisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarEstatisticas().setVisible(true);
            }
        });
    }



    private void btnVoltarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new PaginaInicialEstatisticas().setVisible(true);
    }

}
