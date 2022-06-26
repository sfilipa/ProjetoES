package vista.transacoes;

import modelo.DadosAplicacao;
import modelo.Peca;
import modelo.Veiculo;
import vista.paginaPrincipal.PaginaPrincipal;
import vista.pecas.AdicionarStockPeca;

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
        System.out.println("Clicou no btnComprarVeiculo!");
        Veiculo veiculo = ComprarVeiculo.mostrarComprarVeiculo(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.adicionarVeiculo(veiculo);
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
