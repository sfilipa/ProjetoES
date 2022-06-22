package modelo;

import java.util.ArrayList;
import java.util.List;

public enum LocalExposicao {
    FEIRA_DO_PORTO("Feira do Porto", "Porto"),
    FEIRA_DE_LISBOA("Feira de Lisboa", "Lisboa"),
    FEIRA_DE_AVEIRO("Feira de Aveiro", "Aveiro"),
    FEIRA_DE_BEJA("Feira de Beja", "Beja");


    private String displayName;
    private String distrito;

    LocalExposicao(String displayName, String distrito) {
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
}
