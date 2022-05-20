package eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarLocalExposicao extends JFrame {


    private JTextField nomeExposiçaoTextField;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;


    public AdicionarLocalExposicao(){
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
        new AdicionarLocalExposicao().setVisible(true);
    }
}
