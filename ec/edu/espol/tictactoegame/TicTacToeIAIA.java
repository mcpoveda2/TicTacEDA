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
public class TicTacToeIAIA extends TicTacToeGame{
    public void turnoUsuario(){
        if(playable){
            updateTree();
            ia=searchBestWay();
            Celda c1 = (Celda)ia.root.contenido;
            tablero.cambiarCelda(c1.fila, c1.columna, "O");
            turnos+=1;
            if(verifyWin(c1)){
                Ganador="IA";
                playable=false;
            }else if(verifyDraw()){
                playable=false;
                Ganador="EMPATE";
            }
        }
    }
}
