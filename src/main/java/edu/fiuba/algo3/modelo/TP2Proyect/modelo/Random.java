package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;

public class Random {
    private java.util.Random random = new java.util.Random();
    private int maxXMapa;
    private int maxYMapa;

    public Random(){
    }
    public Random(int xMapa, int yMapa) {
        this.maxXMapa = xMapa;
        this.maxYMapa = yMapa;
    }
    public int generarXInicial(){
        int coordenada =  random.nextInt((this.maxXMapa));
        if(coordenada == 0){
            coordenada = 1;
        }
        return coordenada;
    }
    public int generarYInicial(){
        int coordenada =  random.nextInt((this.maxYMapa));
        if(coordenada == 0){
            coordenada = 1;
        }
        return coordenada;
    }

    public int generarXFinal(int xInicial){
        int valor = 2;
        int empiezaConX = random.nextInt(valor);
        int posXFinal = xInicial;
        if(empiezaConX == 0){
            if(xInicial == this.maxXMapa){
                posXFinal = (xInicial-1);
            }else{
                posXFinal = (xInicial +1);
            }
        }
        return posXFinal;
    }
    public int generarYFinal(int yInicial,int xInicial, int xFinal){
        int posYFinal = yInicial;
        if(xFinal == xInicial){
            if(yInicial == this.maxXMapa){
                posYFinal = (yInicial-1);
            }else{
                posYFinal = (yInicial +1);
            }
        }
        return posYFinal;
    }
    public int generarInt( int numMax){
        int num = random.nextInt(numMax);
        if(num == 0){
            num = 1;
        }
        return num;
    }
    public float generarFloat(){
        return random.nextFloat();
    }

    public Interferencia crearInterferencias() {
        int maxInterferencias = 6;
        int numInterferencia = generarInt(maxInterferencias);
        int xIncial = generarXInicial();
        int yInicial = generarYInicial();
        int xFinal = generarXFinal(xIncial);
        int yFinal = generarYFinal(yInicial, xIncial, xFinal);
        if (numInterferencia == 0) {
            return new Pozo(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 1) {
            return new Piquete(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 2) {
            return new ControlPolicial(xIncial, yInicial, xFinal, yFinal, generarFloat());
        }
        if (numInterferencia == 3) {
            return new SorpresaDesfavorable(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 4) {
            return new SorpresaFavorable(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 5) {
            return new SorpresaCambioVehiculo(xIncial, yInicial, xFinal, yFinal);

        }
        return null;
    }


}

