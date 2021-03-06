package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.vista.ContenedorLlegada;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ControlesEventHandler  implements EventHandler<KeyEvent> {
    private Stage stage;
    private Juego juego;
    private VistaJuego vistaJuego;
    private Scene escenaInicio;

    public ControlesEventHandler(Stage stage, Juego juego, VistaJuego vistaJuego, Scene escenaInicio){
        this.juego = juego;
        this.stage = stage;
        this.vistaJuego = vistaJuego;
        this.escenaInicio = escenaInicio;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case UP:
                this.juego.moverVehiculoArriba();
                this.vistaJuego.update();
                break;
            case DOWN:
                this.juego.moverVehiculoAbajo();
                this.vistaJuego.update();
                break;
            case RIGHT:
                this.juego.moverVehiculoDerecha();
                this.vistaJuego.update();
                break;
            case LEFT:
                this.juego.moverVehiculoIzquierda();
                this.vistaJuego.update();
                break;
        }
        if(juego.getLlegada()){
            ContenedorLlegada contenedorLlegada = new ContenedorLlegada(this.stage, this.juego, this.escenaInicio);
            Scene escenaLlegada = new Scene(contenedorLlegada, 800, 800);
            this.stage.setScene(escenaLlegada);
            this.stage.setFullScreenExitHint("");
            this.stage.setFullScreen(false);
        }
    }
}
