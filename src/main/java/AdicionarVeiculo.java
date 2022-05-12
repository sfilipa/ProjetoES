import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton adicionarButton;
    private JPanel painelPrincipal;

    public AdicionarVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new AdicionarVeiculo().setVisible(true);
    }
}
