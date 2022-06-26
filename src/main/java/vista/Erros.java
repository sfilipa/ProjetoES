package vista;

import javax.swing.*;
import java.awt.*;

public class Erros {
    public static final int MATRICULA_JA_EXISTE = 1;
    public static final int NAO_PREEENCHIDO = 2;
    public static final int NAO_E_NUMERO = 4;
    public static final int DATA_INVALIDA = 5;
    public static final int DATA_MAIOR = 6;
    public static final int NOME_JA_EXISTE = 7;
    public static final int EVENTO_NAO_SELECIONADO = 8;
    public static final int NIF_JA_EXISTE = 14;
    public static final int VEICULO_NAO_SELECIONADO = 9;
    public static final int NUMERO_VIATURAS_EXCEDIDO = 10;
    public static final int CLASSE_INVALIDA = 11;
    public static final int NUMERO_PORTAS_INVALIDAS = 12;
    public static final int NOME_JA_EXISTE_CLIENTE = 13;
    public static final int CLIENTE_NAO_SELECIONADO = 15;
    public static final int NOME_JA_EXISTE_PECA = 16;
    public static final int NAO_SELECIONADO = 17;
    public static final int LOCAL_NAO_SELECIONADO = 18;
    public static final int SALDO_INSUFICIENTE = 19;
    public static final int LOCAL_JA_EXISTE = 20;

    public static void mostrarErro(Window parent, int numero) {
        //todo
        switch (numero) {
            case MATRICULA_JA_EXISTE:
                JOptionPane.showMessageDialog(parent, "Matrícula inválida. A matrícula introduzida neste veículo, já existe.");
                break;
            case NAO_PREEENCHIDO:
                JOptionPane.showMessageDialog(parent, "Nem todos os campos estão preenchidos/selecionados. Preencha/Selecione para continuar.");
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
            case NOME_JA_EXISTE_CLIENTE:
                JOptionPane.showMessageDialog(parent, "Esse nome de cliente já existe.");
                break;
            case EVENTO_NAO_SELECIONADO:
                JOptionPane.showMessageDialog(parent, "Não existe nenhum evento selecionado.");
                break;
            case NIF_JA_EXISTE:
                JOptionPane.showMessageDialog(parent, "Já existe um cliente com o nif registado.");
                break;
            case VEICULO_NAO_SELECIONADO:
                JOptionPane.showMessageDialog(parent, "Não existe nenhum veículo selecionado.");
                break;
            case NUMERO_VIATURAS_EXCEDIDO:
                JOptionPane.showMessageDialog(parent, "Não é possivel adicionar essa viatura, já não há lugares disponiveis.");
                break;
            case CLASSE_INVALIDA:
                JOptionPane.showMessageDialog(parent, "A classe do veículo não é válida, classe entre 1 e 4.");
                break;
            case NUMERO_PORTAS_INVALIDAS:
                JOptionPane.showMessageDialog(parent, "O número de portas do veículo não é válido, tem de ser 3 ou 5.");
                break;
            case CLIENTE_NAO_SELECIONADO:
                JOptionPane.showMessageDialog(parent, "Não existe nenhum cliente selecionado.");
                break;
            case NOME_JA_EXISTE_PECA:
                JOptionPane.showMessageDialog(parent, "Já existe uma peça com este nome.");
                break;
            case NAO_SELECIONADO:
                JOptionPane.showMessageDialog(parent, "Não existe nenhuma opção selecionada.");
                break;
            case LOCAL_NAO_SELECIONADO:
                JOptionPane.showMessageDialog(parent, "Nenhum local selecionado.");
                break;
            case SALDO_INSUFICIENTE:
                JOptionPane.showMessageDialog(parent, "Sem fundos suficientes para a compra do veiculo.");
                break;
            case LOCAL_JA_EXISTE:
                JOptionPane.showMessageDialog(parent, "Nome registado em outro local");
                break;
            default:

        }
    }

}
