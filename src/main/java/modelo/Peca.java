package modelo;

public class Peca {

    private String nome;

    private String tipoPeca;
    private String minimaFilial;
    private String minimaSede;

    private Integer quantidade;

    public Peca(String nome, String tipoPeca, String minimaFilial, String minimaSede) {

        this.nome = nome;
        this.tipoPeca = tipoPeca;
        this.minimaFilial = minimaFilial;
        this.minimaSede = minimaSede;
    }

    public String getNome() {
        return nome;
    }

    public String getMinimaFilial() {
        return minimaFilial;
    }

    public String getMinimaSede() {
        return minimaSede;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setTipo(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getTipo() {
        return tipoPeca;
    }

    public void setNome(String text) {
    }

    public void setQuantidadeMinimaSede(int parseInt) {
    }

    public void setQuantidadeMinimaFileal(int parseInt) {
    }

    public void setLocalArmazenamento(String localArmazenamento) {
    }

    public int getQuantidadeMinimaFileal() {
        return 0;
    }

    public int getQuantidadeMinimaSede() {
        return 0;
    }

    @Override
    public String toString() {
        return nome;
    }

}
