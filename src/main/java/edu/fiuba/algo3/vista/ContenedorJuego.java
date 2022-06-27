package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.manejadores.BotonInicioEventHandle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorJuego extends VBox {
    Stage stage;
    //VBox contenedor;
    //static private String path;
    public ContenedorJuego(Stage stage){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        Label titulo = new Label();
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        titulo.setText("PROXIMAMENTE");
        titulo.setTextFill(Color.web("#000000"));

        this.getChildren().addAll(titulo);
    }
}