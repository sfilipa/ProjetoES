package modelo;

public class Evento {
    private String nome;
    private Integer nVeiculos;
    private Data dataInicio;
    private Data dataFim;
    private Distrito distrito;
    private Filial filial;

    public Evento(String nome, Integer nVeiculos, Data dataInicio, Data dataFim, Distrito distrito, Filial local) {
        this.nome = nome;
        this.nVeiculos = nVeiculos;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.distrito = distrito;
        this.filial = local;
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

    public Distrito getDistrito() {
        return distrito;
    }

    public Filial getLocal() {
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
