package ec.edu.espol.tictactoegame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SecondaryController implements Initializable{
    
    @FXML
    private Label lblusuario;
    
    String usuario = PrimaryController.usuario;
    
    static PerfilUsuario PUsuario;
    @FXML
    private Pane panel;
    @FXML
    private Label iaiabutton;
    @FXML
    private Label multi;
    

    @FXML
    private void switchToJugar() throws IOException {
        Alert alertadificultad = new Alert(Alert.AlertType.CONFIRMATION,"DIFICULTAD DE JUEGO");
        alertadificultad.setHeaderText(null);
        alertadificultad.getButtonTypes().clear();
        ButtonType BtnFacil = new ButtonType("FACIL");
        ButtonType BtnNormal = new ButtonType("NORMAL");
        ButtonType BtnDif = new ButtonType("IMPOSIBLE");
        alertadificultad.setContentText("SELECCIONE LA DIFICULTAD");
        alertadificultad.getButtonTypes().setAll(BtnFacil,BtnNormal,BtnDif);
        
        alertadificultad.showAndWait().ifPresent(response -> {
            if (response == BtnFacil) {
                try {
                    App.setRoot("EasyGame");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //Dificultad F
                
            } else if (response == BtnNormal) {
                try {
                    App.setRoot("NormalGame");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //Dificultad N
               
            } else if (response == BtnDif){
                try {
                    App.setRoot("StandarGame");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
        });
         
         
        
    }
   
    
    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("primary");
    }
    
     
    @FXML
    private void switchToHistorial() throws IOException {
        App.setRoot("Historial");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblusuario.setText(usuario);
        PUsuario=new PerfilUsuario(PrimaryController.usuario,PerfilUsuario.cargarPartidas());
   
    }

    @FXML
    private void switchToIAIA(MouseEvent event) {
        try {
            App.setRoot("IAIAGame");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void multi(MouseEvent event) {
        try {
            App.setRoot("MultiGame");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}