import AutoSell.Evento;
import org.junit.jupiter.api.Test;
import AutoSell.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class EventoTestCase {

    @Test
    public void testCreateEvent(){
        var evento = new Evento("Feira de Maio", "18/05/2021", "25/05/2021", "FEIRA_1");

        assertEquals("Feira de Maio", evento.getNome());
        assertEquals("18/05/2021", evento.getDataInicio());
        assertEquals("25/05/2021", evento.getDataFim());
        assertEquals("FEIRA_1", evento.getLocal());

    }


}
