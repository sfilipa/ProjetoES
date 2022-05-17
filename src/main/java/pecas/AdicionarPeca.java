import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarPeca extends JFrame{
    private JTextField textNome;
    private JList filealList;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField qtMinimaPorFileal;
    private JTextField qtMinimaPorSede;
    private JButton adicionarButton;
    private JPanel painelPrincipal;

    public AdicionarPeca(){
        setContentPane(painelPrincipal);
        pack();

        }

    public static void main(String[] args) {
        new AdicionarPeca().setVisible(true);
    }
}
