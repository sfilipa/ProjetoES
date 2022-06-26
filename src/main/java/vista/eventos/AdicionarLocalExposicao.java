package vista.eventos;

import modelo.DadosAplicacao;
import modelo.LocalExposicao;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarLocalExposicao extends JDialog {


    private JTextField nomeExposiçãoTextField;
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    private LocalExposicao localExposicao;

    public AdicionarLocalExposicao(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        btnCancelarActionPerformed();

    }

    public static LocalExposicao mostrarCriacaoLocal(Frame parent) {
        //todo
        System.out.println("mostrarCriacaoEvento");
        var detalhes = new AdicionarLocalExposicao(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getLocalExposicao();
    }

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        System.out.println("Adicionar Local");
        if (!verificarPreenchido()) {
            return;
        }
        boolean valido = NomeExiste(nomeExposiçãoTextField.getText());
        if (valido) {
            Erros.mostrarErro(this, Erros.NOME_JA_EXISTE);
            return;
        }


        localExposicao = new LocalExposicao(nomeExposiçãoTextField.getText(),comboBox1.getSelectedItem().toString(), comboBox2.getSelectedItem().toString());


        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }

    public boolean verificarPreenchido() {
        if (foiPreenchido(nomeExposiçãoTextField.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }

        return true;
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    private boolean NomeExiste(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeLocalNome(nome);
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

    public LocalExposicao getLocalExposicao() {
        return localExposicao;
    }


   // public static void main(String[] args) {
     //   new AdicionarLocalExposicao().setVisible(true);
    //}
}
