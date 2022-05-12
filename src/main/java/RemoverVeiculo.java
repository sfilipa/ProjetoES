import javax.swing.*;

public class RemoverVeiculo extends JFrame {
    DefaultListModel listmodel = new DefaultListModel();
    private JList listVeiculos;
    private JButton removerButton;
    private JPanel painelPrincipal;

    public RemoverVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        veiculos();

    }

    public void veiculos(){
        String veiculos[] = {"Audi A4", "Peugeot 206"};
        for ( int i = 0; i < veiculos.length; i++ ){
            listmodel.addElement( veiculos[i].toString());
        }

        listVeiculos.setModel(listmodel);

    }

    public static void main(String[] args) {
        new RemoverVeiculo().setVisible(true);
    }
}
