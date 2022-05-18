package eventos;

import paginaPrincipal.PaginaPrincipal;
import veiculo.ConsultarVeiculo;
import veiculo.PaginaInicialVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialEventos extends JFrame{
    private JButton adicionarEventoButton;
    private JButton removerEventoButton;
    private JButton consultarButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;
    private JButton editarEventoButton;

    public PaginaInicialEventos(){
        setContentPane(painelPrincipal);
        pack();

        btnConsultarEventoActionPerformed();
        btnVoltarActionPerformed();
        btnAdicionarEventoActionPerformed();
        btnRemoverEventoActionPerformed();
        btnEditarEventoActionPerformed();
    }

    private void btnAdicionarEventoActionPerformed() {
        adicionarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarEvento().setVisible(true);
            }
        });
    }

    private void btnRemoverEventoActionPerformed() {
        removerEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverEvento().setVisible(true);
            }
        });
    }

    private void btnEditarEventoActionPerformed() {
        editarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EditarEvento().setVisible(true);
            }
        });
    }

    private void btnConsultarEventoActionPerformed() {
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarEvento().setVisible(true);
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
        new PaginaInicialEventos().setVisible(true);
    }
}
