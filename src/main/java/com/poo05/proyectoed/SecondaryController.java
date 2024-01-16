package com.poo05.proyectoed;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SecondaryController implements Initializable{
    
    ASVArrayList<ASVLinkedList> listaContactos = new ASVArrayList<>();
    
    @FXML
    private TextField searchBar;
    
    @FXML
    private Button searchButton;

    @FXML
    private VBox vboxlista = new VBox();
      
    @FXML
    private ScrollPane spane;
   

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void switchToAgregar() throws IOException{
        App.setRoot("elegircontacto");
    }
    

    
     @FXML
    private void datosPersona()throws IOException{
        App.setRoot("datoPersona");
    
    }
    
    private void irDatosPersona(Contacto P){
        
        DatoPersona.c = P;
        
        try{
            datosPersona();       
        }catch(IOException e){
            
        }
       }
    
    
    private void irDatosEmpresa(Empresa E){
        DatoEmpresa.e = E;
        try{
            datosEmpresa();       
        }catch(IOException e){
            
        }
       }
    
    @FXML
    private void datosEmpresa()throws IOException{
        App.setRoot("datoEmpresa");
    
    }
    
     @FXML
    private void Grupos(){
        
    
    }
    
     @FXML
    private void MostrarTodos(){
        if(Contacto.todosContactos.isEmpty())
            Contacto.todosContactos = Contacto.readFile();
        CrearLista(Contacto.todosContactos);
    }
    
     @FXML
    private void MostrarPersonas(){
        ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        Contacto.todosContactos = Contacto.readFile();
        ASVArrayList <Contacto> personas = new ASVArrayList<>();
        for(Contacto c: lcontactos){
            if(!(c instanceof Empresa)){
                personas.add(c);
            }
        }
        CrearLista(personas);
    
    }
    
     @FXML
    private void MostrarEmpresas(){
        ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        Contacto.todosContactos = Contacto.readFile();
        
        ASVArrayList <Contacto> empresas = new ASVArrayList<>();
        
        for(Contacto c: lcontactos){
            if(c instanceof Empresa){
                empresas.add(c);
            }
        }
        CrearLista(empresas);
   
    }
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Contacto.Ordenar();
        MostrarTodos();
        //agregarALinkedList(lcontactos);
        //CrearLista2();
        //CrearLista(lcontactos);
    }
    
    @FXML
    void search(ActionEvent event){
        
        vboxlista.getChildren().clear();
        
        List<String> nombres = searchList(searchBar.getText());
        
        for(String nombre:nombres){
            System.out.println(nombre);
        }
        
        ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        ASVArrayList<Contacto> finalContacto = new ASVArrayList<>();
        for(String ola:nombres){
            for(Contacto contacto:lcontactos){
                if(ola.toLowerCase().equals(contacto.getNombre().toLowerCase())){ 
                    finalContacto.add(contacto);
                }
            }
        }
        
        for(Contacto ola:finalContacto){
            System.out.println(ola.getNombre());
        }
            
       CrearLista(finalContacto);
  

    }
    

    
    private List<String> searchList(String searchWords){

        
        ASVArrayList<Contacto> lcontactos = Contacto.readFile();
        
        List<String> palabrasBusquedaArray = Arrays.asList(searchWords.trim().split(" "));//Separa las palabras a buscar
        List<String> contactos = new ASVArrayList<>();
        
        for(Contacto cont:lcontactos){
            contactos.add(cont.getNombre());//Agrega los nombres de los usuarios a comparar
        }
        
        
        return contactos.stream().filter(input ->{ //stream recorre los valores de contacto y los asigna al input 
            return palabrasBusquedaArray.stream().allMatch(word -> 
                    //compara los nombre del contacto con la palabra a buscar
            input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());

        
        //return contactos;
        
      
}
    
    
    private void CrearLista( ASVArrayList<Contacto>  contactos){
        vboxlista.getChildren().clear();
        Font font = Font.font("Arial", FontWeight.BOLD, 14);
        
        HBox filaC = new HBox();
             filaC.setPrefWidth(465);
             filaC.setPrefHeight(45);
             
             Label nombreC = new Label("Nombre");
             nombreC.setPrefWidth(180);
             nombreC.setPrefHeight(45);
             nombreC.setFont(font);
             
             Label celularC = new Label("Celular" );
             celularC.setPrefWidth(110);
             celularC.setPrefHeight(45);
             celularC.setFont(font);
             
             Label correoC = new Label("Correo");
             correoC.setPrefWidth(175);
             correoC.setPrefHeight(45);
             correoC.setFont(font);
         
             filaC.getChildren().add(nombreC);
             filaC.getChildren().add(celularC);
             filaC.getChildren().add(correoC);
             vboxlista.getChildren().add(filaC);  
        
        for(Contacto c:contactos){
            
             HBox fila = new HBox();
             fila.setPrefWidth(465);
             fila.setPrefHeight(45);
             
             Label nombre = new Label(c.getNombre() );
             nombre.setPrefWidth(180);
             nombre.setPrefHeight(45);
             
             System.out.println(c.getNombre());
             
             Label celular = new Label(c.getNumeros().get(0) );
             celular.setPrefWidth(110);
             celular.setPrefHeight(45);
             
             //System.out.println(c.getNumeros().get(1));
             
             Label correo = new Label(c.getCorreo());
             correo.setPrefWidth(175);
             correo.setPrefHeight(45);
         
             fila.getChildren().add(nombre);
             fila.getChildren().add(celular);
             fila.getChildren().add(correo);
             
             if(c instanceof Empresa){  
              fila.setOnMouseClicked(event -> irDatosEmpresa((Empresa) c));
               }else{
                 fila.setOnMouseClicked(event -> irDatosPersona((Contacto) c));
             }
             
             vboxlista.getChildren().add(fila);  
    }
        
    }
    
   
    
    
    
    
    
}