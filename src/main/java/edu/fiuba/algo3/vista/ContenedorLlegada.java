package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.vista.eventos.BotonVolverAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorLlegada extends VBox {
    Stage stage;
    public ContenedorLlegada(Stage stage, Juego juego, Scene escenaInicio){
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("VAMOOOO LLEGASTEEE");
        etiqueta.setTextFill(Color.BLACK);

        Label movimientos = new Label();
        movimientos.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        movimientos.setText("Puntuacion: " + juego.getMovimientos());
        movimientos.setTextFill(Color.BLACK);

        Button botonInicio = new Button();
        botonInicio.setText("Volver");
        BotonVolverAtrasEventHandler botonVolverHandler = new BotonVolverAtrasEventHandler(stage,escenaInicio);
        botonInicio.setOnAction(botonVolverHandler);

        this.getChildren().addAll(etiqueta, movimientos, botonInicio);
    }
}
