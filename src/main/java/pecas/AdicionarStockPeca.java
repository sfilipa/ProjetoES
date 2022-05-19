package pecas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarStockPeca extends JFrame {
    private JPanel painelPrincipal;
    private JSpinner quantidadeAdicionarSpiner;
    private JList filealSedeAdicionarList;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JComboBox pecaAdicionarComboBox;
    private JLabel filealSedeAdicionar;
    private JLabel quantidadeAdicionar;
    private JLabel pecaAdicionar;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton comsumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;

    public AdicionarStockPeca(){
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
        new AdicionarStockPeca().setVisible(true);
    }
}

