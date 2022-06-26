package vista.eventos;

import modelo.*;
import modelo.LocalExposicao;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultarLocalExposicao extends JDialog{
    private JPanel painelPrincipal;
    private JButton button2;
    private JButton voltarButton;
    private JComboBox comboBox1;
    private JButton filtrarButton;
    private JList<LocalExposicao> list1;
    private JLabel lblNome;
    private JLabel lblFilial;
    private JButton verLocal;
    private JLabel lblDist;


    public ConsultarLocalExposicao(Frame parent, boolean modal){
        super(parent,modal);
        setContentPane(painelPrincipal);
        pack();

        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        verLocal.addActionListener(this::btnVerLocalActionPerformed);
        atualizarListaLocal();
        atualizarComboBoxLocal();
        btnCancelarActionPerformed();

    }

    private void btnVerLocalActionPerformed(ActionEvent evt) {
        LocalExposicao localExposicao = list1.getSelectedValue();
        if (localExposicao == null) {
            Erros.mostrarErro(this, Erros.LOCAL_NAO_SELECIONADO);
            return;
        } else {
            mostrarLocal(localExposicao);
        }

    }

    public static void mostrarConsultarLocal(Frame parent) {
        System.out.println("mostrarConsultarLocal");
        ConsultarLocalExposicao dialog = new ConsultarLocalExposicao(parent, true);
        dialog.setVisible(true);
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

    private void mostrarLocal(LocalExposicao localselecionado) {
        lblNome.setText(localselecionado.displayName());

        lblFilial.setText(localselecionado.getDistrito().toString());

        lblDist.setText(localselecionado.getFilial().toString());

    }

    private void btnCancelarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEventos().setVisible(true);
            }
        });
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
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


    private void fechar() {
        this.setVisible(false);
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
    //public static void main(String[] args) {
      //  new ConsultarLocalExposicao().setVisible(true);
    //}
}
