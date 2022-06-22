package modelo;

import java.util.ArrayList;
import java.util.List;

public enum Filial{
    FILIALLEIRIA("Filial Leiria", "Leiria"),
    FILIALPORTO("Filial Porto", "Porto"),
    FILIALLSIBOA("Filial Lisboa", "Lisboa"),
    FILIALAVEIRO("Filial Aveiro", "Aveiro"),
    FILIALBEJA("Filial Beja", "Beja"),
    FILIALBRAGA("Filial Braga", "Braga"),
    FILIALBRAGANÇA("Filial Bragança", "Bragança"),
    FILIALCASTELOBRANCO("Filial Castelo Branco", "Castelo Branco");


    private String displayName;
    private String distrito;

    Filial(String displayName, String distrito) {
        this.displayName = displayName;
        this.distrito = distrito;

    }

    public String displayName() {
        return displayName;
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

