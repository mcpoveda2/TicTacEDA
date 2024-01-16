/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author USERº
 */
public class DatoPersona implements Initializable{
     @FXML
     private Label lblnombre;
     
     @FXML
     private Label lblapellido;
     
     @FXML
     private Label lblnum1;
     @FXML
     private Label lblnum2;
     @FXML
     private Label lblnum3;
     
     @FXML
     private Label lbldireccion;
     
     @FXML
     private Label lblcorreo;
     
     static Contacto c;
     
     Stage stage;
     Scene scene;
     Parent root;
   
     @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void Editar() {
        CrearContacto.c = DatoPersona.c;
       
         try {      
             App.setRoot("crear");
         } catch (IOException ex) {
             ex.printStackTrace();
         }

    }

    
     @FXML
    private void Eliminar() {
        
        Contacto persona = DatoPersona.c;
        ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        
        for(Contacto cont:lcontactos){
            if(cont.getNombre().equals(persona.getNombre())){
                lcontactos.remove(cont);
            }
        }
        
        
        Contacto.setContactos(lcontactos);
        Contacto.writeFile();
        
        try {      
             App.setRoot("secondary");
         } catch (IOException ex) {
             ex.printStackTrace();
         }
        
        
        
    }
    
    @FXML
    private void goBack(){
        
        CircleList<Contacto> LLcontactos = Contacto.toLinkedList();
        Contacto contacto = DatoPersona.c;
        
        for(Contacto cont: LLcontactos){
            System.out.println(cont.getNombre());
        }
        
        int index = LLcontactos.indexOf(contacto);
        
        System.out.println(index);
        Contacto contNew;
        if(index==0){
            contNew = LLcontactos.getLast();
        }else{
            contNew = LLcontactos.get(index-1);
        }
        
        c = contNew;
        
        abrirFXML();

    }
    
    @FXML
    private void goForward(){
        
        CircleList<Contacto> LLcontactos = Contacto.toLinkedList();
        Contacto contacto = (Contacto) DatoPersona.c;
        
        for(Contacto cont: LLcontactos){
            System.out.println(cont.getNombre());
        }
        
        int index = LLcontactos.indexOf(contacto);
        System.out.println(index);
        Contacto contNew;
        if(index==LLcontactos.size()-1){
            contNew = LLcontactos.getFirst();
        }else{
            contNew = LLcontactos.get(index+1);
        }
       
        c = contNew;
        
        abrirFXML();
        
        
    }
    
    
    @FXML
    public void abrirFXML(){  
        
        if(c instanceof Empresa){
            DatoEmpresa.e = (Empresa) c;
            try {      
             App.setRoot("datoEmpresa");
         } catch (IOException ex) {
             ex.printStackTrace();
         }
            
        }else{
            try {      
             App.setRoot("datoPersona");
         } catch (IOException ex) {
             ex.printStackTrace();
         }  
        }
   
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //LlenarDatos(c);
     Contacto persona = DatoPersona.c;
     lblnombre.setText(persona.getNombre());
     
     lblapellido.setText(persona.getApellido());
     
     String num1 = persona.getNumeros().get(0);
     String num2 = persona.getNumeros().get(1);
     //String num3 = persona.getNumeros().get(2);
     
     if(num1!=""){
         lblnum1.setText(num1);   
     }else{
         lblnum1.setText("Sin informacion");
     }
     
      if(num2!=""){
         lblnum2.setText(num2);
         
     }else{
         lblnum2.setText("Sin informacion");
     }
      
      
     

     lbldireccion.setText(persona.getDireccion());

     lblcorreo.setText(persona.getCorreo());  
     
        
    }
    
   /* public void LlenarDatos(Contacto persona){
     //Contacto persona = DatoPersona.c;
     lblnombre.setText(persona.getNombre());
     
     lblapellido.setText(persona.getApellido());
     
     lblnum1.setText(persona.getNumeros().get(0));
     
     lblnum2.setText(persona.getNumeros().get(1));
     
     lblnum3.setText(persona.getNumeros().get(2));

     lbldireccion.setText(persona.getDireccion());

     lblcorreo.setText(persona.getCorreo());  
        
    }*/
    
}
