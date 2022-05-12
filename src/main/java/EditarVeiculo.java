import javax.swing.*;

public class EditarVeiculo extends JFrame {
    DefaultListModel listmodel = new DefaultListModel();
    private JList listVeiculos;
    private JButton editarButton;
    private JPanel painelPrincipal;
    private JTextField textMatricula;
    private JTextField textMarca;
    private JTextField textModelo;
    private JTextField textDAnterior;
    private JTextField textNDonos;
    private JTextField textComb;
    private JTextField textCategoria;
    private JTextField textClasse;
    private JTextField textNPortas;
    private JTextField textPotencia;
    private JTextField textCilindrada;
    private JTextField textTCaixa;
    private JTextField textTracao;

    public EditarVeiculo(){
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
        textMatricula.setText("ZE-89-LK");
        textMarca.setText("Audi");
        textComb.setText("diesel");
        textNPortas.setText("5");
    }

    public static void main(String[] args) {
        new EditarVeiculo().setVisible(true);
    }
}
