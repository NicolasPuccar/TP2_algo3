package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.eventos.BotonInicioEventHandle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
    Stage stage;
    public ContenedorInicio(Stage stage){
        super();
        this.stage = stage;
    }
    public ContenedorInicio(Stage stage,Scene escenaInicio){
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("GPS Challenge");
        etiqueta.setTextFill(Color.web("#000000"));

        ContenedorJugador contenedorJugador = new ContenedorJugador(stage, escenaInicio);
        Scene escenaJugador = new Scene(contenedorJugador, 800, 800);

        Button botonJuego = new Button();
        botonJuego.setText("Jugar");
        BotonInicioEventHandle botonJuegoHandler = new BotonInicioEventHandle(stage, escenaJugador);
        botonJuego.setOnAction(botonJuegoHandler);

        ContenedorRanking contenedorRanking = new ContenedorRanking(stage,escenaInicio);
        Scene escenaRanking = new Scene(contenedorRanking, 800, 800);

        Button botonRanking = new Button();
        botonRanking.setText("Ver Ranking");
        BotonInicioEventHandle botonRankingHandler = new BotonInicioEventHandle(stage, escenaRanking);
        botonRanking.setOnAction(botonRankingHandler);

        this.getChildren().addAll(etiqueta, botonJuego, botonRanking);
    }
}
