package transacoes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VenderVeiculo extends JFrame {
    private JComboBox veiculoBox;
    private JLabel veiculo;
    private JLabel venderVeiculo;
    private JTextField precoText;
    private JLabel preco;
    private JButton venderVeiculoButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;

    public VenderVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialTransacoes().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new VenderVeiculo().setVisible(true);
    }
}
