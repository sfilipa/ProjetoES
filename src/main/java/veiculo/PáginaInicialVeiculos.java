package veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PáginaInicialVeiculos extends JFrame{
    private JButton adicionarVeículoButton;
    private JButton editarVeículoButton;
    private JButton removerVeículoButton;
    private JButton consultarVeículoButton;
    private JButton repararVeículoButton;
    private JButton transportarVeículoButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;

    public PáginaInicialVeiculos(){
        setContentPane(painelPrincipal);
        pack();

        btnAdicionarVeiculoActionPerformed();
        btnRemoverVeiculoActionPerformed();
        btnEditarVeiculoActionPerformed();
        btnRepararVeiculoActionPerformed();
        btnTransportarVeiculoActionPerformed();
        btnConsultarVeiculoActionPerformed();

    }

    private void btnAdicionarVeiculoActionPerformed() {
        adicionarVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarVeiculo().setVisible(true);
            }
        });
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

    public static void main(String[] args) {
        new PáginaInicialVeiculos().setVisible(true);
    }
}
