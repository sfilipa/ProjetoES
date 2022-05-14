import javax.swing.*;

public class ConsultarEventoPorDistrito extends JFrame {
    DefaultListModel listmodelEventos = new DefaultListModel();
    DefaultListModel listmodelDistritos = new DefaultListModel();
    private JList listEventos;
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JList listDistritos;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;

    public ConsultarEventoPorDistrito(){
        setContentPane(painelPrincipal);
        pack();


        distritos();
        eventos();
        detalhesEvento();

    }

    public void distritos(){
        String distritos[] = {"Leiria", "Feira de Leiria", "Viseu", "Porto", "Lisboa"};
        for ( int i = 0; i < distritos.length; i++ ){
            listmodelDistritos.addElement( distritos[i].toString());
        }

        listDistritos.setModel(listmodelDistritos);

    }

    public void eventos(){
        String eventos[] = {"Filial Leiria", "Feira de Leiria"};
        for ( int i = 0; i < eventos.length; i++ ){
            listmodelEventos.addElement( eventos[i].toString());
        }

        listEventos.setModel(listmodelEventos);

    }

    public void detalhesEvento(){

        lblNome.setText("Evento Maio");
        lblLocal.setText("Feira de Leiria");
        lblNVeiculos.setText("100");
        lblTempo.setText("2 meses");
    }

    public static void main(String[] args) {
        new ConsultarEventoPorDistrito().setVisible(true);
    }
}
