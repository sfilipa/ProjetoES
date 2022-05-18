package cliente;

import eventos.ConsultarEvento;
import eventos.PaginaInicialEventos;
import paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialClientes extends JFrame {
    private JButton adicionarClienteButton;
    private JButton removerClienteButton;
    private JButton consultarButton;
    private JButton consultarHistoricoButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;



    public PaginaInicialClientes(){
        setContentPane(painelPrincipal);
        pack();



    }



    public static void main(String[] args) {
        new PaginaInicialClientes().setVisible(true);
    }
}
