package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;


import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

import java.util.Random;

public class ControlPolicial extends Interferencia {

    public ControlPolicial(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
<<<<<<< HEAD
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
=======
    public boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal){
>>>>>>> 9633c478fc4560ef4a348a96ab06bb5869a16af0
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            Random random = new Random();
            float prob = random.nextFloat();
            vehiculo.devolverPenalizacionControlPolical(prob);
        }
        return true;
    }
}
