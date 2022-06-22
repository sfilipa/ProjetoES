package modelo;

public class Cliente {

    private String nome;
    private long nif;

    public Cliente(String nome, long nif){
        this.nome = nome;
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public long getNif() {
        return nif;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("N.: ").append(nif).append(" -> ").append(")");
        return sb.toString();
    }
}
