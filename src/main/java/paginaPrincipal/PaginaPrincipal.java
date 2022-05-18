package paginaPrincipal;

import veiculo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipal extends JFrame{
    private JButton veículosButton;
    private JButton peçasButton;
    private JButton transaçõesButton;
    private JButton sairButton;
    private JButton eventosButton;
    private JButton clientesButton;
    private JButton estatísticasButton;
    private JPanel painelPrincipal;


    public PaginaPrincipal(){
            setContentPane(painelPrincipal);
            pack();
            btnVeiculoActionPerformed();
            btnSairActionPerformed();
        }

        private void btnVeiculoActionPerformed() {
            veículosButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new PáginaInicialVeiculos().setVisible(true);
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