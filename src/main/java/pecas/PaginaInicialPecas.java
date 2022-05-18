package pecas;

import paginaPrincipal.PaginaPrincipal;

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

    public PaginaInicialPecas(){
        setContentPane(painelPrincipal);
        pack();

        btnAdicionarPecaActionPerformed();
        btnConsultarPecaButtonActionPerformed();
        btnEditarPecaButtonActionPerformed();
        btnPedirPecaButtonActionPerformed();
        btnRemoverPecaButtonActionPerformed();
        btnVoltarButtonActionPerformed();
        btnAdicionarStockActionPerformed();
        btnRemoverStockActionPerformed();
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

    private void btnAdicionarStockActionPerformed(){
        adicionarStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarStockPeca().setVisible(true);
            }
        });
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
    public static void main(String[] args) {
        new PaginaInicialPecas().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
