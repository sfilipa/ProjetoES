package vista.eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarEvento extends JFrame{
    private JButton filtrarButton;
    private JList list1;
    private JButton editarButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JComboBox comboBox2;
    private JComboBox comboBox5;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton novoLocalDeExposiçãoButton;
    private JTextField textField2;

    public EditarEvento(){
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

}

