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
import javafx.scene.control.TextField;

/**
 *
 * @author USERº
 */
public class CrearEmpresa implements Initializable{
        
    @FXML
    public TextField txtempresa;
    @FXML
    public TextField txtnumlocal;
    @FXML
    public TextField txtpersona;
    @FXML
    public TextField txtnumP;
    @FXML
    public TextField txtdireccion;
    @FXML
    public TextField txtcorreo;
    
    static Empresa e;
    String nombreE;
    
      @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void Agregar(){
        
        if(e==null){
            String nombre = txtempresa.getText();
        String nomPersona = txtpersona.getText();
        String numeroempresa = txtnumlocal.getText();
        String numerolocal = txtnumP.getText();
        String direccion = txtdireccion.getText();
        String correo = txtcorreo.getText();
       
        if(nombre.isEmpty() || numerolocal.isEmpty() || numeroempresa.isEmpty()){
            Mensaje("Llene los campos de nombre o algun numero telefonico");
            return;
        }
        String letra = nombre.substring(0,1);
        ASVArrayList numeros = new ASVArrayList();
        numeros.add(numeroempresa);
        numeros.add(numerolocal);
        Empresa Ep = new Empresa(nombre,nomPersona,numeros,letra,correo,direccion);
        //Contacto.agregarATodos(Ep);
        Ep.add(Ep);
        Mensaje("Contacto Agregado");
        txtempresa.clear();
        txtpersona.clear();
        txtnumlocal.clear();
        txtnumP.clear();
        txtdireccion.clear();
        txtcorreo.clear();
            
        }else{
            
            String nombre = txtempresa.getText();
            String nomPersona = txtpersona.getText();
            String numero = txtnumlocal.getText();
            String numero2 = txtnumP.getText();
            
            //String numero3 = txtnumero2.getText();
            String direccion = txtdireccion.getText();
            String correo = txtcorreo.getText();
            
            ASVArrayList numeros = new ASVArrayList();
            numeros.add(numero);
            numeros.add(numero2);
            
            String letra = nombre.substring(0,1);
            
            
            Empresa Ep = new Empresa(nombre,nomPersona,numeros,letra,correo,direccion);
            
            ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        
            for(Contacto cont:lcontactos){
                if(cont.getNombre().equals(nombreE)){
                    lcontactos.remove(cont);
                    Ep.add(Ep);
                }
            }


            Contacto.setContactos(lcontactos);
            Contacto.writeFile();
            
            e=null;
            

        }

    }
    
    
    @Override
     public void initialize(URL url, ResourceBundle rb) {
         
         if(e!=null){
             nombreE = e.getNombre();
             txtempresa.setText(e.getNombre());
             txtpersona.setText(e.getNomPersona());
             ASVArrayList numeros = e.getNumeros();
             
             txtnumlocal.setText((String) numeros.get(0));
             txtnumP.setText((String) numeros.get(1));
             txtdireccion.setText(e.getDireccion());
             txtcorreo.setText(e.getCorreo());

             
         }
 

     }
    
      public void Mensaje(String mensaje){
       Alert alerta = new Alert(Alert.AlertType.INFORMATION);
       alerta.setTitle("Aviso");
       alerta.setContentText(mensaje);
       alerta.showAndWait();
   }
    
    
    
    
}
