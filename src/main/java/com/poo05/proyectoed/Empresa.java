/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.Serializable;

/**
 *
 * @author USERº
 */
public class Empresa extends Contacto implements Serializable{
    private String nomPersona;
    
     public Empresa(String nombre,String nomPersona, ASVArrayList numeros ,String PriLetra,String correo,String direccion){
        super(nombre,nomPersona,numeros,correo,PriLetra,direccion);
        //this.nomPersona = nomPersona;
        //this.numeroLocal=numeroLocal;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }
     
     
     
     

}
