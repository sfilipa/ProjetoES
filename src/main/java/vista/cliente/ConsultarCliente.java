package vista.cliente;

import modelo.Cliente;
import modelo.DadosAplicacao;
import modelo.Veiculo;
import vista.Erros;
import vista.veiculo.ConsultarVeiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultarCliente extends JDialog {
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JButton voltarButton;
    private JTextField textField1;
    private JList list1;
    private JButton filtrarButton;
    private JButton verClienteButton;
    private JLabel lblVeiculo;
    private JLabel lblNIF;

    public ConsultarCliente(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarListaCliente();

        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        verClienteButton.addActionListener(this::btnVerClienteActionPerformed);
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

    public static Veiculo mostrarConsultarCliente(Frame parent) {
        System.out.println("mostrarConsultarCliente");
        ConsultarCliente dialog = new ConsultarCliente(parent, true);
        dialog.setVisible(true);
        return null;
    }


    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void btnVerClienteActionPerformed(ActionEvent evt) {
        Cliente clienteSelecionado = (Cliente) list1.getSelectedValue();
        if (clienteSelecionado == null) {
            Erros.mostrarErro(this, Erros.CLIENTE_NAO_SELECIONADO);
            return;
        } else {
            lblNIF.setText(String.valueOf(clienteSelecionado.getNif()));
            lblNome.setText(clienteSelecionado.getNome());
            //lblVeiculo.setText(clienteSelecionado.ge());

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
      //  new ConsultarCliente().setVisible(true);
    //}



}
