import AutoSell.Peca;
import AutoSell.PedidoPeca;
import org.junit.jupiter.api.Test;
import AutoSell.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTestCase {

    @Test
    public void testCreatePedido(){

        var peca = new Peca("CONSUMIVEL", "FEIRA_1", "Oléo Motul", 3);
        var pedido = new PedidoPeca("SEDE", "CONSUMIVEL", peca, 3, "Oléo Motul");

        assertEquals("SEDE", pedido.getLocal());
        assertEquals("CONSUMIVEL", pedido.getTipo());
        assertEquals(peca, pedido.getPeca());
        assertEquals(3, pedido.getQuantidadePedida());
        assertEquals("Oléo Motul", pedido.getNome());

    }



}
