package transacoes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverTransacao extends JFrame{
    private JPanel painelPrincipal;
    private JLabel removerTransacao;
    private JButton removerTransacaoButton;
    private JButton cancelarButton;
    private JLabel transacaoRemover;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton dinheiroRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list1;
    private JComboBox comboBox1;

    public RemoverTransacao(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialTransacoes().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new RemoverTransacao().setVisible(true);
    }
}
