package vista.transacoes;

import modelo.*;
import vista.Erros;
import vista.pecas.RemoverPeca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static modelo.Saldo.getSaldo;

public class VenderVeiculo extends JFrame {
    private JLabel venderVeiculo;
    private JTextField precoText;
    private String preco;
    private JButton venderVeiculoButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox3;
    private JComboBox comboBox6;
    private JButton filtrarButton;
    private JList clienteList;
    private JList list1;
    private JLabel cliente;
    private JTextField nomeText;
    private JTextField nifText;
    private JButton filtrarButton1;

    public VenderVeiculo(Frame parent, boolean modal) {
        setContentPane(painelPrincipal);
        pack();
        venderVeiculoButton.addActionListener(this::btnVenderActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        filtrarButton1.addActionListener(this::btnFiltrarClientesActionPerformed);


    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

        String combustivel = comboBox1.getSelectedItem().toString();
        String condicaoGeral = comboBox4.getSelectedItem().toString();
        String marca = comboBox3.getSelectedItem().toString();
        String tipoCaixa = comboBox2.getSelectedItem().toString();
        String quilometros = comboBox5.getSelectedItem().toString();
        String preco = comboBox6.getSelectedItem().toString();

        System.out.println("combustivel: " + combustivel);
        System.out.println("condicaoGeral: " + condicaoGeral);
        System.out.println("marca: " + marca);
        System.out.println("tipoCaixa: " + tipoCaixa);
        System.out.println("quilometros: " + quilometros);
        System.out.println("preco: " + preco);

        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Transacao> transacoes = new ArrayList<>();

        transacoes = DadosAplicacao.getTransacao(combustivel, condicaoGeral, marca, tipoCaixa, quilometros, preco);

        DefaultListModel<Transacao> model = new DefaultListModel<>();
        for (Transacao transacao : transacoes) {
            model.addElement(transacao);
        }
        list1.setModel(model);
    }

    private void btnFiltrarClientesActionPerformed(ActionEvent actionEvent){
        System.out.println("Filtrar");

        String nome = nomeText.getText();
        String nif = nifText.getText();

        System.out.println("nome: " + nome);
        System.out.println("nif: " + nif);

        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Cliente> clientes = new ArrayList<>();

        DefaultListModel<Cliente> model = new DefaultListModel<>();
        for (Cliente cliente : clientes) {
            model.addElement(cliente);
        }
        clienteList.setModel(model);
    }

    private void btnVenderActionPerformed(ActionEvent evt) {
        System.out.println("Vender Veículo");

        preco = precoText.getText();
        Veiculo veiculoSelecionado = (Veiculo) list1.getSelectedValue();
        if(veiculoSelecionado == null){
            Erros.mostrarErro(this, Erros.VEICULO_NAO_SELECIONADO);
            return;
        } else {
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            dadosAplicacao.removerVeiculo(veiculoSelecionado);

            double saldo = getSaldo() + Double.parseDouble(preco);
        }
        fechar();
    }

    public static Veiculo mostrarVenderVeiculo(Frame parent) {
        VenderVeiculo dialog = new VenderVeiculo(parent, true);
        dialog.setVisible(true);
        return null;
    }


    private void fechar() {
        this.setVisible(false);
    }

}
