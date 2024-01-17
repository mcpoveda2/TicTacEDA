/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import static ec.edu.espol.tictactoegame.TicTacToeGame.turnos;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class TicTacToeMulti extends TicTacToeGame{
    public TicTacToeMulti(){
        turnos=0;
        tablero = new Tablero();
    }
    @Override
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
    @Override
    public boolean verifyDraw(){
        return turnos==9;
    }
    public void turnoUsuario1(int fila, int columna){
        tablero.cambiarCelda(fila, columna, "O");
        turnos+=1;
        if(verifyWin(tablero.searchByCoord(fila,columna))){
            playable=false;
            Ganador="USUARIO 1 (MULTIPLAYER MODE)";
            fecha = LocalDate.now();
            System.out.println("GANÓ USUARIO 1");
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
    public void turnoUsuario2(int fila, int columna){
        tablero.cambiarCelda(fila, columna, "X");
        turnos+=1;
        if(verifyWin(tablero.searchByCoord(fila,columna))){
            playable=false;
            Ganador="USUARIO 2 (MULTIPLAYER MODE)";
            fecha = LocalDate.now();
            System.out.println("GANÓ USUARIO 2");
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
}
