import javax.swing.*;

public class PedirPeca extends JFrame{
    private JPanel painelPrincipal;
    private JList pecaList;
    private JButton requisitarButton;
    private JLabel peca;
    private JLabel pedirPecaText;
    private JButton cancelarButton;
    private JLabel sedeFilealRequisita;
    private JLabel sedeFilealEntrega;
    private JComboBox sedeFilealRequisitaBox;
    private JComboBox sedeFilealEntregaBox;

    public PedirPeca(){
        setContentPane(painelPrincipal);
        pack();

    }

    public static void main(String[] args) {
        new PedirPeca().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
