package eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverLocalExposicao extends JFrame {


    private JTextField nomeExposiçaoTextField;
    private JTextField filialAssociadaTextField;
    private JPanel painelPrincipal;
    private JButton removerButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JButton adicionarButton;


    public RemoverLocalExposicao(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();

    }


    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEventos().setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new RemoverLocalExposicao().setVisible(true);
    }
}