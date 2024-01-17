/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author USERº
 */
public class Historial implements Initializable {
    private long SerialVersionID= 100000000;
    @FXML
    private VBox vboxlista = new VBox();
    
    @FXML
    private ScrollPane panelPr;
    
    @FXML 
    private Label lblusuario;
    
    
    PerfilUsuario Usuario = SecondaryController.PUsuario;
    
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("secondary");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblusuario.setText(Usuario.getUsuario());
        CrearLista(Usuario.getPartidas());
    }
    
  
    private void CrearLista( ArrayList<TicTacToeGame> partidas){
        panelPr = new ScrollPane(vboxlista);
        Font font = Font.font("Agency FB", FontWeight.BOLD, 14);
        vboxlista.getStylesheets().add(getClass().getResource("/css/Historial.css").toExternalForm());
        HBox filaC = new HBox();
             filaC.setPrefWidth(560);
             
             Label fecha = new Label("Fecha");
             fecha.setPrefWidth(280);
             fecha.setFont(font);
             
             Label ganador = new Label("Ganador" );
             ganador.setPrefWidth(280);
             ganador.setFont(font);
                   
             Label modo = new Label("Modo de juego" );
            
                
                
            
         
             filaC.getChildren().add(fecha);
             filaC.getChildren().add(ganador);
             
             vboxlista.getChildren().add(filaC);  
             
        Collections.reverse(partidas);
        for( TicTacToeGame c:partidas){
             HBox fila = new HBox();
             Label gn = new Label(c.getGanador() );
             gn.setPrefWidth(280);
             
             
             Label Fecha = new Label( ""+c.getFecha() );
             Fecha.setPrefWidth(280);
   
            if(c.getGanador().equals("IA")){
                fila.getStyleClass().add("mHBoxDerrota");
            } 
            
            if(c.getGanador().equals("EMPATE")){
                fila.getStyleClass().add("mHBoxEmpate");
                
            } 
            
            if(c.getGanador().equals("USUARIO")){
                fila.getStyleClass().add("mHBoxVictoria");
            } 
            
             if(c.getGanador().equals("USUARIO 2 (MULTIPLAYER MODE)") ||c.getGanador().equals("USUARIO 1 (MULTIPLAYER MODE)") ){
                fila.getStyleClass().add("mHBoxMulti");
            } 
            
            
             fila.getChildren().add(Fecha);
             fila.getChildren().add(gn);
             
             vboxlista.getChildren().add(fila);  
    }
        
 }

    
}
