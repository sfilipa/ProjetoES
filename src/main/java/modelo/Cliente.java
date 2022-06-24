package modelo;

public class Cliente {

    private String nome;
    private Integer nif;

    public Cliente(String nome, Integer nif){
        this.nome = nome;
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNif() {
        return nif;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("N.: ").append(nif).append(" -> ").append(")");
        return sb.toString();
    }
}
