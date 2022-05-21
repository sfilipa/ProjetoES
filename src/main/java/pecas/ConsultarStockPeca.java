package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarStockPeca extends JFrame{
    private JPanel painelPrincipal;
    private JLabel consultarPeca;
    private JLabel nomePeca;
    private JLabel localArmazenamento;
    private JLabel tipoPeca;
    private JLabel tipoPecaText;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaFileal;
    private JLabel quantidadeMinimaSedeText;
    private JList list1;
    private JButton voltarButton;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton comsumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list2;
    private JButton consultarButton;

    public ConsultarStockPeca(){
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
}
