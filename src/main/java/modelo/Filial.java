package modelo;

import java.util.ArrayList;
import java.util.List;

public enum Filial{
    FILIALLEIRIA("Filial Leiria", "Leiria", 100),
    FILIALPORTO("Filial Porto", "Porto", 100),
    FILIALLSIBOA("Filial Lisboa", "Lisboa", 100),
    FILIALAVEIRO("Filial Aveiro", "Aveiro", 100),
    FILIALBEJA("Filial Beja", "Beja", 100),
    FILIALBRAGA("Filial Braga", "Braga", 100),
    FILIALBRAGANÇA("Filial Bragança", "Bragança", 100),
    FILIALCASTELOBRANCO("Filial Castelo Branco", "Castelo Branco", 100);

    private String displayName;
    private String distrito;

    private Integer viaturasMax;

    Filial(String displayName, String distrito, int viaturasMax) {
        this.displayName = displayName;
        this.distrito = distrito;
        this.viaturasMax = viaturasMax;
    }


    public String displayName() {
        return displayName;
    }

    public Integer ViaturasMax() {
        return viaturasMax;
    }

    public String distrito() {
        return distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public String toStringFilial() {
        return " " + displayName + " ";
    }

    public String toStringDistrito() {
        return " " + distrito + " ";
    }


}

