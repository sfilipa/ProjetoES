package paginaPrincipal;

import cliente.PaginaInicialClientes;
import eventos.PaginaInicialEventos;
import pecas.PaginaInicialPecas;
import veiculo.*;

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
            btnClienteActionPerfomed();
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


    private void btnClienteActionPerfomed() {
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialClientes().setVisible(true);
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
