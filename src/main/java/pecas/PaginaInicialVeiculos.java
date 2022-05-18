package pecas;

import paginaPrincipal.PaginaPrincipal;
import transacoes.RemoverTransacao;
import veiculo.AdicionarVeiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialVeiculos extends JFrame{
    private JButton adicionarPecaButton;
    private JButton consultarPecaButton;
    private JButton editarPecaButton;
    private JButton pedirPecaButton;
    private JButton removerPecaButton;
    private JPanel painelPrincipal;
    private JLabel pecas;
    private JButton voltarButton;

    public PaginaInicialVeiculos(){
        setContentPane(painelPrincipal);
        pack();

        btnAdicionarPecaActionPerformed();
        btnConsultarPecaButtonActionPerformed();
        btnEditarPecaButtonActionPerformed();
        btnPedirPecaButtonActionPerformed();
        btnRemoverPecaButtonActionPerformed();
        btnVoltarButtonActionPerformed();
    }

    private void btnAdicionarPecaActionPerformed() {
        adicionarPecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarPeca().setVisible(true);
            }
        });
    }

    private void btnConsultarPecaButtonActionPerformed() {
        consultarPecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarPeca().setVisible(true);
            }
        });
    }

    private void btnEditarPecaButtonActionPerformed() {
        editarPecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EditarPeca().setVisible(true);
            }
        });
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
    public static void main(String[] args) {
        new PaginaInicialVeiculos().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
