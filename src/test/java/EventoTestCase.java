import modelo.DadosAplicacao;
import modelo.Data;
import modelo.Evento;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EventoTestCase {

    @Test
    public void testEditarEvento() {
        var evento = new Evento("Feira de Maio", 20, new Data(01, 05, 2022), new Data(30, 05, 2022), "Leiria", "Filial Leiria");

        DadosAplicacao.INSTANCE.adicionarEvento(evento);

        System.out.println("Evento Inicial:" + evento.getNome() + "\n" + evento.getnVeiculos() + "\n" + evento.getDataInicio() + "\n" + evento.getDataFim() + "\n" + evento.getDistrito() + "\n" + evento.getLocal());

        DadosAplicacao.INSTANCE.editarEvento(evento, "Feira de Porto", new Data(06, 8, 2022), new Data(30, 8, 2022), 50, "Leiria", "Filial Porto");

        System.out.println("Evento Editado:" + evento.getNome() + "\n" + evento.getnVeiculos() + "\n" + evento.getDataInicio() + "\n" + evento.getDataFim() + "\n" + evento.getDistrito() + "\n" + evento.getLocal());
    }
}
