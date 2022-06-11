package vista.paginaPrincipal;

import vista.cliente.PaginaInicialClientes;
import vista.estatisticas.PaginaInicialEstatisticas;
import vista.eventos.PaginaInicialEventos;
import vista.pecas.PaginaInicialPecas;
import vista.transacoes.PaginaInicialTransacoes;
import vista.veiculo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipal extends JFrame{
    private JButton veículosButton;
    private JButton pecasButton;
    private JButton transacoesButton;
    private JButton sairButton;
    private JButton eventosButton;
    private JButton clientesButton;
    private JButton estatisticasButton;
    private JPanel painelPrincipal;


    public PaginaPrincipal(){
            setContentPane(painelPrincipal);
            pack();
            btnVeiculoActionPerformed();
            btnEventoActionPerformed();
            btnSairActionPerformed();
            btnPecasActionPerformed();
            btnTransacoesPerformed();
            btnClientesActionPerformed();
            btnEstatisticasActionPerfomed();
        }

        private void btnVeiculoActionPerformed() {
            veículosButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new PaginaInicialVeiculos().setVisible(true);
                }
            });
        }

    private void btnEventoActionPerformed() {
        eventosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEventos().setVisible(true);
            }
        });
    }

    private void btnPecasActionPerformed() {
        pecasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
    }

    private void btnTransacoesPerformed() {
        transacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialTransacoes().setVisible(true);
            }
        });
    }

    private void btnClientesActionPerformed(){
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialClientes().setVisible(true);
            }
        });
    }

    private void btnEstatisticasActionPerfomed() {
        estatisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEstatisticas().setVisible(true);
            }
        });
    }


    private void btnSairActionPerformed() {
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

        public static void main(String[] args) {
            new PaginaPrincipal().setVisible(true);
        }
    }
