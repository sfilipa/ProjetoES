package modelo;

public class Veiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private Integer nDonos;
    private String combustivel;
    private String categoria;
    private Integer classe;
    private Integer nPortas;
    private Integer potencia;
    private Integer quilometros;
    private Integer cilindrada;
    private String tipoDeCaixa;
    private String tracao;
    private String condicaoGeral;
    private String donoAnterior;
    private String localArmazenamento;

    public Veiculo(String matricula, String marca, String modelo, Integer nDonos, String donoAnterior, String categoria, Integer classe, Integer nPortas, Integer potencia, Integer quilometros, Integer cilindrada, String tipoDeCaixa, String tracao, String condicaoGeral, String combustivel, String localarmazenamento) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.nDonos = nDonos;
        this.categoria = categoria;
        this.classe = classe;
        this.nPortas = nPortas;
        this.potencia = potencia;
        this.quilometros = quilometros;
        this.cilindrada = cilindrada;
        this.tipoDeCaixa = tipoDeCaixa;
        this.tracao = tracao;
        this.condicaoGeral = condicaoGeral;
        this.combustivel = combustivel;
        this.donoAnterior = donoAnterior;
        this.localArmazenamento = localarmazenamento;
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

    public Integer getnDonos() {
        return nDonos;
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

    public Integer getnPortas() {
        return nPortas;
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

    public void setnDonos(Integer nDonos) {
        this.nDonos = nDonos;
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

    public void setnPortas(Integer nPortas) {
        this.nPortas = nPortas;
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

    public String getLocalArmazenamento() {
        return localArmazenamento;
    }

    public void setLocalArmazenamento(String localArmazenamento) {
        this.localArmazenamento = localArmazenamento;
    }

    @Override
    public String toString() {
        return matricula;
    }
}
