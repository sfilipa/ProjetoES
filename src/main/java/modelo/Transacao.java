package modelo;

public class Transacao {

    private String matricula;

    private String marca;

    private String modelo;

    private String donoAnterior;

    private String nDonos;

    private String combustivel;

    private String categoria;

    private String classe;

    private String nPortas;

    private String potencia;

    private String cilindrada;

    private String tipoDeCaixa;

    private String tracao;

    private String condicaoGeral;

    private String preco;

    private String NIF;

    private String quilometros;


    public Transacao(String matricula, String marca, String modelo, String donoAnterior, String nDonos, String combustivel, String categoria, String classe, String nPortas, String potencia, String cilindrada, String tipoDeCaixa, String tracao, String condicaoGeral, String preco){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.donoAnterior = donoAnterior;
        this.nDonos = nDonos;
        this.combustivel = combustivel;
        this.categoria = categoria;
        this.classe = classe;
        this.nPortas = nPortas;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.tipoDeCaixa = tipoDeCaixa;
        this.tracao = tracao;
        this.condicaoGeral = condicaoGeral;
        this.preco = preco;
        this.quilometros = quilometros;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDonoAnterior() {
        return donoAnterior;
    }

    public void setDonoAnterior(String donoAnterior) {
        this.donoAnterior = donoAnterior;
    }

    public String getnDonos() {
        return nDonos;
    }

    public void setnDonos(String nDonos) {
        this.nDonos = nDonos;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getnPortas() {
        return nPortas;
    }

    public void setnPortas(String nPortas) {
        this.nPortas = nPortas;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoDeCaixa() {
        return tipoDeCaixa;
    }

    public void setTipoDeCaixa(String tipoDeCaixa) {
        this.tipoDeCaixa = tipoDeCaixa;
    }

    public String getTracao() {
        return tracao;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public String getCondicaoGeral() {
        return condicaoGeral;
    }

    public void setCondicaoGeral(String condicaoGeral) {
        this.condicaoGeral = condicaoGeral;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getQuilometros() {
        return quilometros;
    }

    public void setQuilometros(String quilometros) {
        this.quilometros = quilometros;
    }

}
