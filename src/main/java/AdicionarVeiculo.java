import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JFrame {
    private JTextField textMatricula;
    private JTextField textMarca;
    private JButton adicionarButton;
    private JPanel painelPrincipal;
    private JTextField textModelo;
    private JTextField textDonoAnterior;
    private JTextField textNDonos;
    private JTextField textComb;
    private JTextField textCategoria;
    private JTextField textClasse;
    private JTextField textNPortas;
    private JTextField textPotencia;
    private JTextField textCilindrada;
    private JTextField textTipoCaixa;
    private JTextField textTracao;

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
//ver