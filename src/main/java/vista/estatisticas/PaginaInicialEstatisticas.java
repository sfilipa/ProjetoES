package vista.estatisticas;

import modelo.DadosAplicacao;
import vista.paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialEstatisticas extends JFrame{
    private JPanel painelPrincipal;
    private JButton voltarButton;
    private JButton consultarEstatisticasDeClientesButton;
    private JButton consultarEstatisticasDeMarcasButton;
    private JButton consultarEstatisticasDeModelosButton;

    public PaginaInicialEstatisticas(){
        setContentPane(painelPrincipal);
        pack();


        btnVoltarActionPerformed();

        consultarEstatisticasDeClientesButton.addActionListener(this::btnConsultarClienteActionPerformed);

       // btnEstatisticasPagina1ActionPerformed();
        btnEstatisticasPagina2ActionPerformed();
        btnEstatisticasPagina3ActionPerformed();



    }

    private void btnConsultarClienteActionPerformed(ActionEvent e) {
        EstatisticasPagina1.mostrarConsultarCliente(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();
    }

/*    private void btnEstatisticasPagina1ActionPerformed() {
        consultarEstatisticasDeClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EstatisticasPagina1().setVisible(true);
            }
        });
    }*/

    private void btnEstatisticasPagina2ActionPerformed() {
        consultarEstatisticasDeMarcasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EstatisticasPagina2().setVisible(true);
            }
        });
    }

    private void btnEstatisticasPagina3ActionPerformed() {
        consultarEstatisticasDeModelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EstatisticasPagina3().setVisible(true);
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



