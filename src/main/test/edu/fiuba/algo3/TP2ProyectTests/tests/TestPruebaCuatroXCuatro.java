package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPruebaCuatroXCuatro {
    @Test
    public void test1(){
        // Arrange
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        Juego gpsChallenge = new Juego(vehiculo,10,10);

        Interferencia obstaculo1 = new Pozo(1,2,2,2);

        Interferencia obstaculo2 = new Pozo(2,2, 3,2);

        Interferencia obstaculo3 = new Pozo(5,2,5,3);

        Interferencia obstaculo4 = new Piquete(3,3,4,3);

        Interferencia obstaculo5 = new ControlPolicial(4,1,3,1, (float) 0.8);

        gpsChallenge.agregarInterferencia(0,obstaculo1);
        gpsChallenge.agregarInterferencia(1,obstaculo2);
        gpsChallenge.agregarInterferencia(2,obstaculo3);
        gpsChallenge.agregarInterferencia(3,obstaculo4);
        gpsChallenge.agregarInterferencia(4,obstaculo5);

        gpsChallenge.agregarMeta(1);

        int movimientosEsperados = 14;

        // Act
        gpsChallenge.moverVehiculoAbajo();//(1,2)
        gpsChallenge.moverVehiculoDerecha();//(2,2)
        gpsChallenge.moverVehiculoDerecha();//(3,2)
        gpsChallenge.moverVehiculoAbajo();//(3,3)
        gpsChallenge.moverVehiculoDerecha();//(3,3) no avanza

        gpsChallenge.moverVehiculoArriba(); // (3,2)
        gpsChallenge.moverVehiculoDerecha(); // (4,2)
        gpsChallenge.moverVehiculoAbajo(); // (4,3)
        gpsChallenge.moverVehiculoDerecha(); //(5,3)
        gpsChallenge.moverVehiculoArriba(); // (5,2)
        gpsChallenge.moverVehiculoArriba(); // (5,1)
        gpsChallenge.moverVehiculoIzquierda(); // (4,1)
        gpsChallenge.moverVehiculoIzquierda(); // (3,1)

//
        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
    @Test
    public void test2(){
        // Arrange
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        Juego gpsChallenge = new Juego(vehiculo,10,10);

        Interferencia obstaculo1 = new Pozo(1,2,2,2);

        Interferencia obstaculo2 = new Pozo(2,2, 3,2);

        Interferencia obstaculo3 = new Pozo(5,2,5,3);

        Interferencia obstaculo4 = new Piquete(3,3,4,3);

        Interferencia obstaculo5 = new ControlPolicial(4,1,3,1, (float) 0.1);

        gpsChallenge.agregarInterferencia(0,obstaculo1);
        gpsChallenge.agregarInterferencia(1,obstaculo2);
        gpsChallenge.agregarInterferencia(2,obstaculo3);
        gpsChallenge.agregarInterferencia(3,obstaculo4);
        gpsChallenge.agregarInterferencia(4,obstaculo5);

        gpsChallenge.agregarMeta(1);

        int movimientosEsperados = 17;

        // Act
        gpsChallenge.moverVehiculoAbajo();//(1,2)
        gpsChallenge.moverVehiculoDerecha();//(2,2)
        gpsChallenge.moverVehiculoDerecha();//(3,2)
        gpsChallenge.moverVehiculoAbajo();//(3,3)
        gpsChallenge.moverVehiculoDerecha();//(3,3) no avanza

        gpsChallenge.moverVehiculoArriba(); // (3,2)
        gpsChallenge.moverVehiculoDerecha(); // (4,2)
        gpsChallenge.moverVehiculoAbajo(); // (4,3)
        gpsChallenge.moverVehiculoDerecha(); //(5,3)
        gpsChallenge.moverVehiculoArriba(); // (5,2)
        gpsChallenge.moverVehiculoArriba(); // (5,1)
        gpsChallenge.moverVehiculoIzquierda(); // (4,1)
        gpsChallenge.moverVehiculoIzquierda(); // (3,1)

//
        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}
