package pecas;

import veiculo.PaginaInicialVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarPeca extends JFrame{
    private JPanel painelPrincipal;
    private JLabel adicionarPeca;
    private JTextField nomePecaTextField;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField quantidadeMinimaSedeText;
    private JTextField quantidadeMinimaFilealText;
    private JButton adicionarPecaButton;
    private JButton cancelarButton;
    private JLabel nomePeca;
    private JLabel tipoPeca;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaFileal;

    public AdicionarPeca(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new AdicionarPeca().setVisible(true);
    }
}

