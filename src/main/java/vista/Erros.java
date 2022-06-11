package vista;

import javax.swing.*;
import java.awt.*;

public class Erros {
    public static final int MATRICULA_JA_EXISTE = 1;
    public static final int NAO_PREEENCHIDO = 2;
    public static final int CONTEM_CARACTERES_ESPECIAIS = 3;
    public static final int NAO_E_NUMERO = 4;

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
                JOptionPane.showMessageDialog(parent, "Algum dos campos marca, modelo, dono anterior e categoria contém caracteres especiais.");
                break;
            case NAO_E_NUMERO:
                JOptionPane.showMessageDialog(parent, "Algum dos campos Nº de donos, Nº de portas, potência, quilómetros, classe e cilindrada não é um número.");
                break;
            default:
        }
    }

}
