import modelo.DadosAplicacao;
import modelo.Veiculo;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VeiculoTestCase {

    @Test
    public void testAdicionarVeiculo() {
        var veiculo = new Veiculo("XJ-88-MM", "AUDI", "K5", 5, "Laura", "A1", 1,
                5, 54553, 525, 456, "manual",
                "traseira", "Bom", "Diesel", "Filial Leiria");
        assertEquals("XJ-88-MM", veiculo.getMatricula());
        assertEquals("AUDI", veiculo.getMarca());
        assertEquals("K5", veiculo.getModelo());
        assertEquals((Integer) 5, veiculo.getNdonos());
        assertEquals("Laura", veiculo.getDonoAnterior());
        assertEquals("A1", veiculo.getCategoria());
        assertEquals((Integer) 1, veiculo.getClasse());
        assertEquals((Integer) 5, veiculo.getNportas());
        assertEquals((Integer) 54553, veiculo.getPotencia());
        assertEquals((Integer) 525, veiculo.getQuilometros());
        assertEquals((Integer) 456, veiculo.getCilindrada());
        assertEquals("manual", veiculo.getTipoDeCaixa());
        assertEquals("traseira", veiculo.getTracao());
        assertEquals("Bom", veiculo.getCondicaoGeral());
        assertEquals("Diesel", veiculo.getCombustivel());
        assertEquals("Filial Leiria", veiculo.getLocalArmazenamento());
    }

    @Test
    public void testRemoverVeiculo() {
        Veiculo veiculo = new Veiculo("XJ-88-MM", "BMW", "K5", 5, "Laura", "A1", 1,
                5, 54553, 525, 456, "manual",
                "traseira", "Bom", "Diesel", "Filial Leiria");

        DadosAplicacao.INSTANCE.adicionarVeiculo(veiculo);

        System.out.println(DadosAplicacao.INSTANCE.getVeiculos());

        DadosAplicacao.INSTANCE.removerVeiculo(veiculo);

        System.out.println(DadosAplicacao.INSTANCE.getVeiculos());
    }

    @Test
    public void testEditarVeiculo() {
        Veiculo veiculo = new Veiculo("XJ-88-MM", "BMW", "K5", 5, "Laura", "A1", 1,
                5, 54553, 525, 456, "manual",
                "traseira", "Bom", "Diesel", "Filial Leiria");

        DadosAplicacao.INSTANCE.adicionarVeiculo(veiculo);

        System.out.println("Veiculo Inicial:" + veiculo.getMatricula() + "\n" + veiculo.getMarca() + "\n" + veiculo.getModelo() + "\n" + veiculo.getNdonos() + "\n" + veiculo.getDonoAnterior() + "\n" + veiculo.getCategoria() + "\n" + veiculo.getClasse() + "\n" + veiculo.getNportas() + "\n" + veiculo.getPotencia() + "\n" + veiculo.getQuilometros() + "\n" + veiculo.getCilindrada() + "\n" + veiculo.getTipoDeCaixa() + "\n" + veiculo.getTracao() + "\n" + veiculo.getCondicaoGeral() + "\n" + veiculo.getCombustivel() + "\n" + veiculo.getLocalArmazenamento());

        DadosAplicacao.INSTANCE.editarVeiculo(veiculo,"JJ-99-HH", "Mercedes", "K5", 5, "Diogo", "A1", 1,
                5, 54553, 525, 456, "manual",
                "traseira", "Muito Mau", "Diesel", "Filial Porto");

        System.out.println("Veiculo Editado:" + veiculo.getMatricula() + "\n" + veiculo.getMarca() + "\n" + veiculo.getModelo() + "\n" + veiculo.getNdonos() + "\n" + veiculo.getDonoAnterior() + "\n" + veiculo.getCategoria() + "\n" + veiculo.getClasse() + "\n" + veiculo.getNportas() + "\n" + veiculo.getPotencia() + "\n" + veiculo.getQuilometros() + "\n" + veiculo.getCilindrada() + "\n" + veiculo.getTipoDeCaixa() + "\n" + veiculo.getTracao() + "\n" + veiculo.getCondicaoGeral() + "\n" + veiculo.getCombustivel() + "\n" + veiculo.getLocalArmazenamento());
    }

    @Test
    public void testTransportarVeiculo() {
        Veiculo veiculo = new Veiculo("XJ-88-MM", "BMW", "K5", 5, "Laura", "A1", 1,
                5, 54553, 525, 456, "manual",
                "traseira", "Bom", "Diesel", "Filial Leiria");

        DadosAplicacao.INSTANCE.adicionarVeiculo(veiculo);

        System.out.println("Veiculo Inicial:" + veiculo.getLocalArmazenamento());

        String ondeTransportar = "Filial Porto";

        DadosAplicacao.INSTANCE.transportarVeiculo(veiculo, ondeTransportar);

        System.out.println("Veiculo Transportado:" + veiculo.getLocalArmazenamento());

    }



}
