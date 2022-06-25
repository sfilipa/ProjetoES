package vista.eventos;

import modelo.*;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class EditarEvento extends JDialog {
    private JButton filtrarButton;
    private JList<Evento> listaEventos;
    private JButton editarButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JComboBox comboDistritoFiltro;
    private JTextField txtNome;
    private JComboBox comboLocal;
    private JButton novoLocalDeExposiçãoButton;
    private JTextField txtNVeiculos;
    private JTextField txtDataFimFiltro;
    private JTextField txtDataInicioFiltro;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JComboBox comboDistrito;

    private Evento evento;

    public EditarEvento(Frame parent, boolean modal) {
        super(parent, modal);
        setContentPane(painelPrincipal);
        pack();

        atualizarListaEvento();
        atualizarCombBoxDistrito();
        atualizarCombBoxLocaisEFiliais();

        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        filtrarButton.addActionListener(this::btnFiltrarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        comboDistrito.addActionListener(this::comboDistritoActionPerformed);
        novoLocalDeExposiçãoButton.addActionListener(this::btnNovoLocalDeExposiçãoActionPerformed);

    }

    private void btnNovoLocalDeExposiçãoActionPerformed(ActionEvent actionEvent) {
        fechar();
        new AdicionarLocalExposicao().setVisible(true);
    }
    private void comboDistritoActionPerformed(ActionEvent actionEvent) {
        atualizarCombBoxLocaisEFiliais();
    }

    public void btnEditarActionPerformed(ActionEvent evt) {
        System.out.println("EditarEvento.btnEditarActionPerformed");
        Evento eventoSelecionado = listaEventos.getSelectedValue();
        if (eventoSelecionado == null) {
            Erros.mostrarErro(this, Erros.EVENTO_NAO_SELECIONADO);
            return;
        } else {
            DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

            System.out.println("Editar Evento");
            if (!verificarPreenchido()) {
                return;
            }
            boolean valido = NomeExiste(txtNome.getText());
            if (valido) {
                Erros.mostrarErro(this, Erros.NOME_JA_EXISTE);
                return;
            }
            valido = isNumero(txtNVeiculos.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }

            int nVeiculos = Integer.parseInt(txtNVeiculos.getText());
            if (nVeiculos < 0) {
                Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
                return;
            }

            Data dataInicio = Data.parseData(txtDataInicio.getText());

            valido = isDataValida(txtDataInicio.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.DATA_INVALIDA);
                return;
            }

            Data dataFim = Data.parseData(txtDataFim.getText());

            valido = isDataValida(txtDataFim.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.DATA_INVALIDA);
                return;
            }

            if (dataFim.getCalendar().before(dataInicio.getCalendar())) {
                Erros.mostrarErro(this, Erros.DATA_MAIOR);
                return;
            }

            dadosAplicacao.editarEvento(eventoSelecionado, txtNome.getText(), dataInicio, dataFim, nVeiculos, comboDistrito.getSelectedItem().toString(), comboLocal.getSelectedItem().toString());

            atualizarListaEvento();
        }

    }

    public boolean verificarPreenchido() {
        if (foiPreenchido(txtNome.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtNVeiculos.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtDataInicio.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (foiPreenchido(txtDataFim.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");
        Data dataInicio = Data.parseData(txtDataInicioFiltro.getText());

        if (dataInicio != null) {
            boolean valido = isDataValida(txtDataInicioFiltro.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.DATA_INVALIDA);
            }
        }

        Data dataFim = Data.parseData(txtDataFimFiltro.getText());

        if (dataFim != null) {
            boolean valido = isDataValida(txtDataFimFiltro.getText());
            if (!valido) {
                Erros.mostrarErro(this, Erros.DATA_INVALIDA);
            }
        }

        if (dataInicio != null && dataFim != null) {
            if (dataFim.getCalendar().before(dataInicio.getCalendar())) {
                Erros.mostrarErro(this, Erros.DATA_MAIOR);
            }
        }
        String distrito = comboDistritoFiltro.getSelectedItem().toString();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Evento> eventos = new ArrayList<>();
        eventos = dadosAplicacao.getEventos(dataInicio, dataFim, distrito);

        DefaultListModel<Evento> model = new DefaultListModel<>();
        for (Evento evento : eventos) {
            model.addElement(evento);
        }
        listaEventos.setModel(model);
    }

    private boolean NomeExiste(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeEventoNome(nome);
    }

    private boolean isNumero(String nVeiculos) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nVeiculos);
    }

    private boolean isDataValida(String data) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isDataValida(data);
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    public static Evento mostrarEditarEvento(Frame parent) {
        System.out.println("mostrarRemoverEvento");
        EditarEvento dialog = new EditarEvento(parent, true);
        dialog.setVisible(true);
        return null;
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
    }

    private void atualizarListaEvento() {
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

    private void atualizarCombBoxLocaisEFiliais() {
        comboLocal.removeAllItems();
        String distrito = comboDistrito.getSelectedItem().toString();
        for (Filial filial : Filial.values()) {
            if (filial.getDistrito().equals(distrito)) {
                comboLocal.addItem(filial.displayName());
            }
        }
        for (LocalExposicao localExposicao : LocalExposicao.values()) {
            if (localExposicao.getDistrito().equals(distrito)) {
                comboLocal.addItem(localExposicao.displayName());
            }
        }
    }


    private void atualizarCombBoxDistrito() {
        List<String> distritos = new ArrayList<>();
        for (Filial filial : Filial.values()) {
            distritos.add(filial.getDistrito());
            comboDistrito.addItem(filial.distrito());
        }
        for (LocalExposicao localExposicao : LocalExposicao.values()) {
            comboDistrito.addItem(localExposicao.distrito());
        }
    }

}

