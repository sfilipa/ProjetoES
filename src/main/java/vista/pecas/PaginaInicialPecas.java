package vista.pecas;

import modelo.DadosAplicacao;
import modelo.Peca;
import vista.paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialPecas extends JFrame{
    private JButton adicionarPecaButton;
    private JButton consultarPecaButton;
    private JButton editarPecaButton;
    private JButton pedirPecaButton;
    private JButton removerPecaButton;
    private JPanel painelPrincipal;
    private JLabel pecas;
    private JButton voltarButton;
    private JButton adicionarStockButton;
    private JButton removerStockButton;
    private JButton consultarStockPeca;

    public PaginaInicialPecas(){
        setContentPane(painelPrincipal);
        pack();

        adicionarPecaButton.addActionListener(this::btnAdicionarPecaActionPerformed);
        consultarPecaButton.addActionListener(this::btnConsultarPecaButtonActionPerformed);
        editarPecaButton.addActionListener(this::btnEditarPecaButtonActionPerformed);
        btnPedirPecaButtonActionPerformed();
        btnRemoverPecaButtonActionPerformed();
        btnVoltarButtonActionPerformed();
        adicionarStockButton.addActionListener(this::btnAdicionarStockActionPerformed);
        btnRemoverStockActionPerformed();
        consultarStockPeca.addActionListener(this::btnConsultarStockPecaActionPerformed);
    }

    private void btnAdicionarPecaActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnAdicionarPeca!");
        Peca peca = AdicionarPeca.mostrarCriacaoPeca(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.adicionarPeca(peca);
    }

    private void btnConsultarPecaButtonActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnConsultarPeca!");
        Peca peca = ConsultarPeca.mostrarConsultarPeca(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.consultarPeca(String.valueOf(peca));
        // n sei pq n consigo usar só peca ent faço string.valueof(peca)
    }

    private void btnEditarPecaButtonActionPerformed(ActionEvent evt) {
        System.out.println("Clicou no btnEditarPeca!");
        Peca peca = EditarPeca.mostrarEditarPeca(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.editarPeca(peca);
    }

    private void btnPedirPecaButtonActionPerformed() {
        pedirPecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PedirPeca().setVisible(true);
            }
        });
    }

    private void btnRemoverPecaButtonActionPerformed() {
        removerPecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverPeca().setVisible(true);
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

    private void btnAdicionarStockActionPerformed(ActionEvent evt){
        System.out.println("Clicou no btnAdicionarStockPeca!");
        Peca peca = AdicionarStockPeca.mostrarStockPeca(this);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.adicionarPeca(peca);
    }


    private void btnRemoverStockActionPerformed(){
        removerStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverStockPeca().setVisible(true);
            }
        });
    }

    private void btnConsultarStockPecaActionPerformed(ActionEvent evt){
        consultarStockPeca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarStockPeca().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new PaginaInicialPecas().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
