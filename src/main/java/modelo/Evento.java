package modelo;

public class Evento {
    private String nome;
    private Integer nVeiculos;
    private Data dataInicio;
    private Data dataFim;
    //distrito
    //local

    public Evento(String nome, Integer nVeiculos, Data dataInicio, Data dataFim, Distrito distrito, Filial local) {
        this.nome = nome;
        this.nVeiculos = nVeiculos;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
