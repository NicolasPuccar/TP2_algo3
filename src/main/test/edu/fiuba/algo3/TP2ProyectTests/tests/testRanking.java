package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRanking {
    @Test
    public void test1(){
        // Arrange
        Auto vehiculo = new Auto();
        Juego gpsChallenge = new Juego(vehiculo,1,2);
        gpsChallenge.agregarJugador("Mateo");
        gpsChallenge.agregarMeta(1);
        int movimientosEsperados = 1;

        // Act
        gpsChallenge.moverVehiculoAbajo();//(1,2)
        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}