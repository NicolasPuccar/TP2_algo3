package edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Random;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import java.util.List;
import java.util.ArrayList;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    private List<Interferencia> interferencias = new ArrayList<Interferencia>();
    private Meta meta;

    public Mapa(TipoVehiculo vehiculo, int maxPosX, int maxPosY){
        this.maximoX = maxPosX;
        this.maximoY = maxPosY;
        this.vehiculo = new Vehiculo(vehiculo);
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
    }

    public int devolverMovimientos(){
        return this.vehiculo.devolverMovimientos();
    }

    public void moverVehiculoAbajo(){
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
        boolean vehiculoAvanza = true;
        for(int i = 0; i < this.interferencias.size(); i++){
            boolean permiso = interferencias.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY);
            if(!permiso) {
                vehiculoAvanza = false;
            }
        }
        this.vehiculo.sumarMovimiento();
        return vehiculoAvanza;
    }

    public void agregarInterferenciaAMapa(int posicion, Interferencia interferencia){
        this.interferencias.add(posicion,interferencia);
    }

    public void crearMeta(Random ran){
        this.meta = new Meta (maximoX, ran.generarYInicial());
    }

    public void agregarMeta(int y){
        this.meta = new Meta (maximoX, y);
    }

    public boolean verificarMeta(){
        return meta.verificarMeta(posVehiculoX, posVehiculoY);
    }

    public int[] obtenerTamanioMapa(){
        int[] tamanio = new int[2];
        tamanio[0] = maximoX;
        tamanio[1] = maximoY;
        return tamanio;
    }

    public int[] obtenerCoordenadaVehiculo(){
        int[] coordenada = new int[2];
        coordenada[0] = posVehiculoX;
        coordenada[1] = posVehiculoY;
        return coordenada;
    }

    public int[] obtenerCoordenadaMeta(){
        return this.meta.obtenerCoordenadasMeta();
    }

    public List<Interferencia> obtenerInterferencias(){
        return interferencias;
    }

    public Vehiculo obtenerVehiculo(){
        return vehiculo;
    }
}