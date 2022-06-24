package modelo;

public class Peca {

    private String nome;
    //private boolean tipoPeca;
    private String minimaFilial;
    private String minimaSede;


    //public Peca(String nome, boolean tipoPeca, Integer minimaFilial, Integer minimaSede) {
    public Peca(String nome, String minimaFilial, String minimaSede) {

        this.nome = nome;
        //this.tipoPeca = tipoPeca;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("  Quantidade minima filial: ").append(minimaFilial).append("   Quantidade minima por sede: ").append(minimaSede);
        return sb.toString();
    }

    // TODO:
    // ver a cena do radiobutton como se faz
}
