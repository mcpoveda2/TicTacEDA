/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class IAIAGameController implements Initializable {
    
    private TicTacToeIAIA game;
    @FXML
    private VBox vboxtictac;
    @FXML
    private GridPane panelPr;
    Button b1 = new Button("REINICIAR");
    private boolean playable;
    private boolean playables0;
    private boolean nextnext = false;
    
    @FXML
    private Button nextMove;
    
    @FXML
    private HBox hboxreiniciar;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
       
    }
    

    /**
     * Initializes the controller class.
     */
    public void turnoIA(){
        game.turnoIA();
        actualizarTablero();
    }
    public void turnoUsuario(){
        game.turnoUsuario();
        actualizarTablero();
    }
    
    public void entrarUsuario(){
      
    }
    
    
    
    
    public void actualizarTablero(){
        vboxtictac.getChildren().clear();
            int contador = 1;
            HBox h1 = new HBox();
            for(Celda c1:game.tablero.celdas){
                ImageView imv = new ImageView();
                VBox vboximage = new VBox();
                if(c1.contenido==null){
                    Image im = new Image("c1.png");
                    imv.setImage(im);
                    imv.setFitHeight(100);
                    imv.setFitWidth(100);
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
                vboximage.getChildren().add(imv);
                h1.getChildren().add(vboximage);
                if(contador%3==0){
                    vboxtictac.getChildren().add(h1);
                    h1 = new HBox();
                }
                contador+=1;
            }
        if(!game.playable){
            nextMove.setDisable(true);
            System.out.println(game.tablero);
            EventHandler<ActionEvent> eventoClic = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nextMove.setDisable(false);
                hboxreiniciar.getChildren().clear();
                iniciar();
                // Tu código de manejo de eventos aquí
                }
            };
            b1.setOnAction(eventoClic);
             b1.getStyleClass().add("btn");
            hboxreiniciar.getChildren().add(b1);
        }
            

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          hboxreiniciar.getStylesheets().add(getClass().getResource("/css/TicTacToeGames.css").toExternalForm());
        entrarUsuario();
        iniciar();
    }
    public void iniciar(){
        game = new TicTacToeIAIA();
        actualizarTablero();
    }

    @FXML
    private void nextIA(MouseEvent event) {
        if(nextnext){
            turnoIA();
            nextnext=false;
        }
        else{
            turnoUsuario();
            nextnext=true;
        }
    }
}
