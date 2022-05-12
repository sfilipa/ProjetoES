import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsultarVeiculo extends JFrame{
    DefaultListModel listmodel = new DefaultListModel();
    private JList listVeiculos;
    private JPanel painelPrincipal;
    private JLabel lblMatricula;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblNDonos;
    private JLabel lblComb;
    private JLabel lblCategoria;
    private JLabel lblClasse;
    private JLabel lblPortas;
    private JLabel lblCilindrada;
    private JLabel lblPotencia;
    private JLabel lblTCaixa;
    private JLabel lblTracao;
    private JLabel lblDonoAnterior;
    private JTextArea textDetalhes;

    public ConsultarVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        veiculos();
        detalhesVeiculo();

    }

    public void veiculos(){
        String veiculos[] = {"Audi A4", "Peugeot 206"};
        for ( int i = 0; i < veiculos.length; i++ ){
            listmodel.addElement( veiculos[i].toString());
        }

        listVeiculos.setModel(listmodel);

    }

    public void detalhesVeiculo(){

        lblMatricula.setText("ZE-89-LK");
        lblMarca.setText("Audi");
        lblComb.setText("diesel");
        lblPortas.setText("5");
    }

    public static void main(String[] args) {
        new ConsultarVeiculo().setVisible(true);
    }
}
