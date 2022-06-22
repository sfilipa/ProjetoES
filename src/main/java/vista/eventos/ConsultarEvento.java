package vista.eventos;

import modelo.*;
import vista.Erros;

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
    private JList<Evento> listaEventos;
    private JComboBox comboDistrito;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JButton verEventoButton;
    private JLabel lblDataInicio;
    private JLabel lblDataFim;
    private JLabel lblDistrito;

    public ConsultarEvento(Frame parent, boolean modal){
        setContentPane(painelPrincipal);
        pack();

        atualizarCombBoxDistrito();
        atualizarListaEvento();

        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        verEventoButton.addActionListener(this::btnVerEventoActionPerformed);
    }

    public static Evento mostrarConsultarEvento(Frame parent){
        System.out.println("mostrarConsultarEvento");
        ConsultarEvento dialog = new ConsultarEvento(parent, true);
        dialog.setVisible(true);
        return null;
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void btnVerEventoActionPerformed(ActionEvent evt) {
        Evento eventoSelecionado = listaEventos.getSelectedValue();
        if(eventoSelecionado == null) {
           Erros.mostrarErro(this, Erros.EVENTO_NAO_SELECIONADO);
           return;
        }else {
            lblNome.setText(eventoSelecionado.getNome());
            lblNVeiculos.setText(String.valueOf(eventoSelecionado.getnVeiculos()));
            lblLocal.setText(eventoSelecionado.getLocal().toString());
            lblDataInicio.setText(eventoSelecionado.getDataInicio().toString());
            lblDataFim.setText(eventoSelecionado.getDataFim().toString());
            lblDistrito.setText(eventoSelecionado.getDistrito().toString());
            lblTempo.setText(String.valueOf(eventoSelecionado.subtrair()) + " dias");
        }

    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");
        Data dataInicio = Data.parseData(txtDataInicio.getText());

        if (dataInicio != null) {
            boolean valido = isDataValida(txtDataInicio.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.DATA_INVALIDA);
            }
        }

        Data dataFim = Data.parseData(txtDataFim.getText());

        if (dataFim != null) {
            boolean valido = isDataValida(txtDataFim.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.DATA_INVALIDA);
            }
        }

        if (dataInicio != null && dataFim != null) {
            if (dataFim.getCalendar().before(dataInicio.getCalendar())) {
                Erros.mostrarErro(this, Erros.DATA_MAIOR);
            }
        }
        Distrito distrito = (Distrito) comboDistrito.getSelectedItem();
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
        DefaultListModel<Evento> model = new DefaultListModel<>();
        for (Evento evento : eventos) {
            model.addElement(evento);
        }
        listaEventos.setModel(model);
        System.out.println("eventos: " + eventos);
        System.out.println("model: " + model);
    }

    private void atualizarCombBoxDistrito(){
        for(int i = 0; i< Distrito.values().length; i++){
            comboDistrito.addItem(Distrito.values()[i]);
        }
    }


}
