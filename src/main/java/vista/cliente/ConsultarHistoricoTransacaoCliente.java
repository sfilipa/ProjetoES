package vista.cliente;

import modelo.Cliente;
import modelo.DadosAplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultarHistoricoTransacaoCliente extends JDialog {
    private JButton voltarButton;
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JButton filtrarButton;
    private JList list1;
    private JList list2;


    public ConsultarHistoricoTransacaoCliente(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarListaCliente();

        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        //verClienteButton.addActionListener(this::btnVerClienteActionPerformed);
        btnCancelarActionPerformed();
    }


    private void btnCancelarActionPerformed() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialClientes().setVisible(true);
            }
        });
    }


    public static Cliente mostrarConsultarCliente(Frame parent) {
        System.out.println("mostrarConsultarCliente");
        ConsultarHistoricoTransacaoCliente dialog = new ConsultarHistoricoTransacaoCliente(parent, true);
        dialog.setVisible(true);
        return null;
    }


    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

        Integer nif = Integer.parseInt(textField1.getText());

        System.out.println("nif: " + nif );


        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        java.util.List<Cliente> clientes = new ArrayList<>();

        clientes = dadosAplicacao.getClientes(nif);

        DefaultListModel<Cliente> model = new DefaultListModel<>();
        for (Cliente cliente : clientes) {
            model.addElement(cliente);
        }
        list1.setModel(model);
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



    private void fechar() {
        this.setVisible(false);
    }


    //public static void main(String[] args) {
    //  new ConsultarHistoricoTransacaoCliente().setVisible(true);
    //}


}