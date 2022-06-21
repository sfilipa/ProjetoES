package vista.eventos;

import modelo.DadosAplicacao;
import modelo.Distrito;
import modelo.Evento;
import modelo.Filial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultarEvento extends JDialog {
    private JLabel lblNome;
    private JPanel painelPrincipal;
    private JLabel lblNVeiculos;
    private JLabel lblLocal;
    private JLabel lblTempo;
    private JButton voltarButton;
    private JButton filtrarButton;
    private JList listaEventos;
    private JComboBox comboDistrito;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;

    public ConsultarEvento(Frame parent, boolean modal){
        setContentPane(painelPrincipal);
        pack();

        atualizarCombBoxDistrito();
        atualizarListaEvento();

        voltarButton.addActionListener(this::btnVoltarActionPerformed);
    }

    public static Evento mostrarConsultarEvento(Frame parent){
        //todo
        System.out.println("mostrarConsultarEvento");
        ConsultarEvento dialog = new ConsultarEvento(parent, true);
        dialog.setVisible(true);
        return null;
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

    }
    private void fechar(){
        this.setVisible(false);
    }
    private boolean isDataValida(String data){
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isDataValida(data);
    }

    private void atualizarListaEvento(){
        List<Evento> eventos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        eventos = dadosAplicacao.getEventos();
        System.out.println("eventos: " + eventos);
        listaEventos.setListData(eventos.toArray());
    }

    private void atualizarCombBoxDistrito(){
        for(int i = 0; i< Distrito.values().length; i++){
            comboDistrito.addItem(Distrito.values()[i]);
        }
    }


}
