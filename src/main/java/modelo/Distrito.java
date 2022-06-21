package modelo;

public enum Distrito {
    LEIRIA("Leiria"),
    PORTO("Porto"),
    LSIBOA("Lisboa"),
    AVEIRO("Aveiro"),
    BEJA("Beja"),
    BRAGA("Braga"),
    BRAGANÇA("Bragança"),
    CASTELOBRANCO("Castelo Branco");


    private String displayName;

    Distrito(String displayName) {
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
