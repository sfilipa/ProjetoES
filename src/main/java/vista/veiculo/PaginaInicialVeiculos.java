package vista.veiculo;

import modelo.DadosAplicacao;
import modelo.Veiculo;
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

        /*btnAdicionarVeiculoActionPerformed();
        btnRemoverVeiculoActionPerformed();
        btnEditarVeiculoActionPerformed();
        btnRepararVeiculoActionPerformed();
        btnTransportarVeiculoActionPerformed();
        btnConsultarVeiculoActionPerformed();
        btnVoltarActionPerformed();*/

    }

    private void btnAdicionarVeiculoActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnAdicionarVeiculo");
        Veiculo veiculo = AdicionarVeiculo.mostrarCriacaoVeiculo(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.adicionarVeiculo(veiculo);
    }
    private void btnRemoverVeiculoActionPerformed() {
        removerVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverVeiculo().setVisible(true);
            }
        });
    }
    private void btnEditarVeiculoActionPerformed() {
        editarVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EditarVeiculo().setVisible(true);
            }
        });
    }
    private void btnTransportarVeiculoActionPerformed() {
        transportarVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TransportarVeiculo().setVisible(true);
            }
        });
    }
    private void btnRepararVeiculoActionPerformed() {
        repararVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RepararVeiculo().setVisible(true);
            }
        });
    }
    private void btnConsultarVeiculoActionPerformed() {
        consultarVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarVeiculo().setVisible(true);
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
        new PaginaInicialVeiculos().setVisible(true);
    }
}
