package modelo;

public enum Filial {
    FILIALLEIRIA("Filial Leiria"),
    FILIALPORTO("Filial Porto"),
    FILIALLSIBOA("Filial Lisboa"),
    FILIALAVEIRO("Filial Aveiro"),
    FILIALBEJA("Filial Beja"),
    FILIALBRAGA("Filial Braga"),
    FILIALBRAGANÇA("Filial Bragança"),
    FILIALCASTELOBRANCO("Filial Castelo Branco");


    private String displayName;

    Filial(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

