package vista.cliente;

import vista.paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialClientes extends JFrame {
    private JButton adicionarClienteButton;
    private JButton removerClienteButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;
    private JButton consultarClienteButton;
    private JButton consultarHistoricoTransacaoClienteButton;


    public PaginaInicialClientes(){
        setContentPane(painelPrincipal);
        pack();

        btnAdicionarActionPerfomed();
        btnRemoverActionPerfomed();
        btnConsultarClientePerfomed();
        btnVoltarActionPerformed();
        btnConsultarHistoricoTransacaoClientePerfomed();
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

    private void btnAdicionarActionPerfomed(){
        adicionarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarCliente().setVisible(true);
            }
        });
    }


    private void btnRemoverActionPerfomed(){
        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverCliente().setVisible(true);
            }
        });
    }

    private void btnConsultarClientePerfomed() {
        consultarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarCliente().setVisible(true);
            }
        });
    }


    public void btnConsultarHistoricoTransacaoClientePerfomed(){
        consultarHistoricoTransacaoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarHistoricoTransacaoCliente().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new PaginaInicialClientes().setVisible(true);
    }
}