import AutoSell.Evento;
import AutoSell.Peca;
import org.junit.jupiter.api.Test;
import AutoSell.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class PecaTestCase {

    @Test
    public void testCreatePeca(){
        var peca = new Peca("CONSUMIVEL", "FEIRA_1", "Oléo Motul", 3);

        assertEquals("CONSUMIVEL", peca.getTipo());
        assertEquals("FEIRA_1", peca.getLocal());
        assertEquals("Oléo Motul", peca.getNome());
        assertEquals(3, peca.getQuantidade());

    }


}