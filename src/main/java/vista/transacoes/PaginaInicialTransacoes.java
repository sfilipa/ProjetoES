package vista.transacoes;

import modelo.DadosAplicacao;
import modelo.Peca;
import modelo.Transacao;
import modelo.Veiculo;
import vista.paginaPrincipal.PaginaPrincipal;
import vista.pecas.AdicionarStockPeca;
import vista.pecas.RemoverPeca;
import vista.veiculo.RemoverVeiculo;

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


        comprarVeiculoButton.addActionListener(this::btnComprarVeiculoActionPerformed);
        removerTransacaoButton.addActionListener(this::btnRemoverTransacaoButtonnActionPerformed);
        trocarVeiculoButton.addActionListener(this::btnTrocarVeiculoButtonActionPerformed);
        venderVeiculoButton.addActionListener(this::btnVenderVeiculoButtonActionPerformed);
        voltarButton.addActionListener(this::btnVoltarButtonActionPerformed);

    }

    private void btnComprarVeiculoActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnComprarVeiculo!");
        Transacao transacao = ComprarVeiculo.mostrarComprarVeiculo(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.comprarVeiculo(transacao);
    }

    private void btnRemoverTransacaoButtonnActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnRemoverTransacaoButton!");
        Veiculo veiculo = RemoverVeiculo.mostrarRemoverVeiculo(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.removerVeiculo(veiculo);
    }

    private void btnTrocarVeiculoButtonActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnTrocarVeiculoButton!");
        Veiculo veiculo = TrocarVeiculo.mostrarTrocarVeiculo(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.trocarVeiculo(veiculo, veiculo);
    }

    private void btnVenderVeiculoButtonActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnVenderVeiculo!");
        Veiculo veiculo = VenderVeiculo.mostrarVenderVeiculo(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.removerVeiculo(veiculo);
    }


    private void btnVoltarButtonActionPerformed(ActionEvent evt) {
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
