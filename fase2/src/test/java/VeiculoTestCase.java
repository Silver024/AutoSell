import org.junit.jupiter.api.Test;
import AutoSell.Veiculo;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTestCase {

    @Test
    public void testCreateClient() {

        var veiculo = new Veiculo("AI-23-DF", "Mitsubishi", "Lancer Evolution VII", "Total", "Disponível", "Joaquim Tortuga", "2", "06", "1997", "156000", "2000", "420", "Preto", "Coupe", "3", "Boa");

        assertEquals("AI-23-DF", veiculo.getMatricula());
        assertEquals("Mitsubishi", veiculo.getMarca());
        assertEquals("Lancer Evolution VII", veiculo.getModelo());
        assertEquals("Total", veiculo.getGarantia());
        assertEquals("Disponível", veiculo.getDisponibilidade());
        assertEquals("Joaquim Tortuga", veiculo.getDonoAnterior());
        assertEquals("2", veiculo.getNrDonos());
        assertEquals("06", veiculo.getMesRegisto());
        assertEquals("1997", veiculo.getAnoRegisto());
        assertEquals("156000", veiculo.getQuilometros());
        assertEquals("2000", veiculo.getCilindrada());
        assertEquals("420", veiculo.getPotencia());
        assertEquals("Preto", veiculo.getCor());
        assertEquals("Coupe", veiculo.getSegmento());
        assertEquals("3", veiculo.getNrPortas());
        assertEquals("Boa", veiculo.getCondicao());


    }
}