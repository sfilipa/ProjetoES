package transacoes;

import javax.swing.*;

public class RemoverTransacao extends JFrame{
    private JPanel painelPrincipal;
    private JLabel removerTransacao;
    private JComboBox transacaoRemoverBox;
    private JRadioButton dinheiroRadioButton;
    private JRadioButton multibancoRadioButton;
    private JButton removerTransacaoButton;
    private JButton cancelarButton;
    private JLabel transacaoRemover;
    private JLabel infoTransacao;
    private JLabel valor;
    private JLabel matricula;
    private JLabel dataTransacao;
    private JLabel horaTransacao;
    private JLabel tipoTransacao;
    private JLabel valorText;
    private JLabel matriculaText;
    private JLabel dataTransacaoText;
    private JLabel horaTransacaoText;

    public RemoverTransacao(){
        setContentPane(painelPrincipal);
        pack();
    }

    public static void main(String[] args) {
        new RemoverTransacao().setVisible(true);
    }
}
