package vista.estatisticas;


import modelo.DadosAplicacao;
import modelo.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EstatisticasPagina3 extends  JFrame{
    private JPanel painelPrincipal;
    private JList list1;
    private JList list2;
    private JButton voltarButton;
    private JList listaModelo;
    private JList list3;

    public EstatisticasPagina3(){
        setContentPane(painelPrincipal);
        atualizarListaModelos();
        pack();

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

    private void atualizarListaModelos() {
        List<Veiculo> veiculos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        veiculos = dadosAplicacao.getVeiculos();
        List<String> modelos = new ArrayList<>();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Veiculo veiculo : veiculos) {
            model.addElement(veiculo.getModelo());
        }
        listaModelo.setModel(model);
        list1.setModel(model);
    }

    public static void main(String[] args) {
        new EstatisticasPagina3().setVisible(true);
    }

}
