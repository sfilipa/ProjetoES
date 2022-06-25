package modelo;

public class Cliente {

    private String nome;
    private Integer nif;
    private String terVeiculo;

    public Cliente(String nome, Integer nif, String terVeiculo){
        this.nome = nome;
        this.nif = nif;
        this.terVeiculo = terVeiculo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNif() {
        return nif;
    }

    public String getTerVeiculo() {
        return terVeiculo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente com o NIF: ").append(nif);//.append("  Nome ").append(nome);
        return sb.toString();
    }
}
