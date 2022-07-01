package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Juego {
    private int movimientos;
    private Mapa mapa;
    private boolean llegada;
    private Random random;
    private int maxMapaX;
    private int maxMapaY;

    private String jugador;


    public Juego(TipoVehiculo vehiculo){
        this.random = new Random();
        this.maxMapaX = this.random.generarInt(15);
        this.maxMapaY = this.random.generarInt(15);
        this.random = new Random(this.maxMapaX, this.maxMapaY);
        this.mapa = new Mapa(vehiculo,this.maxMapaX,this.maxMapaY);
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

    public int[] obtenerTamanioMapa(){
        return this.mapa.obtenerTamanioMapa();
    }
    public int[] obtenerCoordenada(){
        return this.mapa.obtenerCoordenada();
    }
    public int[] obtenerCoordenadaMeta(){return this.mapa.obtenerCoordenadaMeta();}

    public List<Interferencia> obtenerInterferencias(){
        return this.mapa.obtenerInterferencias();
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

    public int getMovimientos(){
        int movimientosTotales = this.mapa.devolverMovimientos();
        modificarRanking(movimientosTotales);
        return movimientosTotales;
    }

    public void modificarRanking(int movimientos) {
        File archivo = new File("ranking.txt");
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            }catch (IOException e){
                e.printStackTrace(System.out);
            }
        }
        ArchivoTexto archivoRanking = new ArchivoTexto(archivo);
        ArrayList<Integer> ranking = archivoRanking.leerArchivo();

        ranking.add(movimientos);
        ranking.sort(Comparator.reverseOrder());
        archivoRanking.escribirArchivo(ranking);

//        FileWriter archivoRanking;
//        PrintWriter escritor;
//        try {
//            archivoRanking = new FileWriter("C:\\Mateo\\AyP3\\TP2\\TP2_algo3\\ranking.txt");
//            escritor = new PrintWriter(archivoRanking);
//            escritor.println("Ranking");
//            escritor.println(Integer.toString(ranking.size()));
//            for (int i = 0; i < ranking.size(); i++) {
//                escritor.print(Integer.toString(ranking.get(i)) + ", ");
//            }
//            escritor.close();
//        }catch (Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
    }

    public void agregarJugador(String jugador){
        this.jugador =  jugador;
    }
}