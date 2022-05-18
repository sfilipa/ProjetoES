package eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarEvento extends JFrame{
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton adicionarNovoLocalDeButton;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel painelPrincipal;

    public AdicionarEvento(){
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
