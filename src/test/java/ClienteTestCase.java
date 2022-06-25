import modelo.*;
import org.junit.Test;

public class ClienteTestCase {

    @Test
    public void testAdicionarCliente() {
        var cliente = new Cliente("Ricardo", 111222333);

        DadosAplicacao.INSTANCE.adicionarCliente(cliente);

        System.out.println("Nome Cliente:" + cliente.getNome() + "\n" + cliente.getNif() + "\n");

    }

    @Test
    public void testRemoverCliente() {
        Cliente cliente = new Cliente("Ricardo", 111222333);

        DadosAplicacao.INSTANCE.adicionarCliente(cliente);

        System.out.println(DadosAplicacao.INSTANCE.getClientes());

        DadosAplicacao.INSTANCE.removerCliente(cliente);

        System.out.println(DadosAplicacao.INSTANCE.getClientes());
    }




}



