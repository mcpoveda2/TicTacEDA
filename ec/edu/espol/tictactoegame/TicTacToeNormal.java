/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tictactoegame;

/**
 *
 * @author USER
 */
public class TicTacToeNormal extends TicTacToeGame{
    @Override
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
                    ia.children.add(new DecisionTree(c1,-1+intPriorityWin(c1)+intPriorityLose(c1)));
                    //System.out.println("ARBOL CON PESO: "+-1+intPriorityWin(c1)+intPriorityLose(c1)+" "+Celda.coordenadas(c1));
            }}
        }
    }
}
