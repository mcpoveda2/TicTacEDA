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
public class NormalGameController implements Initializable {
    
    private TicTacToeGame game;
    @FXML
    private VBox vboxtictac;
    @FXML
    private GridPane panelPr;
    Button b1 = new Button("REINICIAR");
    private boolean playable;
    private static String imgusu = "circle.png";
    private static String imgia = "x.png";
    private boolean playables0;
    @FXML
    private HBox hboxreiniciar;
    @FXML
    private Button symbolbutton;
    private Label usersymbol;
    
    
     @FXML
    private Label lblwinner;
    
    @FXML
    private Label lblganador;
    @FXML
    private ImageView imvsimbolouser;
      
      
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
       
    }

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
        if(game.Ganador.equals(""))
            turnoIA();
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
                if(playable){
                vboximage.setOnMouseClicked((MouseEvent t) -> {
                    turnoUsuario(c1.fila,c1.columna);
                });
                }
            }else if(c1.contenido.equals("O")){
                Image im = new Image(imgusu);
                imv.setImage(im);
                imv.setFitHeight(100);
                imv.setFitWidth(100);
            }else{
                Image im = new Image(imgia);
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
            lblganador.setText(game.getGanador());
            lblwinner.setText("WINNER");
            hboxreiniciar.getChildren().clear();
            hboxreiniciar.getChildren().clear();
            playable=false;
            EventHandler<ActionEvent> eventoClic = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playable=!playables0;
                playables0=playable;
                iniciar();
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
        Alert alertainitjuego = new Alert(Alert.AlertType.CONFIRMATION,"¿QUIÉN INICIA AL JUEGO?");
        alertainitjuego.setHeaderText(null);
        alertainitjuego.getButtonTypes().clear();
        ButtonType buttonIA = new ButtonType("CPU");
        ButtonType buttonUser = new ButtonType("Usuario");
        alertainitjuego.getButtonTypes().addAll(buttonIA,buttonUser);
        alertainitjuego.showAndWait().ifPresent(response -> {
            if (response == buttonIA) {
                // Acción 1
                playable=false;
                playables0=false;
            } else if (response == buttonUser) {
                // Acción 2
                playable=true;
                playables0=true;
            }
        });
        iniciar();
    }
    public void iniciar(){
        lblwinner.setText("");
        lblganador.setText(" ");
        hboxreiniciar.getChildren().clear();
        game = new TicTacToeNormal();
        actualizarTablero();
        if(!playable)
            turnoIA();
    }

    @FXML
    private void cambiarSimbolo(MouseEvent event) {
        String cambiousu=imgia;
        String cambioia=imgusu;
        imgusu = cambiousu;
        imgia = cambioia;
        if(imgusu.equals("circle.png")){
            Image im = new Image("circle.png");
            imvsimbolouser.setFitHeight(54);
            imvsimbolouser.setFitWidth(54);
            imvsimbolouser.setImage(im);
        }else{
            Image im = new Image("x.png");
            imvsimbolouser.setFitHeight(54);
            imvsimbolouser.setFitWidth(54);
            imvsimbolouser.setImage(im);
        }
        actualizarTablero();
    }
}
