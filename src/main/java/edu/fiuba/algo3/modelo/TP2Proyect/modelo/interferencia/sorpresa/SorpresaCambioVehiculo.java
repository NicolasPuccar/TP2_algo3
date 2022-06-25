package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

public class SorpresaCambioVehiculo extends Interferencia {
    public SorpresaCambioVehiculo(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
    public boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            vehiculo.cambiarEstado();
        }
        return true;
    }
}