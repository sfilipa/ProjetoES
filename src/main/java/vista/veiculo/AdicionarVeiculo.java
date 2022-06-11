package vista.veiculo;

import modelo.DadosAplicacao;
import modelo.Veiculo;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JDialog {
    private JPanel painelPrincipal;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JTextField txtmatricula;
    private JTextField txtmarca;
    private JTextField txtmodelo;
    private JTextField txtdonoAnterior;
    private JTextField txtnDonos;
    private JTextField txtcategoria;
    private JTextField txtquilometros;
    private JTextField txtclasse;
    private JTextField txtnPortas;
    private JTextField txtpotencia;
    private JTextField txtcilindrada;
    private JRadioButton gasolinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton elétricoRadioButton;
    private JRadioButton automáticaRadioButton;
    private JRadioButton manualRadioButton;
    private JRadioButton fronteiraRadioButton;
    private JRadioButton traseiraRadioButton;
    private JRadioButton muitoBomRadioButton;
    private JRadioButton bomRadioButton;
    private JRadioButton médioRadioButton;
    private JRadioButton mauRadioButton;
    private JRadioButton mutioMauRadioButton;

    private Veiculo veiculo;


    public AdicionarVeiculo(Frame parent, boolean modal){
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();
        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

    }

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        System.out.println("Adicionar Veículo");

        if(!verificarPreenchido()){
            return;
        }

        boolean valido = MatriculaExiste(txtmatricula.getText());
        if(!valido){
            Erros.mostrarErro(this, Erros.MATRICULA_JA_EXISTE);
            return;
        }
        valido = foiPreenchido(txtmarca.getText());

    }

    public boolean verificarPreenchido(){
        if(foiPreenchido(txtmatricula.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtmarca.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtmodelo.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtdonoAnterior.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtnDonos.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtcategoria.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtquilometros.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtclasse.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtnPortas.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtpotencia.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtcilindrada.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    public static Veiculo mostrarCriacaoVeiculo(Frame parent){
        //todo
        System.out.println("mostrarCriacaoVeiculo");
        var detalhes = new AdicionarVeiculo(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getVeiculo();
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaInicialVeiculos().setVisible(true);
            }
        });
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    private boolean MatriculaExiste(String matricula) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeVeiculoComMatricula(matricula);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}
//ver