package eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverEvento extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton filtrarButton;
    private JList list1;
    private JButton removerButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;


    public RemoverEvento(){
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
