package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

public class Pozo extends Interferencia {
    public Pozo(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
<<<<<<< HEAD
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return (vehiculo.devolverVehiculo()).devolverPenalizacionPozo();
=======
    public boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            vehiculo.devolverPenalizacionPozo();
>>>>>>> 9633c478fc4560ef4a348a96ab06bb5869a16af0
        }
        return true;
    }
}
