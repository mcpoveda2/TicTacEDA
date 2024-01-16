/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author micha
 */
public class Contacto implements Serializable, Comparable<Contacto>{
    private static final long serialVersionUID = 1523532431;
    private String nombre;
    private String apellido;
    private ASVArrayList<String> numeros = new ASVArrayList<>();
    private String Correo;
    private String PriLetra;
    private String Direccion;
    public static ASVArrayList<Contacto> todosContactos = new ASVArrayList<>();
    
    private static ASVLinkedList<Contacto> contactos = new ASVLinkedList<>();
    
    
    public static void agregarATodos(Contacto c1){
        todosContactos.add(c1);
    }
    
    
    public Contacto(String nombre, String apellido,ASVArrayList<String> numeros, String Correo, String PriLetra,String Direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeros = numeros;
        this.Correo = Correo;
        this.PriLetra = PriLetra;
        this.Direccion = Direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public ASVArrayList<String> getNumeros() {
        return numeros;
    }

  

    public ASVLinkedList<Contacto> getContactos() {
        Ordenar();
        return contactos;
    }

    public void setContactos(ASVLinkedList<Contacto> contactos) {
        
        this.contactos = contactos;
        Ordenar();
    }
    
    public static void setContactos(ASVArrayList<Contacto> contactos){
        Contacto.todosContactos = contactos;
        Ordenar();
    }

    public String getNumero() {
        String finalNumeros = "";
        for (String numero:numeros){
            finalNumeros+=numero;
            finalNumeros+="-";
        }
        return finalNumeros;
        
    }

    public String getCorreo() {
        return Correo;
    }

    public String getPriLetra() {
        return PriLetra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeros(ASVArrayList numeros) {
        this.numeros = numeros;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setPriLetra(String PriLetra) {
        this.PriLetra = PriLetra;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public void add(Contacto contacto){
        imprimir();
        writeFile(contacto);
    }
    
    public void imprimir(){
        
        for(Contacto contacto:todosContactos){
            System.out.println(contacto.nombre+contacto.apellido);
        
        }
    }
    
    
    public int hashCode() {
        return Objects.hash(nombre,apellido);
    }
    
    public void writeFile(Contacto c1){
        String archivo = "src/main/java/com/poo05/proyectoed/datos.txt";
        agregarATodos(c1);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))){
            oos.writeObject(todosContactos);
            Ordenar();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     public static void writeFile(){
        String archivo = "src/main/java/com/poo05/proyectoed/datos.txt";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))){
            oos.writeObject(todosContactos);
            Ordenar();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
    public static CircleList<Contacto> toLinkedList(){
        CircleList<Contacto> LLcontactos = new CircleList<>();
        
        for(Contacto cont:todosContactos){
            LLcontactos.add(cont);
        }
        return LLcontactos;
    }
    
    
    
    
    public static ASVArrayList<Contacto> readFile(){
        String archivo = "src/main/java/com/poo05/proyectoed/datos.txt";
        ASVArrayList<Contacto> listaretorno = new ASVArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
            listaretorno = (ASVArrayList<Contacto>)ois.readObject();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException c){
        }
        //ORDENA LA LISTA QUE LEE
        Collections.sort(listaretorno);
        return listaretorno;
    }
    
    public static void Ordenar(){
        Collections.sort(todosContactos); 
        Collections.sort(contactos); 
    }

    @Override
    public int compareTo(Contacto o) {
        return this.nombre.compareTo(o.nombre);
    }
    
    static class sortByName implements Comparator<Contacto>{

        @Override
        public int compare(Contacto o1, Contacto o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }

    }

    
    public String estructurarFile(Contacto contacto){
        String estructurado = contacto.getNombre()+"/"+contacto.getNumeros()+"/"+contacto.getCorreo()+"/"+contacto.getPriLetra()+"/"+contacto.getDireccion();

        return estructurado;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
