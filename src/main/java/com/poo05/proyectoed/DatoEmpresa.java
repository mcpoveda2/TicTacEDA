/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author USERº
 */
public class DatoEmpresa implements Initializable{
    
    @FXML
     private Label lblnombre;
     
     @FXML
     private Label lblpersona;
     
     @FXML
     private Label lblnum1;
     
     @FXML
     private Label lblnum2;
     
     @FXML
     private Label lbldireccion;
     
     @FXML
     private Label lblcorreo;
    
     static Empresa e;
   
    
     @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
      @FXML
    private void Editar() {
        
        CrearEmpresa.e = DatoEmpresa.e;
       
         try {      
             App.setRoot("crearEmpresa");
         } catch (IOException ex) {
             ex.printStackTrace();
         }
        
    }
    
     @FXML
    private void Eliminar() {
        
        Contacto persona = DatoEmpresa.e;
        
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
        Contacto contacto = (Contacto) DatoEmpresa.e;
        
        for(Contacto cont: LLcontactos){
            System.out.println(cont.getNombre());
        }
        
        int index = LLcontactos.indexOf(contacto);
        Object contNew;
        if(index==0){
            contNew = LLcontactos.getLast();
        }else{
            contNew = LLcontactos.get(index-1);
        }
        
       
    
        abrirFXML(contNew);
    }
    
    @FXML
    private void goForward(){
        CircleList<Contacto> LLcontactos = Contacto.toLinkedList();
        Contacto contacto = (Contacto) DatoEmpresa.e;
        
        for(Contacto cont: LLcontactos){
            System.out.println(cont.getNombre());
        }
        
        int index = LLcontactos.indexOf(contacto);
        System.out.println(index);
        
        Object contNew;
        
        if(index==LLcontactos.size()-1){
            contNew = LLcontactos.getFirst();
        }else{
            contNew = LLcontactos.get(index+1);
        }
        System.out.println(contNew);
        abrirFXML(contNew);
        
        
    }
    @FXML
    public void abrirFXML(Object contNew){  
        
        if(contNew instanceof Empresa){
            try {      
             DatoEmpresa.e = (Empresa)contNew;
             App.setRoot("datoEmpresa");
         } catch (IOException ex) {
            
             ex.printStackTrace();
         }
            
        }else{
            try {   
             DatoPersona.c = (Contacto)contNew;
             App.setRoot("datoPersona");
         } catch (IOException ex) {
             ex.printStackTrace();
         }  
        }
   
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     Contacto empresa= DatoEmpresa.e;
     lblnombre.setText(empresa.getNombre());
     
     lblpersona.setText(empresa.getApellido());
     
     String numlocal = empresa.getNumeros().get(0);
     String numpersona =empresa.getNumeros().get(1);
     
     if(numlocal!=""){
         lblnum1.setText(numlocal);   
     }else{
         lblnum1.setText("Sin informacion");
     }
     
      if(numpersona!=""){
         lblnum2.setText(numpersona);
         
     }else{
         lblnum2.setText("Sin informacion");
     }
      
     lbldireccion.setText(empresa.getDireccion());

     lblcorreo.setText(empresa.getCorreo());  
     
        
    }
    
}
