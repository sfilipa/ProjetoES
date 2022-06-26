package vista.transacoes;

import modelo.DadosAplicacao;
import modelo.Peca;
import modelo.Transacao;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoverTransacao extends JFrame{
    private JPanel painelPrincipal;
    private JLabel removerTransacao;
    private JButton removerTransacaoButton;
    private JButton cancelarButton;
    private JLabel transacaoRemover;
    private JLabel palavrasFiltragem;
    private JLabel tipoPecaFiltragem;
    private JButton filtrarButton;
    private JRadioButton dinheiroRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField palavrasFiltragemText;
    private JLabel filtrarPeca;
    private JList list1;
    private JComboBox comboBox1;

    private String radioAnswer;

    public RemoverTransacao(Frame parent, boolean modal){
        setContentPane(painelPrincipal);
        pack();

        dinheiroRadioButton.addActionListener(this::tipoPagamento);
        outroRadioButton.addActionListener(this::tipoPagamento);
        removerTransacaoButton.addActionListener(this::btnRemoverTransacaoActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);


        dinheiroRadioButton.setSelected(false);
        outroRadioButton.setSelected(false);

    }

    private void btnCancelarActionPerformed(ActionEvent event) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void btnFiltrarActionPerformed(ActionEvent event) {
        System.out.println("Filtrar");

        String palavras = palavrasFiltragemText.getText();
        String tipoPeca = radioAnswer;
        if (radioAnswer == null) {
            Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
        }
        String tipoTransacao = comboBox1.getSelectedItem().toString();

        System.out.println("Palavra: " + palavras);
        System.out.println("Tipo de pagamento: " + tipoPeca);
        System.out.println("Tipo de transação" + tipoTransacao);
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Transacao> transacoes = dadosAplicacao.getTransacao();

        transacoes = dadosAplicacao.getTransacao();

        DefaultListModel<Transacao> model = new DefaultListModel<>();
        for (Transacao transacao : transacoes) {
            model.addElement(transacao);
        }
        list1.setModel(model);
    }

    private void tipoPagamento(ActionEvent event) {
        if (dinheiroRadioButton.isSelected()) {
            radioAnswer = "Dinheiro";
        } else {
            if (outroRadioButton.isSelected()) {
                radioAnswer = "Outro";
            } else {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            }
        }

    }

    private void btnRemoverTransacaoActionPerformed(ActionEvent event){
        System.out.println("Remover Transação");
        Transacao transacao = (Transacao) list1.getSelectedValue();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        dadosAplicacao.removerTransacao(transacao);
    }

    public static Transacao mostrarRemoverTransacao (Frame parent) {
        RemoverTransacao dialog = new RemoverTransacao(parent, true);
        dialog.setVisible(true);
        return null;


    }
}
