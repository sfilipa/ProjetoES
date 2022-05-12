import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsultarVeiculo extends JFrame{
    DefaultListModel listmodel = new DefaultListModel();
    private JList listVeiculos;
    private JPanel painelPrincipal;
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

        textDetalhes.setText("Matricula: ZE-89-LK\n" +"Marca: Audi\n");
    }

    public static void main(String[] args) {
        new ConsultarVeiculo().setVisible(true);
    }
}
