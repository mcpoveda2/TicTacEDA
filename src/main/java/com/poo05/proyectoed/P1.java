/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.poo05.proyectoed;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Contacto c1 = new Contacto("c",null,null,null,null,null);
       Contacto c2 = new Contacto("a",null,null,null,null,null);
       Contacto c3 = new Contacto("z",null,null,null,null,null);
       Contacto c4 = new Contacto("j",null,null,null,null,null);
       Contacto c5 = new Contacto("f",null,null,null,null,null);
       Contacto c6 = new Contacto("g",null,null,null,null,null);
       ASVLinkedList<Contacto> l1 = new ASVLinkedList<>();
       l1.add(c1);
       l1.add(c2);
       l1.add(c3);
       l1.add(c4);
       l1.add(c5);
       l1.add(c6);
       Collections.sort(l1);
       System.out.println(l1);
    }
}   

