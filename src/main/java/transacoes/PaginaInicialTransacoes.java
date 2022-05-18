package transacoes;

import paginaPrincipal.PaginaPrincipal;
import pecas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialTransacoes extends JFrame {
    private JLabel transacoes;
    private JButton removerTransacaoButton;
    private JButton comprarVeiculoButton;
    private JButton venderVeiculoButton;
    private JButton trocarVeiculoButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;

    public PaginaInicialTransacoes(){
        setContentPane(painelPrincipal);
        pack();

        btnComprarVeiculoActionPerformed();
        btnRemoverTransacaoButtonnActionPerformed();
        btnTrocarVeiculoButtonActionPerformed();
        btnVenderVeiculoButtonActionPerformed();
        btnVoltarButtonActionPerformed();

    }

    private void btnComprarVeiculoActionPerformed() {
        comprarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ComprarVeiculo().setVisible(true);
            }
        });
    }

    private void btnRemoverTransacaoButtonnActionPerformed() {
        removerTransacaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverTransacao().setVisible(true);
            }
        });
    }

    private void btnTrocarVeiculoButtonActionPerformed() {
        trocarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TrocarVeiculo().setVisible(true);
            }
        });
    }

    private void btnVenderVeiculoButtonActionPerformed() {
        venderVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new VenderVeiculo().setVisible(true);
            }
        });
    }

    private void btnVoltarButtonActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaPrincipal().setVisible(true);
            }
        });
    }



    public static void main(String[] args) {
        new PaginaInicialTransacoes().setVisible(true);
    }
}
