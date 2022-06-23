package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

import java.util.List;
import java.util.ArrayList;


public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    private List<Interferencia> interferencias = new ArrayList<Interferencia>();

    private boolean llegada;
    private Meta meta;
    private Random random;

    public Mapa(TipoVehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
<<<<<<< HEAD
        this.meta = new Meta (maximoX, 5);
        this.vehiculo = new TipoVehiculo(vehiculo);
=======
        this.vehiculo = new Vehiculo(vehiculo);
>>>>>>> 9633c478fc4560ef4a348a96ab06bb5869a16af0
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.random = new Random(maximoX, maximoY);

    }
<<<<<<< HEAD
    public boolean verificarMeta(){
       return meta.verificarMeta(posVehiculoX, posVehiculoY);
    }
    public int moverVehiculoAbajo(int movimientos){
=======


    public int devolverMovimientos(){
        return this.vehiculo.devolverMovimientos();
    }
    public void moverVehiculoAbajo(){
>>>>>>> 9633c478fc4560ef4a348a96ab06bb5869a16af0
        if(posVehiculoY + 1 <= maximoY) {
            if (revisarObstaculos(posVehiculoX, (posVehiculoY + 1))) {
                posVehiculoY++;
            }
        }
    }
    public void moverVehiculoArriba(){
        if(posVehiculoY - 1 != 0) {
            if(revisarObstaculos(posVehiculoX, (posVehiculoY - 1))){
                posVehiculoY--;

            }
        }

    }
    public void moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            if(revisarObstaculos((posVehiculoX + 1), posVehiculoY)){
                posVehiculoX++;
            }
        }
    }
    public void moverVehiculoIzquierda(){
        if(posVehiculoX - 1 != 0) {
            if(revisarObstaculos((posVehiculoX - 1), posVehiculoY)){
                posVehiculoX--;
            }
        }
    }
    private boolean revisarObstaculos(int posX, int posY){
        boolean vehiculoAvanza = false;
        for(int i = 0; i < this.interferencias.size(); i++){
            vehiculoAvanza = interferencias.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY);
        }

        return vehiculoAvanza;
    }


    public void agregarInterferenciaAMapa(int posicion, Interferencia interferencia){
        this.interferencias.add(posicion,interferencia);
    }
}

