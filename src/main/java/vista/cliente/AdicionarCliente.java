package vista.cliente;

import modelo.Cliente;
import modelo.DadosAplicacao;
import modelo.Evento;
import modelo.Veiculo;
import vista.Erros;
import vista.eventos.AdicionarEvento;
import vista.veiculo.AdicionarVeiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarCliente extends JDialog {
    private JPanel painelPrincipal;
    private JTextField textField1;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JRadioButton simRadioButton;
    private JRadioButton nãoRadioButton;
    private JButton adicionarVeículoButton;
    private JTextField txtnif;

    private Cliente cliente;
    private String temveiculo;

    public AdicionarCliente(Frame parent, boolean modal){

        super(parent, modal);

        setContentPane(painelPrincipal);
        pack();
        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnVoltarActionPerformed);
        //adicionarVeículoButton.addActionListener(this::btnAdicionarVeiculoActionPerformed);
        //System.out.println("Cliente adicionado");
        btnCancelarActionPerformed();
        btnAdicionarVeiculoActionPerformed();


    }


    private void btnAdicionarActionPerformed(ActionEvent actionEvent) {
        System.out.println("Adicionar Cliente");
        if(!verificarPreenchido()){
            return;
        }
        boolean valido = NomeExiste(textField1.getText());
        if(valido){
            Erros.mostrarErro(this, Erros.NOME_JA_EXISTE_CLIENTE);
            return;
        }
        boolean valido1 = NumeroExiste(Integer.valueOf(txtnif.getText()));
        if(valido1){
            Erros.mostrarErro(this, Erros.NIF_JA_EXISTE);
            return;
        }


        valido = isNumero(txtnif.getText());
        if(!valido){
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }


        int nif = Integer.parseInt(txtnif.getText());



        if (nif < 0 ) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }

        cliente = new Cliente(textField1.getText(), nif);

        fechar();

    }


    private boolean NomeExiste(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeClienteNome(nome);
    }

    private boolean isNumero(String nif) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nif);
    }

    private boolean NumeroExiste(Integer nif) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeClienteNif(nif);
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    public boolean verificarPreenchido(){
        if(foiPreenchido(textField1.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtnif.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }


    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    public static Cliente mostrarCriacaoCliente(Frame parent){
        //todo
        System.out.println("mostrarCriacaoCliente");
        var detalhes = new AdicionarCliente(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getCliente();
        //return detalhes.cliente;
    }

    private Cliente getCliente() {
        return cliente;
    }

    private Cliente cliente() {
        return cliente;
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



    private void btnAdicionarVeiculoActionPerformed() {
        adicionarVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //new AdicionarVeiculo().setVisible(true);
            }
        });
    }

    private void tipoClienteVeiculo(ActionEvent event) {
        if (simRadioButton.isSelected()) {
            temveiculo = "Sim";
        } else {
            if(nãoRadioButton.isSelected()) {
                temveiculo = "Não";
            } else {
                Erros.mostrarErro(this, Erros.NAO_SELECIONADO);
            }
        }
    }

    private void fechar() {
        this.setVisible(false);
    }

    //public static void main(String[] args) {
     //   new AdicionarCliente().setVisible(true);
   // }


}
