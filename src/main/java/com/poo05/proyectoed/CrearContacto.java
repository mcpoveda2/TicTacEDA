/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author USERº
 */
public class CrearContacto implements Initializable{
    
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtapellido;
    @FXML
    private TextField txtnumero;
    @FXML
    private TextField txtnumero2;
    @FXML
    private TextField txtnumero3;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextField txtcorreo;
    
    @FXML
    private ChoiceBox cbgrupo;
    
    static Contacto c = null;
    String nombreC;
 
    
     @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void Agregar(){
        
        if(c==null){
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String numero = txtnumero.getText();
        String numero2 = txtnumero2.getText();
        String numero3 = txtnumero2.getText();
        String direccion = txtdireccion.getText();
        String correo = txtcorreo.getText();
        
        if(nombre.isEmpty() || apellido.isEmpty() || numero.isEmpty()){
            Mensaje("Llene los campos de nombre, apellido y numero");
        }
 
        String letra = nombre.substring(0,1);
        ASVArrayList<String> numeros = new ASVArrayList();
        numeros.add(numero);
        numeros.add(numero2);
        numeros.add(numero3);
        Contacto contacto = new Contacto(nombre,apellido,numeros,correo,letra,direccion);
        contacto.add(contacto);
        Mensaje("Contacto Agregado");
        txtnombre.clear();
        txtapellido.clear();
        txtnumero.clear();
        txtnumero2.clear();
        txtnumero3.clear();
        txtdireccion.clear();
        txtcorreo.clear();
        }else{
            
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String numero = txtnumero.getText();
        String numero2 = txtnumero2.getText();
        String numero3 = txtnumero2.getText();
        String direccion = txtdireccion.getText();
        String correo = txtcorreo.getText();
        String letra = nombre.substring(0,1);
        ASVArrayList<String> numeros = new ASVArrayList();
        numeros.add(numero);
        numeros.add(numero2);
        numeros.add(numero3);
        Contacto contacto = new Contacto(nombre,apellido,numeros,correo,letra,direccion);
        
        ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        
        for(Contacto cont:lcontactos){
            
            if(cont.getNombre().equals(nombreC)){
                lcontactos.remove(cont);
                contacto.add(contacto);
            }
        }
        
        
        Contacto.setContactos(lcontactos);
        
        Contacto.writeFile();
        c = null;
            
            
        }
           
        
        
        /*txtnombre.setText(c.getNombre());
            txtapellido.setText(c.getApellido());
            txtnumero.setText(c.getNumero());
            txtdireccion.setText(c.getDireccion());
            txtcorreo.setText(c.getCorreo());*/
        
    
        
    }

    @Override
     public void initialize(URL url, ResourceBundle rb) {
 
         if(c!=null){
             
            nombreC=c.getNombre();
            txtnombre.setText(c.getNombre());
            txtapellido.setText(c.getApellido());
            txtnumero.setText(c.getNumero());
            txtdireccion.setText(c.getDireccion());
            txtcorreo.setText(c.getCorreo());
             
         }
     }
    
    
      public void Mensaje(String mensaje){
       Alert alerta = new Alert(Alert.AlertType.INFORMATION);
       alerta.setTitle("Aviso");
       alerta.setContentText(mensaje);
       alerta.showAndWait();
   }
    
}

 
