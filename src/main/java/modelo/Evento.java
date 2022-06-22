package modelo;

import java.util.List;

public class Evento {
    private String nome;
    private Integer nVeiculos;
    private Data dataInicio;
    private Data dataFim;
    private String distrito;
    private LocalExposicao distritoExposicao;
    private String filial;
    private LocalExposicao localExposicao;

    public Evento(String nome, Integer nVeiculos, Data dataInicio, Data dataFim, String distrito, String filial) {
        this.nome = nome;
        this.nVeiculos = nVeiculos;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.distrito = distrito;
        this.filial = filial;
    }




    public String getNome() {
        return nome;
    }

    public Integer getnVeiculos() {
        return nVeiculos;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getLocal() {
        return filial;
    }

    public int subtrair(){
        long diferenca = dataFim.getCalendar().getTimeInMillis() - dataInicio.getCalendar().getTimeInMillis();
        int dias = (int) (diferenca / (1000 * 60 * 60 * 24));
        return dias;
    }

    @Override
    public String toString() {
        return nome;
    }
}
