/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USERº
 */
public class PerfilUsuario implements Serializable{
    
    private String usuario;
    private ArrayList<TicTacToeGame> partidas;

    public PerfilUsuario(String usuario, ArrayList<TicTacToeGame> partidas) {
        this.usuario = usuario;
        this.partidas = partidas;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public ArrayList<TicTacToeGame> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<TicTacToeGame> partidas) {
        this.partidas = partidas;
    }
    
    public void anadirPartida(TicTacToeGame t){
        partidas.add(t);
        System.out.println("Agregador Correctamente");
        
    }
    
     
    public static void guardarPerfil(PerfilUsuario perfil) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(perfil.getUsuario()+".txt"))) {
            oos.writeObject(perfil.getPartidas());
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
      public static ArrayList<TicTacToeGame> cargarPartidas() {
        ArrayList<TicTacToeGame> p = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PrimaryController.usuario+".txt"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                p = (ArrayList<TicTacToeGame>) obj;
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nuevo Perfil creado");
            return p;
        }
        return p;
    }
    
       
    }
    
    
  
