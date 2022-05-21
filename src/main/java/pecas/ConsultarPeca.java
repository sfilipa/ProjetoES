package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarPeca extends JFrame {
    private JLabel consultarPeca;
    private JButton voltarButton;
    private JLabel localArmazenamento;
    private JLabel localArmazenamentoText;
    private JLabel tipoPeca;
    private JLabel tipoPecaText;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaSedeText;
    private JLabel quantidadeMinimaFileal;
    private JLabel quantidadeMinimaFilealText;
    private JPanel painelPrincipal;
    private JLabel nomePeca;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton comsumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list1;

    public ConsultarPeca(){
        setContentPane(painelPrincipal);
        pack();

        btnVoltarActionPerformed();
    }

    private void btnVoltarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new ConsultarPeca().setVisible(true);
    }
}

