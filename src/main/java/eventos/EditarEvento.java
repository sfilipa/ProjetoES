package eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarEvento extends JFrame{
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton filtrarButton;
    private JList list1;
    private JButton editarButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JPanel painelPrincipal;

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


    public static void main(String[] args) {
        new ConsultarEvento().setVisible(true);
    }
}

