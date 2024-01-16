/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class StandarGameController implements Initializable {
    private TicTacToeGame game;
    @FXML
    private VBox vboxtictac;
    private boolean playable = true;

    /**
     * Initializes the controller class.
     */
    public void turnoIA(){
        game.turnoIA();
        playable=true;
        actualizarTablero();
    }
    public void turnoUsuario(int fila, int columna){
        game.turnoUsuario(fila, columna);
        playable=false;
        actualizarTablero();
        turnoIA();
    }
    public void actualizarTablero(){
        vboxtictac.getChildren().clear();
        int contador = 1;
        HBox h1 = new HBox();
        for(Celda c1:game.tablero.celdas){
            ImageView imv = new ImageView();
            if(c1.contenido==null){
                Image im = new Image("c1.png");
                imv.setImage(im);
                imv.setFitHeight(100);
                imv.setFitWidth(100);
                if(playable){
                imv.setOnMouseClicked((MouseEvent t) -> {
                    turnoUsuario(c1.fila,c1.columna);
                });
                }
            }else if(c1.contenido.equals("O")){
                Image im = new Image("circle.png");
                imv.setImage(im);
                imv.setFitHeight(100);
                imv.setFitWidth(100);
            }else{
                Image im = new Image("x.png");
                imv.setImage(im);
                imv.setFitHeight(100);
                imv.setFitWidth(100);
            }
            h1.getChildren().add(imv);
            if(contador%3==0){
                vboxtictac.getChildren().add(h1);
                h1 = new HBox();
            }
            contador+=1;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new TicTacToeGame();
        actualizarTablero();
    }
}
