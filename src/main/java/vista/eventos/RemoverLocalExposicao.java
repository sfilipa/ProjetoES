package vista.eventos;

import modelo.DadosAplicacao;
import modelo.LocalExposicao;
import modelo.Veiculo;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverLocalExposicao extends JDialog {


    private JTextField nomeExposiçaoTextField;
    private JTextField filialAssociadaTextField;
    private JPanel painelPrincipal;
    private JButton removerButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JButton filtrarButton;
    private JList<LocalExposicao> list1;



    public RemoverLocalExposicao(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        removerButton.addActionListener(this::btnRemoverActionPerformed);
        cancelarButton.addActionListener(this::btnVoltarActionPerformed);
        atualizarListaLocal();
        atualizarComboBoxLocal();
        btnCancelarActionPerformed();

    }



    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");


        String filial = comboBox1.getSelectedItem().toString();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<LocalExposicao> localExposicoes = new ArrayList<>();

        localExposicoes = dadosAplicacao.getLocalExposicoes(filial);

        DefaultListModel<LocalExposicao> model = new DefaultListModel<>();
        for (LocalExposicao localExposicao : localExposicoes) {
            model.addElement(localExposicao);
        }
        list1.setModel(model);
    }

    private void btnRemoverActionPerformed(ActionEvent evt) {
        System.out.println("RemoverLocal.btnRemoverActionPerformed");
        LocalExposicao localExposicoes = list1.getSelectedValue();
        if (localExposicoes == null) {
            Erros.mostrarErro(this, Erros.VEICULO_NAO_SELECIONADO);
            return;
        } else {
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            dadosAplicacao.removerLocal(localExposicoes);
            atualizarListaLocal();
        }
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

    private void atualizarListaLocal() {
        List<LocalExposicao> localExposicoes = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicoes = dadosAplicacao.getLocalExposicoes();
        DefaultListModel<LocalExposicao> model = new DefaultListModel<>();
        for (LocalExposicao localExposicao : localExposicoes) {
            model.addElement(localExposicao);
        }
        list1.setModel(model);
        System.out.println("Locais: " + localExposicoes);
        System.out.println("model: " + model);
    }

    private void atualizarComboBoxLocal() {
        List<LocalExposicao> localExposicoes = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicoes = dadosAplicacao.getLocalExposicoes();
        List<String> filiais = new ArrayList<>();
        for (LocalExposicao localExposicao : localExposicoes) {
            comboBox1.addItem(localExposicao.getFilial());
        }
    }
    public static void mostrarRemoverLocal(Frame parent) {
        System.out.println("mostrarRemoverLocal");
        RemoverLocalExposicao dialog = new RemoverLocalExposicao(parent, true);
        dialog.setVisible(true);
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }
    private void fechar() {
        this.setVisible(false);
    }

    ////  new RemoverLocalExposicao().setVisible(true);
    //}
}