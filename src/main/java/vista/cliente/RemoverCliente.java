package vista.cliente;

import modelo.Cliente;
import modelo.DadosAplicacao;
import modelo.Veiculo;
import vista.Erros;
import vista.veiculo.RemoverVeiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverCliente extends JDialog{
    private JPanel painelPrincipal;
    private JButton removerButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JButton filtrarButton;
    private JList list1;

    public RemoverCliente(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarListaCliente();
        cancelarButton.addActionListener(this::btnVoltarActionPerformed);
        btnCancelarActionPerformed();
        removerButton.addActionListener(this::btnRemoverActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);

    }


    private void btnRemoverActionPerformed(ActionEvent evt) {
        System.out.println("RemoverCliente.btnRemoverActionPerformed");
        Cliente clienteselecionado = (Cliente) list1.getSelectedValue();
        if (clienteselecionado == null) {
            Erros.mostrarErro(this, Erros.CLIENTE_NAO_SELECIONADO);
            return;
        } else {
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
            dadosAplicacao.removerCliente(clienteselecionado);
            atualizarListaCliente();
        }
    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

        Integer nif = Integer.parseInt(textField1.getText());

        System.out.println("nif: " + nif );


        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Cliente> clientes = new ArrayList<>();

        clientes = dadosAplicacao.getClientes(nif);

        DefaultListModel<Cliente> model = new DefaultListModel<>();
        for (Cliente cliente : clientes) {
            model.addElement(cliente);
        }
        list1.setModel(model);
    }

    public static Cliente mostrarRemoverCliente(Frame parent) {
        System.out.println("mostrarRemoverCliente");
        RemoverCliente dialog = new RemoverCliente(parent, true);
        dialog.setVisible(true);
        return null;
    }

    private void atualizarListaCliente() {
        List<Cliente> clientes = new ArrayList<>();
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


    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialClientes().setVisible(true);
            }
        });
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }


   // public static void main(String[] args) {
     //   new RemoverCliente().setVisible(true);
    //}

}
