package vista.eventos;

import modelo.*;
import vista.Erros;
import vista.veiculo.AdicionarVeiculo;
import vista.veiculo.PaginaInicialVeiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarEvento extends JDialog{
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


    public AdicionarEvento(Frame parent, boolean modal){
        super(parent, modal);

        setContentPane(painelPrincipal);
        pack();

        atualizarCombBoxDistrito();
        atualizarCombBoxLocaisEFiliais();

        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

    }

    private void btnAdicionarActionPerformed(ActionEvent evt) {
        System.out.println("Adicionar Evento");
        if(!verificarPreenchido()){
            return;
        }
        boolean valido = NomeExiste(txtNome.getText());
        if(valido){
            Erros.mostrarErro(this, Erros.NOME_JA_EXISTE);
            return;
        }
        valido = NomeCaracteresEspeciais(txtNome.getText());
        if(valido){
            Erros.mostrarErro(this, Erros.CONTEM_CARACTERES_ESPECIAIS);
            return;
        }
        valido = isNumero(txtNVeiculos.getText());
        if(!valido){
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }

        int nVeiculos = Integer.parseInt(txtNVeiculos.getText());
        if (nVeiculos < 0){
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }

        Data dataInicio = Data.parseData(txtDataInicio.getText());

        valido = isDataValida(txtDataInicio.getText());
        if(!valido){
            Erros.mostrarErro(this, Erros.DATA_INVALIDA);
        }

        Data dataFim = Data.parseData(txtDataFim.getText());

        valido = isDataValida(txtDataFim.getText());
        if(!valido){
            Erros.mostrarErro(this, Erros.DATA_INVALIDA);
        }

        if(dataFim.getCalendar().before(dataInicio.getCalendar())){
            Erros.mostrarErro(this, Erros.DATA_MAIOR);
        }

        evento = new Evento(txtNome.getText(), nVeiculos, dataInicio, dataFim, (Distrito) comboDistrito.getSelectedItem(), (Filial) comboLocal.getSelectedItem());
        fechar();
    }

    public static Evento mostrarCriacaoEvento(Frame parent){
        //todo
        System.out.println("mostrarCriacaoEvento");
        var detalhes = new AdicionarEvento(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getEvento();
    }

    public boolean verificarPreenchido(){
        if(foiPreenchido(txtNome.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtNVeiculos.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtDataInicio.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if(foiPreenchido(txtDataFim.getText())){
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
            fechar();
    }

    private void fechar(){
        this.setVisible(false);
    }

    private boolean NomeExiste(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.existeEventoNome(nome);
    }
    private boolean NomeCaracteresEspeciais(String nome) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.temCaracteresEspeciais(nome);
    }
    private boolean isNumero(String nVeiculos) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nVeiculos);
    }

    private boolean isDataValida(String data){
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isDataValida(data);
    }

    private boolean foiPreenchido(String text) {
        return text.isEmpty();
    }

    public Evento getEvento() {
        return evento;
    }

    private void atualizarCombBoxLocaisEFiliais(){
        for(int i = 0; i< Filial.values().length; i++){
            comboLocal.addItem(Filial.values()[i]);
        }
    }


    private void atualizarCombBoxDistrito(){
        for(int i = 0; i< Distrito.values().length; i++){
            comboDistrito.addItem(Distrito.values()[i]);
        }
    }
}