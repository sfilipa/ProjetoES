package vista.cliente;

import modelo.Cliente;
import modelo.DadosAplicacao;
import modelo.Evento;
import vista.eventos.AdicionarEvento;
import vista.paginaPrincipal.PaginaPrincipal;
import vista.veiculo.ConsultarVeiculo;

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

        adicionarClienteButton.addActionListener(this::btnAdicionarClienteActionPerformed);
        consultarClienteButton.addActionListener(this::btnConsultarClienteActionPerformed);
        btnRemoverActionPerfomed();
        //btnConsultarClientePerfomed();
        btnVoltarActionPerformed();
        btnConsultarHistoricoTransacaoClientePerfomed();
    }

    private void btnAdicionarClienteActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnAdicionarCliente");
        Cliente cliente = AdicionarCliente.mostrarCriacaoCliente(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.adicionarCliente(cliente);
    }

    private void btnConsultarVeiculoActionPerformed(ActionEvent e) {
        ConsultarVeiculo.mostrarConsultarVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();
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



    private void btnRemoverActionPerfomed(){
        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverCliente().setVisible(true);
            }
        });
    }

/*    private void btnConsultarClientePerfomed() {
        consultarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarCliente().setVisible(true);
            }
        });
    }*/

    private void btnConsultarClienteActionPerformed(ActionEvent e) {
        ConsultarCliente.mostrarConsultarCliente(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();
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
