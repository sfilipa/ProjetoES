package vista.estatisticas;

import modelo.Cliente;
import modelo.DadosAplicacao;
import modelo.Filial;
import modelo.LocalExposicao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EstatisticasPagina1 extends  JDialog{
    private JPanel painelPrincipal;
    private JButton voltarButton;
    private JList list1;
    private JList list2;
    private JList list3;

    public EstatisticasPagina1(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarListaLocal();
        atualizarListaCliente();
        atualizarListaFilial();
        btnVoltarActionPerformed();
    }

    private void btnVoltarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialEstatisticas().setVisible(true);
            }
        });
    }

    public static Cliente mostrarConsultarCliente(Frame parent) {
        System.out.println("mostrarConsultarCliente");
        EstatisticasPagina1 dialog = new EstatisticasPagina1(parent, true);
        dialog.setVisible(true);
        return null;
    }


    private void atualizarListaCliente() {
        java.util.List<Cliente> clientes = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        clientes = dadosAplicacao.getClientes();
        DefaultListModel<Cliente> model = new DefaultListModel<>();
        for (Cliente cliente : clientes) {
            model.addElement(cliente);
        }
        list1.setModel(model);
        System.out.println("clientes: " + clientes);
        System.out.println("model: " + model);
    }




    private void atualizarListaLocal() {
        List<LocalExposicao> localExposicoes = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicoes = dadosAplicacao.getLocalExposicoes();
        DefaultListModel<LocalExposicao> model = new DefaultListModel<>();
        for (LocalExposicao localExposicao : localExposicoes) {
            model.addElement(localExposicao);
        }
        list3.setModel(model);
        System.out.println("Locais: " + localExposicoes);
        System.out.println("model: " + model);
    }

    private void atualizarListaFilial() {
        List<LocalExposicao> localExposicoes = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicoes = dadosAplicacao.getLocalExposicoes();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (LocalExposicao localExposicao : localExposicoes) {
            model.addElement(localExposicao.getLocalFilial());
        }
        list2.setModel(model);
        System.out.println("Locais: " + localExposicoes);
        System.out.println("model: " + model);
    }

/*    private void atualizarListaFilial1() {
        List<Filial> filiais = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        filiais = dadosAplicacao.getFilial();
        DefaultListModel<Filial> model = new DefaultListModel<>();
        for (Filial filial : filiais) {
            model.addElement(filial);
        }
        list2.setModel(model);
        System.out.println("Locais: " + filiais);
        System.out.println("model: " + model);
    }*/




    ////   new EstatisticasPagina1().setVisible(true);
    //}

}
