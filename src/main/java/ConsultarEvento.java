import javax.swing.*;

public class ConsultarEvento extends JFrame {
    DefaultListModel listmodel = new DefaultListModel();
    private JList listEventos;
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JLabel lblDistrito;

    public ConsultarEvento(){
        setContentPane(painelPrincipal);
        pack();

        eventos();
        detalhesEvento();

    }

    public void eventos(){
        String eventos[] = {"Filial Leiria", "Feira de Leiria", "Filial Viseu"};
        for ( int i = 0; i < eventos.length; i++ ){
            listmodel.addElement( eventos[i].toString());
        }

        listEventos.setModel(listmodel);

    }

    public void detalhesEvento(){

        lblNome.setText("Evento Maio");
        lblLocal.setText("Feira de Leiria");
        lblNVeiculos.setText("100");
        lblTempo.setText("2 meses");
    }

    public static void main(String[] args) {
        new ConsultarEvento().setVisible(true);
    }
}
