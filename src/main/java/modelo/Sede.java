package modelo;

public enum Sede {
    Sede;

    private int viaturasMax = 4500;

    public int getViaturasMax() {
        return viaturasMax;
    }

    public static Sede getSede() {
        return Sede;
    }
}
