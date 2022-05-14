import javax.swing.*;

public class RepararVeiculo extends JFrame {
    DefaultListModel listmodelVeiculos = new DefaultListModel();
    DefaultListModel listmodelPecas = new DefaultListModel();
    private JList listVeiculos;
    private JList listPecas;
    private JButton repararButton;
    private JPanel painelPrincipal;
    private JTextField textField1;

    public RepararVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        veiculos();
        pecas();

    }

    public void veiculos(){
        String veiculos[] = {"Audi A4", "Peugeot 206"};
        for ( int i = 0; i < veiculos.length; i++ ){
            listmodelVeiculos.addElement( veiculos[i].toString());
        }

        listVeiculos.setModel(listmodelVeiculos);

    }
    public void pecas(){
        String pecas[] = {"pneu", "correia", "óleo"};
        for ( int i = 0; i < pecas.length; i++ ){
            listmodelPecas.addElement( pecas[i].toString());
        }

        listPecas.setModel(listmodelPecas);

    }

    public static void main(String[] args) {
        new RepararVeiculo().setVisible(true);
    }
}
