package vista.eventos;

import modelo.DadosAplicacao;
import modelo.Evento;
import modelo.LocalExposicao;
import vista.paginaPrincipal.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialEventos extends JFrame {
    private JButton adicionarEventoButton;
    private JButton removerEventoButton;
    private JButton consultarButton;
    private JButton voltarButton;
    private JPanel painelPrincipal;
    private JButton editarEventoButton;
    private JButton adicionarLocalDeExposiçãoButton;
    private JButton removerLocalDeExposiçãoButton;
    private JButton consultarLocalDeExposiçãoButton;

    public PaginaInicialEventos() {
        setContentPane(painelPrincipal);
        pack();
        setVisible(true);

        adicionarEventoButton.addActionListener(this::btnAdicionarEventoActionPerformed);
        adicionarLocalDeExposiçãoButton.addActionListener(this::btnAdicionarLocalExposicaoActionPerfomed);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
        removerEventoButton.addActionListener(this::btnRemoverEventoActionPerformed);
        editarEventoButton.addActionListener(this::btnEditarEventoActionPerformed);
        consultarButton.addActionListener(this::btnConsultarEventoActionPerformed);
        consultarLocalDeExposiçãoButton.addActionListener(this::btnConsultarLocalExposicaoActionPerfomed);


    }

    private void btnAdicionarEventoActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnAdicionarEvento");
        Evento evento = AdicionarEvento.mostrarCriacaoEvento(this);
        if (evento != null) {
            DadosAplicacao dados = DadosAplicacao.INSTANCE;
            dados.adicionarEvento(evento);
        }
    }

    private void btnRemoverEventoActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnRemoverEvento");
        RemoverEvento.mostrarRemoverEvento(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();
    }

    private void btnEditarEventoActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnEditarEvento");
        EditarEvento.mostrarEditarEvento(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();
    }

    private void btnConsultarEventoActionPerformed(ActionEvent evt) {
        System.out.println("Click no btnConsultarEvento");
        ConsultarEvento.mostrarConsultarEvento(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getEventos();

    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    private void btnAdicionarLocalExposicaoActionPerfomed(ActionEvent evt) {
        System.out.println("Click no btnAdicionarEvento");
        LocalExposicao localExposicao = AdicionarLocalExposicao.mostrarCriacaoLocal(this);
        if (localExposicao != null) {
            DadosAplicacao dados = DadosAplicacao.INSTANCE;
            dados.adicionarLocalExposicao(localExposicao);
        }
        //adicionarLocalDeExposiçãoButton.addActionListener(new ActionListener() {
          //  @Override
            //public void actionPerformed(ActionEvent e) {
              //  setVisible(false);
               // new AdicionarLocalExposicao().setVisible(true);
    }
    //    });



    private void btnRemoverLocalExposicaoActionPerfomed(ActionEvent evt) {
        removerLocalDeExposiçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoverLocalExposicao().setVisible(true);
            }
        });
    }

    private void btnConsultarLocalExposicaoActionPerfomed(ActionEvent evt) {
        System.out.println("Click no btnConsultarLocal");
        ConsultarLocalExposicao.mostrarConsultarLocal(this);
        DadosAplicacao dados = DadosAplicacao.INSTANCE;
        dados.getLocalExposicoes();
/*        consultarLocalDeExposiçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultarLocalExposicao().setVisible(true);
            }
        });*/
    }


    public static void main(String[] args) {
        new PaginaInicialEventos().setVisible(true);
    }
}
