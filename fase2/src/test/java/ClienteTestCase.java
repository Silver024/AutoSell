import org.junit.jupiter.api.Test;
import AutoSell.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestCase {

    @Test
    public void testCreateClient(){

        var cliente = new Cliente("Joaquim Tortuga", "Rua dos Clerigos, 202", "NPC", "06/08/1982", "91773366", "tortuga.1982@hotmail.com", "201764569", "Desempregado");

        assertEquals("Joaquim Tortuga", cliente.getNome());
        assertEquals("Rua dos Clerigos, 202", cliente.getMorada());
        assertEquals("NPC", cliente.getGenero());
        assertEquals("06/08/1982", cliente.getDataNascimento());
        assertEquals("91773366", cliente.getContacto());
        assertEquals("tortuga.1982@hotmail.com", cliente.getEmail());
        assertEquals("201764569", cliente.getnif());
        assertEquals("Desempregado", cliente.getEstadoProfissional());

    }



}
