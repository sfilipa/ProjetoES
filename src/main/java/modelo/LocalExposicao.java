package modelo;

public class LocalExposicao {
    //FEIRA_DO_PORTO("Feira do Porto", "Porto"),
    //FEIRA_DE_LISBOA("Feira de Lisboa", "Lisboa"),
    //FEIRA_DE_AVEIRO("Feira de Aveiro", "Aveiro"),
   // FEIRA_DE_BEJA("Feira de Beja", "Beja");

    private String filial;
    private String local;
    private String displayName;
    private String distrito;

    public LocalExposicao(String displayName, String distrito, String filial) {
        this.displayName = displayName;
        this.distrito = distrito;
        this.filial = filial;
    }

    public String getFilial() {
        return filial;
    }

    public String getLocalFilial() {
        return filial;
    }

    public String getLocal() {
        return local;
    }

    public String displayName() {
        return displayName;
    }

    public String getDistrito() {
        return distrito;
    }

    public String toString() {
        return displayName;
    }
}
