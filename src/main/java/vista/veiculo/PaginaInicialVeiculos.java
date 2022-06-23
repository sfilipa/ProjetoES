package vista.veiculo;

import modelo.DadosAplicacao;
import modelo.Veiculo;
import vista.eventos.ConsultarEvento;
import vista.eventos.EditarEvento;
import vista.eventos.RemoverEvento;
import vista.paginaPrincipal.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialVeiculos extends JFrame{
    private JButton adicionarVeículoButton;
    private JButton editarVeículoButton;
    private JButton removerVeículoButton;
    private JButton consultarVeículoButton;
    private JButton repararVeículoButton;
    private JButton transportarVeículoButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;

    public PaginaInicialVeiculos(){
        setContentPane(painelPrincipal);
        pack();
        setVisible(true);

        adicionarVeículoButton.addActionListener(this::btnAdicionarVeiculoActionPerformed);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        removerVeículoButton.addActionListener(this::btnRemoverVeiculoActionPerformed);
        editarVeículoButton.addActionListener(this::btnEditarVeiculoActionPerformed);
        transportarVeículoButton.addActionListener(this::btnTransportarVeiculoActionPerformed);
        repararVeículoButton.addActionListener(this::btnRepararVeiculoActionPerformed);
        consultarVeículoButton.addActionListener(this::btnConsultarVeiculoActionPerformed);
    }

    private void btnAdicionarVeiculoActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnAdicionarVeiculo");
        Veiculo veiculo = AdicionarVeiculo.mostrarCriacaoVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.adicionarVeiculo(veiculo);
    }
    private void btnRemoverVeiculoActionPerformed(ActionEvent e) {
        System.out.println("Click no btnRemoverVeiculo");
        RemoverVeiculo.mostrarRemoverVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getVeiculos();
    }
    private void btnEditarVeiculoActionPerformed(ActionEvent e) {
        EditarVeiculo.mostrarEditarVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getVeiculos();
    }
    private void btnTransportarVeiculoActionPerformed(ActionEvent e) {
        TransportarVeiculo.mostrarTransportarVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getVeiculos();
    }
    private void btnRepararVeiculoActionPerformed(ActionEvent e) {
        RepararVeiculo.mostrarRepararVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getVeiculos();
    }
    private void btnConsultarVeiculoActionPerformed(ActionEvent e) {
        ConsultarVeiculo.mostrarConsultarVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();
    }

    private void btnVoltarActionPerformed(ActionEvent e) {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new PaginaInicialVeiculos().setVisible(true);
    }
}
