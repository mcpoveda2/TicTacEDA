package ec.edu.espol.tictactoegame;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private TextField txtusuario;
    
    static String usuario;
    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
       
    }
    
    @FXML
    private void GuardarUsuario(){
        String nombre = txtusuario.getText();
        if(nombre.equals("")){
            Mensaje("Ingrese algun nombre");
            
            return;
        }
        
        usuario=nombre;
        try{
            switchToSecondary();
        }catch(Exception e){
            
        }
    }
    
    @FXML
    private void OmitirUsuario(){
        String nombre = txtusuario.getText();
        usuario="Invitado";  
         try{
            switchToSecondary();
        }catch(Exception e){
            
        }
    }
     
      public void Mensaje(String mensaje){
       Alert alerta = new Alert(Alert.AlertType.INFORMATION);
       alerta.setHeaderText(null);
       alerta.setTitle("Aviso");
       alerta.setContentText(mensaje);
       alerta.showAndWait();
   }
     
     
    
}
