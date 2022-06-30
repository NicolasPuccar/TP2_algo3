package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public class Juego {
    private int movimientos;
    private Mapa mapa;
    private boolean llegada;
    private Random random;


    public Juego(TipoVehiculo vehiculo){
        this.random = new Random();
        this.mapa = new Mapa(vehiculo,this.random.generarInt(15),this.random.generarInt(15));
        this.movimientos = 0;
    }
    public Juego(TipoVehiculo vehiculo,int maxPosX, int maxPosY){
        this.random = new Random();
        this.mapa = new Mapa(vehiculo,maxPosX,maxPosY);
        this.movimientos = 0;
    }
    public void agregarInterferencia(int posicion, Interferencia interferencia){
        this.mapa.agregarInterferenciaAMapa(posicion,interferencia);
    }
    public void crearMeta(){
        this.mapa.crearMeta(this.random);
    }
    public void agregarMeta(int y){
        this.mapa.agregarMeta(y);
    }
    public void crearInterferencias() {
        int cantTotalInterfencias = random.generarInt(10);
        for (int i = 0; i < cantTotalInterfencias; i++) {
            int maxInterferencias = 6;
            int numInterferencia = random.generarInt(maxInterferencias);
            int xIncial = random.generarXInicial();
            int yInicial = random.generarYInicial();
            int xFinal = random.generarXFinal(xIncial);
            int yFinal = random.generarYFinal(yInicial, xIncial, xFinal);
            if (numInterferencia == 0) {
                agregarInterferencia(i, new Pozo(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 1) {
                agregarInterferencia(i, new Piquete(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 2) {
                agregarInterferencia(i, new ControlPolicial(xIncial, yInicial, xFinal, yFinal, random.generarFloat()));
            }
            if (numInterferencia == 3) {
                agregarInterferencia(i, new SorpresaDesfavorable(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 4) {
                agregarInterferencia(i, new SorpresaFavorable(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 5) {
                agregarInterferencia(i, new SorpresaCambioVehiculo(xIncial, yInicial, xFinal, yFinal));

            }
        }
    }


    public void moverVehiculoArriba(){

        mapa.moverVehiculoArriba();
        llegada = mapa.verificarMeta();
    }

    public void moverVehiculoAbajo(){
        mapa.moverVehiculoAbajo();
        llegada = mapa.verificarMeta();
    }

    public void moverVehiculoIzquierda(){
        mapa.moverVehiculoIzquierda();
        llegada = mapa.verificarMeta();
    }

    public void moverVehiculoDerecha(){
        mapa.moverVehiculoDerecha();


        llegada = mapa.verificarMeta();

    }

    public boolean getLlegada() {
        return llegada;
    }

    public int[] obtenerTamanioMapa(){
        return this.mapa.obtenerTamanioMapa();
    }

    public int getMovimientos(){
        return this.mapa.devolverMovimientos();
    }
}