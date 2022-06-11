package modelo;

public class Veiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private Integer Ndonos;
    //combustivel
    private String categoria;
    private String classe;
    private Integer Nportas;
    private Integer potencia;
    private Integer quilometros;
    private Integer cilindrada;
    //tipo de caixa
    //traçao
    //condiçaoo geral


    public Veiculo(String matricula, String marca, String modelo, Integer Ndonos, String categoria, String classe, Integer Nportas, Integer potencia, Integer quilometros, Integer cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.Ndonos = Ndonos;
        this.categoria = categoria;
        this.classe = classe;
        this.Nportas = Nportas;
        this.potencia = potencia;
        this.quilometros = quilometros;
        this.cilindrada = cilindrada;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return matricula;
    }
}
