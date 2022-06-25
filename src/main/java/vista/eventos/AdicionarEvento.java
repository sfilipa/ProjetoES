package vista.eventos;

import modelo.*;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AdicionarEvento extends JDialog {
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JTextField txtNome;
    private JComboBox comboLocal;
    private JButton novoLocalDeExposiçãoButton;
    private JPanel painelPrincipal;
    private JComboBox comboDistrito;
    private JTextField txtNVeiculos;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;

    private Evento evento;


    public AdicionarEvento(Frame parent, boolean modal) {
        super(parent, modal);

        setContentPane(painelPrincipal);
        pack();

        atualizarCombBoxDistrito();
        atualizarCombBoxLocaisEFiliais();

        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        comboDistrito.addActionListener(this::comboDistritoActionPerformed);
        novoLocalDeExposiçãoButton.addActionListener(this::btnNovoLocalDeExposiçãoActionPerformed);

    }

    private void btnNovoLocalDeExposiçãoActionPerformed(ActionEvent actionEvent) {
        fechar();
       // new AdicionarLocalExposicao().setVisible(true);
    }

    private void comboDistritoActionPerformed(ActionEvent actionEvent) {
        atualizarCombBoxLocaisEFiliais();
    }

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        System.out.println("Adicionar Evento");
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


        evento = new Evento(txtNome.getText(), nVeiculos, dataInicio, dataFim,  comboDistrito.getSelectedItem().toString(), comboLocal.getSelectedItem().toString());


        fechar();
    }

    public static Evento mostrarCriacaoEvento(Frame parent) {
        //todo
        System.out.println("mostrarCriacaoEvento");
        var detalhes = new AdicionarEvento(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getEvento();
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

    private void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.setVisible(false);
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

    public Evento getEvento() {
        return evento;
    }

    private void atualizarCombBoxLocaisEFiliais() {
        comboLocal.removeAllItems();
        String distrito = comboDistrito.getSelectedItem().toString();
        for (Filial filial : Filial.values()) {
            if (filial.getDistrito().equals(distrito)) {
                comboLocal.addItem(filial.displayName());
            }
        }
        List<LocalExposicao> localExposicaos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicaos = dadosAplicacao.getLocalExposicoes();
        for(LocalExposicao localExposicao : localExposicaos) {
            if (localExposicao.getDistrito().equals(distrito)) {
                comboLocal.addItem(localExposicao.displayName());
            }
        }
    }


    private void atualizarCombBoxDistrito() {
        List<String> distritos = new ArrayList<>();
        for (Filial filial : Filial.values()) {
            distritos.add(filial.getDistrito());
            comboDistrito.addItem(filial.getDistrito());
        }
        List<LocalExposicao> localExposicaos = new ArrayList<>();
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        localExposicaos = dadosAplicacao.getLocalExposicoes();
        for(LocalExposicao localExposicao : localExposicaos) {
            comboDistrito.addItem(localExposicao.getDistrito());
        }
    }

}
