package vista;

import javax.swing.*;
import java.awt.*;

public class Erros {
    public static final int MATRICULA_JA_EXISTE = 1;
    public static final int NAO_PREEENCHIDO = 2;
    public static final int CONTEM_CARACTERES_ESPECIAIS = 3;
    public static final int NAO_E_NUMERO = 4;
    public static final int DATA_INVALIDA = 5;
    public static final int DATA_MAIOR = 6;
    public static final int NOME_JA_EXISTE = 7;
    public static final int EVENTO_NAO_SELECIONADO = 8;
    public static final int NIF_JA_EXISTE = 8;

    public static void mostrarErro(Window parent, int numero){
        //todo
        switch (numero) {
            case MATRICULA_JA_EXISTE:
                JOptionPane.showMessageDialog(parent, "Matrícula inválida. A matrícula introduzida neste veículo, já existe.");
                break;
            case NAO_PREEENCHIDO:
                JOptionPane.showMessageDialog(parent, "Nem todos os campos estão preenchidos/selecionados. Preencha/Selecione para continuar.");
                break;
            case CONTEM_CARACTERES_ESPECIAIS:
                JOptionPane.showMessageDialog(parent, "Algum dos campos contém caracteres especiais.");
                break;
            case NAO_E_NUMERO:
                JOptionPane.showMessageDialog(parent, "Algum dos campos não é um número ou é um número inválido,tem de ser maior que 0.");
                break;
            case DATA_INVALIDA:
                JOptionPane.showMessageDialog(parent, "Essa data é inválida formato pretendido - dia/mes/ano.");
                break;
            case DATA_MAIOR:
                JOptionPane.showMessageDialog(parent, "A data de inicio tem de ser menor que a data final.");
                break;
            case NOME_JA_EXISTE:
                JOptionPane.showMessageDialog(parent, "Esse evento já existe.");
                break;
            case EVENTO_NAO_SELECIONADO:
                JOptionPane.showMessageDialog(parent, "Não existe nenhum evento selecionado.");
                break;
            default:
        }
    }

}
