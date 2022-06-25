package vista.estatisticas;

import modelo.DadosAplicacao;
import modelo.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EstatisticasPagina2 extends JFrame {
    private JPanel painelPrincipal;
    private JButton voltarButton;
    private JList listaMarcas;
    private JList list2;
    private JList list1;
    private JList list3;

    public EstatisticasPagina2() {
        setContentPane(painelPrincipal);
        pack();
        atualizarListaMarcas();
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

    private void atualizarListaMarcas() {
        List<Veiculo> veiculos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        veiculos = dadosAplicacao.getVeiculos();
        List<String> marcas = new ArrayList<>();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Veiculo veiculo : veiculos) {
            model.addElement(veiculo.getMarca());
        }
        listaMarcas.setModel(model);
        list1.setModel(model);
    }

    public static void main(String[] args) {
        new EstatisticasPagina2().setVisible(true);
    }

}
