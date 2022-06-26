package vista.transacoes;

import modelo.DadosAplicacao;
import modelo.Veiculo;
import modelo.Transacao;
import vista.Erros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VenderVeiculo extends JFrame {
    private JLabel veiculo;
    private JLabel venderVeiculo;
    private JTextField precoText;
    private JLabel preco;
    private JButton venderVeiculoButton;
    private JButton cancelarButton;
    private JPanel painelPrincipal;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox3;
    private JComboBox comboBox6;
    private JButton filtrarButton;
    private JList clienteList;
    private JList list1;
    private JLabel cliente;
    private JLabel nome;
    private JLabel nif;
    private JTextField nomeText;
    private JTextField nifText;
    private JButton filtrarButton1;

    public VenderVeiculo(){
        setContentPane(painelPrincipal);
        pack();

        btnCancelarActionPerformed();
    }

    private void btnCancelarActionPerformed() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }





    private void btnFiltrarActionPerformed(ActionEvent evt) {
        System.out.println("Filtrar");

        String combustivel = comboBox1.getSelectedItem().toString();
        String condicaoGeral = comboBox4.getSelectedItem().toString();
        String marca = comboBox3.getSelectedItem().toString();
        String tipoCaixa = comboBox2.getSelectedItem().toString();
        String quilometros = comboBox5.getSelectedItem().toString();
        String preco = comboBox6.getSelectedItem().toString();

        System.out.println("combustivel: " + combustivel);
        System.out.println("condicaoGeral: " + condicaoGeral);
        System.out.println("marca: " + marca);
        System.out.println("tipoCaixa: " + tipoCaixa);
        System.out.println("quilometros: " + quilometros);
        System.out.println("preco: " + preco);

        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;

        List<Transacao> transacoes = new ArrayList<>();

        transacoes = DadosAplicacao.getTransacao(combustivel, condicaoGeral, marca, tipoCaixa, quilometros, preco);

        DefaultListModel<Transacao> model = new DefaultListModel<>();
        for (Transacao transacao : transacoes) {
            model.addElement(transacao);
        }
        list1.setModel(model);
    }

    /*
    private void tracaoButtonActionPerformed(ActionEvent actionEvent) {
        if (fronteiraRadioButton.isSelected()) {
            tracao = fronteiraRadioButton.getText();
        } else {
            tracao = traseiraRadioButton.getText();
        }
    }

    private void combustivelButtonActionPerformed(ActionEvent actionEvent) {
        if (gasolinaRadioButton.isSelected()) {
            combustivel = gasolinaRadioButton.getText();
        } else if (dieselRadioButton.isSelected()) {
            combustivel = dieselRadioButton.getText();
        } else if (eletricoRadioButton.isSelected()) {
            combustivel = eletricoRadioButton.getText();
        }
    }

    private void tipoCaixaButtonActionPerformed(ActionEvent actionEvent) {
        if (automaticaRadioButton.isSelected()) {
            tipoCaixa = automaticaRadioButton.getText();
        } else {
            tipoCaixa = manualRadioButton.getText();
        }
    }

    private void btnComprarActionPerformed(ActionEvent evt) {
        System.out.println("Comprar Veículo");

        if (!verificarPreenchido()) {
            return;
        }

        boolean valido = MatriculaExiste(matriculaText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.MATRICULA_JA_EXISTE);
            return;
        }

        valido = isNumero(nDonosText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(nPortasText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(potenciaText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(cilindradaText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(classesText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(precoText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }
        valido = isNumero(nifText.getText());
        if (!valido) {
            Erros.mostrarErro(this, Erros.NAO_E_NUMERO);
            return;
        }

        int nPortas = Integer.parseInt(nPortasText.getText());
        int nDonos = Integer.parseInt(nDonosText.getText());
        int potencia = Integer.parseInt(potenciaText.getText());
        int cilindrada = Integer.parseInt(cilindradaText.getText());
        int classe = Integer.parseInt(classesText.getText());
        int preco = Integer.parseInt(precoText.getText());
        int nif = Integer.parseInt(nifText.getText());

        if (classe > 4 || classe < 1) {
            Erros.mostrarErro(this, Erros.CLASSE_INVALIDA);
            return;
        }
        if (nPortas != 3 && nPortas != 5) {
            Erros.mostrarErro(this, Erros.NUMERO_PORTAS_INVALIDAS);
            return;
        }


        Veiculo veiculo = new Veiculo(matriculaText.getText(), marcaText.getText(), modeloText.getText(), combustivel, tipoCaixa, nPortas, nDonos, potencia, cilindrada, classe, preco, nif, tracao, condicaoGeral);

        fechar();
    }

    public boolean verificarPreenchido() {
        if (naofoiPreenchido(matriculaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(marcaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(modeloText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(donoAnteriorText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(nDonosText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(categoriaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(classesText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(nPortasText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(potenciaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (naofoiPreenchido(cilindradaText.getText())) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        if (!gasolinaRadioButton.isSelected() && !dieselRadioButton.isSelected() && !eletricoRadioButton.isSelected()) {
            Erros.mostrarErro(this, Erros.NAO_PREEENCHIDO);
            return false;
        }
        return true;
    }

    private boolean isNumero(String nVeiculos) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.isNumero(nVeiculos);
    }

    public static Veiculo mostrarComprarVeiculo(Frame parent) {
        //todo
        System.out.println("mostrarCriacaoVeiculo");
        var detalhes = new ComprarVeiculo(parent, true);
        detalhes.setLocationRelativeTo(parent);
        detalhes.setVisible(true);
        return detalhes.getVeiculo();
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void fechar() {
        this.setVisible(false);
    }

    private boolean naofoiPreenchido(String text) {
        return text.isEmpty();
    }

    private boolean MatriculaExiste(String matricula) {
        DadosAplicacao dadosAplicacao = DadosAplicacao.INSTANCE;
        return dadosAplicacao.naoExisteVeiculoComMatricula(matricula);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

     */
}
