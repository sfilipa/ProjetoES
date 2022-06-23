package modelo;

public class Veiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private Integer Ndonos;
    private String combustivel;
    private String categoria;
    private Integer classe;
    private Integer Nportas;
    private Integer potencia;
    private Integer quilometros;
    private Integer cilindrada;
    private String tipoDeCaixa;
    private String tracao;
    private String condicaoGeral;
    private String donoAnterior;

    public Veiculo(String matricula, String marca, String modelo, Integer Ndonos, String donoAnterior, String categoria, Integer classe, Integer Nportas, Integer potencia, Integer quilometros, Integer cilindrada, String tipoDeCaixa, String tracao, String condicaoGeral, String combustivel) {
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
        this.tipoDeCaixa = tipoDeCaixa;
        this.tracao = tracao;
        this.condicaoGeral = condicaoGeral;
        this.combustivel = combustivel;
        this.donoAnterior = donoAnterior;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getNdonos() {
        return Ndonos;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public Integer getClasse() {
        return classe;
    }

    public Integer getNportas() {
        return Nportas;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public Integer getQuilometros() {
        return quilometros;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public String getTipoDeCaixa() {
        return tipoDeCaixa;
    }

    public String getTracao() {
        return tracao;
    }

    public String getCondicaoGeral() {
        return condicaoGeral;
    }

    public String getDonoAnterior() {
        return donoAnterior;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNdonos(Integer ndonos) {
        Ndonos = ndonos;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setClasse(Integer classe) {
        this.classe = classe;
    }

    public void setNportas(Integer nportas) {
        Nportas = nportas;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public void setQuilometros(Integer quilometros) {
        this.quilometros = quilometros;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setTipoDeCaixa(String tipoDeCaixa) {
        this.tipoDeCaixa = tipoDeCaixa;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public void setCondicaoGeral(String condicaoGeral) {
        this.condicaoGeral = condicaoGeral;
    }

    public void setDonoAnterior(String donoAnterior) {
        this.donoAnterior = donoAnterior;
    }

    @Override
    public String toString() {
        return matricula;
    }
}
