/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class TicTacToeGame implements Serializable{
    
    
    Tablero tablero;
    DecisionTree<Celda> ia;
    boolean playable = true;
    public static int turnos = 0;
    
    LocalDate fecha;
     String Ganador ="";
    
    
    public TicTacToeGame(){
        turnos=0;
        tablero = new Tablero();
        ia = new DecisionTree(-3);
    }
    
    public void updateTree(){
        for(Celda c1:tablero.celdas){
            if(c1.contenido==null){
                if(c1.fila==2&&c1.columna==2){
                    ia.children.add(new DecisionTree(c1,1+intPriorityWin(c1)+intPriorityLose(c1)));
                    //System.out.println("ARBOL CON PESO: "+1+intPriorityWin(c1)+intPriorityLose(c1)+" "+Celda.coordenadas(c1));
                }
                else if((c1.fila==1&&c1.columna==1)||(c1.fila==1&&c1.columna==3)||(c1.fila==3&&c1.columna==1)||(c1.fila==3&&c1.columna==3)){
                    ia.children.add(new DecisionTree(c1,0+intPriorityWin(c1)+intPriorityLose(c1)));
                    //System.out.println("ARBOL CON PESO: "+0+intPriorityWin(c1)+intPriorityLose(c1)+" "+Celda.coordenadas(c1));
                }
                else{
                    ia.children.add(new DecisionTree(c1,-1+intPriorityWin(c1)+intPriorityLose(c1)+verifyHack()));
                    //System.out.println("ARBOL CON PESO: "+-1+intPriorityWin(c1)+intPriorityLose(c1)+" "+Celda.coordenadas(c1));
            }}
        }
    }
    public int intPriorityWin(Celda c3){
        Celda cverificar = new Celda(c3.fila,c3.columna,"X");
        if(verifyWin(cverificar))
            return 30;
        return 0;
    }
    public int verifyHack(){
        if(turnos==3){
            if(tablero.searchByCoord(3, 1).contenido!=null&&tablero.searchByCoord(1, 3).contenido!=null){
                if(tablero.searchByCoord(1, 3).contenido.equals("O")&&tablero.searchByCoord(3, 1).contenido.equals("O"))
                    return 20;
            }else if(tablero.searchByCoord(1, 1).contenido !=null&&tablero.searchByCoord(3, 3).contenido!=null){
                if(tablero.searchByCoord(3, 3).contenido.equals("O")&&tablero.searchByCoord(1, 1).contenido.equals("O"))
                    return 20;
            }
        }
        return 0;
    }
    public boolean verifyWin(Celda c3){
        for(Celda c1:tablero.celdas){
            for(Celda c2:tablero.celdas){
                if(c1!=c2&&c1!=c3&&c3!=c2){
                    if(Tablero.verificar3EnRaya(c1, c2, c3)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public int intPriorityLose(Celda c3){
        Celda cverificar = new Celda(c3.fila,c3.columna,"O");
        if(verifyWin(cverificar))
            return 20;
        return 0;
    }
    public DecisionTree searchBestWay(){
        DecisionTree dreturn = new DecisionTree(-15);
        for(DecisionTree d1:ia.children){
            if(d1.root.valor>dreturn.root.valor)
                dreturn=d1;
        }
        return dreturn;
    }
    public boolean verifyDraw(){
        return turnos==9;
    }
    public void turnoUsuario(int fila, int columna){
        tablero.cambiarCelda(fila, columna, "O");
        turnos+=1;
        if(verifyWin(tablero.searchByCoord(fila,columna))){
            playable=false;
            Ganador="USUARIO";
            fecha = LocalDate.now();
            System.out.println("GANÓ USUARIO");
            SecondaryController.PUsuario.anadirPartida(this);
            PerfilUsuario.guardarPerfil(SecondaryController.PUsuario);
        }else if(verifyDraw()){
            playable=false;
            Ganador="EMPATE";
            fecha = LocalDate.now();
            System.out.println("EMPATE");
            SecondaryController.PUsuario.anadirPartida(this);
            PerfilUsuario.guardarPerfil(SecondaryController.PUsuario);
        }
    }
    
    public void turnoIA(){
        if(playable){
            updateTree();
            ia=searchBestWay();
            Celda c1 = (Celda)ia.root.contenido;
            tablero.cambiarCelda(c1.fila, c1.columna, "X");
            turnos+=1;
            if(verifyWin(c1)){
                Ganador="IA";
                fecha = LocalDate.now();
                System.out.println("GANÓ IA");
                SecondaryController.PUsuario.anadirPartida(this);
                PerfilUsuario.guardarPerfil(SecondaryController.PUsuario);
                playable=false;
            }else if(verifyDraw()){
                playable=false;
                Ganador="EMPATE";
                fecha = LocalDate.now();
                SecondaryController.PUsuario.anadirPartida(this);
                System.out.println(this.Ganador);
                PerfilUsuario.guardarPerfil(SecondaryController.PUsuario);
                System.out.println("EMPATE");
            }
        }
    }

    public String getGanador() {
        return Ganador;
    }

    public void setGanador(String Ganador) {
        this.Ganador = Ganador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
        
    
}

