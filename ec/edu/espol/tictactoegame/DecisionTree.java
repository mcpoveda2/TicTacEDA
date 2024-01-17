/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tictactoegame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class DecisionTree<E>  implements Serializable{
    DecisionTreeNode<E> root;
    ArrayList<DecisionTree> children;
    
    public DecisionTree(int valor){
        this.root=new DecisionTreeNode(null,valor);
        this.children=new ArrayList<>();
    }
    
    public DecisionTree(E contenido,int valor){
        this.root=new DecisionTreeNode(contenido,valor);
        this.children=new ArrayList<>();
    }
    
    public class DecisionTreeNode<E> implements Serializable{
        int valor;
        E contenido;
        public DecisionTreeNode(E contenido,int valor){
            this.contenido=contenido;
            this.valor=valor;
        }
    }
}

