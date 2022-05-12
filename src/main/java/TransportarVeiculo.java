import javax.swing.*;

public class TransportarVeiculo extends JFrame{
    DefaultListModel listmodelVeiculos = new DefaultListModel();
    DefaultListModel listmodelLugares = new DefaultListModel();
    private JPanel painelPrincipal;
    private JList listVeiculos;
    private JList listLugares;
    private JButton transportarButton;

    public TransportarVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        veiculos();
        lugares();
    }

    public void veiculos(){
        String veiculos[] = {"Audi A4", "Peugeot 206"};
        for ( int i = 0; i < veiculos.length; i++ ){
            listmodelVeiculos.addElement( veiculos[i].toString());
        }

        listVeiculos.setModel(listmodelVeiculos);

    }
    public void lugares(){
        String lugares[] = {"Sede", "Filial Leiria", "Filial Viseu", "Feira de Leiria"};
        for ( int i = 0; i < lugares.length; i++ ){
            listmodelLugares.addElement( lugares[i].toString());
        }

        listLugares.setModel(listmodelLugares);

    }

    public static void main(String[] args) {
        new TransportarVeiculo().setVisible(true);
    }
}
