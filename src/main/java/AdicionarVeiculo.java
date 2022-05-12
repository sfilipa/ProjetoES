import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton adicionarButton;
    private JPanel painelPrincipal;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;

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
