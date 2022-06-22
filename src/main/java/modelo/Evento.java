package modelo;

import java.util.List;

public class Evento {
    private String nome;
    private Integer nVeiculos;
    private Data dataInicio;
    private Data dataFim;
    private String distrito;
    private String local;

    public Evento(String nome, Integer nVeiculos, Data dataInicio, Data dataFim, String distrito, String local) {
        this.nome = nome;
        this.nVeiculos = nVeiculos;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.distrito = distrito;
        this.local = local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setnVeiculos(Integer nVeiculos) {
        this.nVeiculos = nVeiculos;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setLocal(String local) {
        this.local = local;
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
        return local;
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
