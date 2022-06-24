package vista.pecas;

import modelo.Cliente;
import modelo.DadosAplicacao;
import modelo.Peca;
import vista.Erros;
import vista.cliente.AdicionarCliente;
import vista.cliente.PaginaInicialClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarPeca extends JFrame {
    private JPanel painelPrincipal;
    private JLabel adicionarPeca;
    private JTextField nomePecaTextField;
    private JRadioButton consumivelRadioButton;
    private JRadioButton outroRadioButton;
    private JTextField quantidadeMinimaSedeText;
    private JTextField quantidadeMinimaFilealText;
    private JButton adicionarPecaButton;
    private JButton cancelarButton;
    private JLabel nomePeca;
    private JLabel tipoPeca;
    private JLabel quantidadeMinimaSede;
    private JLabel quantidadeMinimaFileal;

    private Peca peca;

    public AdicionarPeca(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();
        adicionarPecaButton.addActionListener(this::btnAdicionarPecaActionPerformed);
        btnCancelarActionPerformed();

    }


    public static Peca mostrarCriacaoPeca(Frame parent) {
        // so copiei da sara
        System.out.println("mostrarCriacaoPeca");
        var detalhes = new AdicionarPeca(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        //return detalhes.getCliente();
        return detalhes.peca;
    }

    /*
    public static void main(String[] args) {
        new AdicionarPeca().setVisible(true);
    }
    */

    private void btnAdicionarPecaActionPerformed(ActionEvent actionEvent) {
        System.out.println("Adicionar Peça");
        if (!verificarPreenchido()) {
            return;
        }
        boolean valido = PecaExiste(nomePecaTextField.getText());
        if (valido) {
            Erros.mostrarErro(this, Erros.NOME_JA_EXISTE_PECA);
            return;
        }
        boolean valido1 = QuantidadeInvalida(quantidadeMinimaFilealText.getText());
        if (valido1) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
        }

        boolean valido2 = QuantidadeInvalida(quantidadeMinimaSedeText.getText());
        if (valido2) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
        }
        peca = new Peca(nomePecaTextField.getText(), quantidadeMinimaFilealText.getText(), quantidadeMinimaSedeText.getText());

        fechar();

    }

    private boolean PecaExiste(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existePecaNome(nome);
    }

    private boolean QuantidadeInvalida(String quantidade) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(quantidade);
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    public boolean verificarPreenchido() {
        if (foiPreenchido(nomePecaTextField.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(quantidadeMinimaFilealText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(quantidadeMinimaSedeText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }

        // TODO:
        // Verificar o radio button.

        return true;
    }

    private Peca getPeca() {
        return peca;
    }

    private Peca peca() {
        return peca;
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialPecas().setVisible(true);
            }
        });
    }

    private void fechar() {
        this.setVisible(false);
    }
}


