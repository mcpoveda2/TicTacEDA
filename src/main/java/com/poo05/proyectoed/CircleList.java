/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author micha
 */

public class CircleList<E> implements java.util.List<E>, Iterable<E>{
     Node primero;

    @Override
    public Iterator<E> iterator() {
        return new CircleListIterator<>(this);
    }
    public E encontrar(Comparator cmp){
        E encontrado = null;
        for (E elemento:this) {
            if (cmp.compare(elemento,encontrado)==0) {
                encontrado = elemento;
            }
        }
        return encontrado;
    }
    public CircleList<E> encontrarTodos(Comparator cmp){
        CircleList<E> encontrados = new CircleList<>();
        E encontrado = null;
        for (E elemento:this) {
            if (cmp.compare(elemento,encontrado)==0) {
                encontrado = elemento;
                encontrados.add(encontrado);
            }
        }
        return encontrados;
    }
    public E getFirst(){
        return (E) this.primero.contenido;
    }
    public E getLast(){
        return (E) this.primero.ante.contenido;
    }
    private class CLListIterator<E> implements ListIterator<E>{
        private Node<E> n1;
        CLListIterator(CircleList<E> c1){
          n1=primero.ante;  
        }
        @Override
        public boolean hasNext() {
//            if(n1==null){
//                n1=primero;
//                return true;
//            }else
                return n1.sig!=primero;
        }

        @Override
        public E next() {
            E elemento = n1.contenido;
            n1=n1.sig;
            return elemento;        
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void set(E e) {
            this.n1.contenido=e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    private class CircleListIterator<E> implements Iterator<E>{
        private Node<E> n1;
        CircleListIterator(CircleList cl) {
            n1=null;
	} 
        @Override
        public boolean hasNext() {
            if(n1==null){
                n1=primero;
                return true;
            }else
                return n1!=primero;
        }
        @Override
        public E next() {
            E elemento = n1.contenido;
            n1=n1.sig;
            return elemento;
        }
    }
    private class Node<E>{
        Node<E> sig;
        Node<E> ante;
        E contenido;
        public Node(E contenido){
            this.contenido=contenido;
            sig=null;
            ante=null;
        }
        public Node(){
            this.contenido=null;
            sig=null;
        }
    }
    public CircleList(){
        primero=null;
    }
    
    
    @Override
    public int size() {
        int i=0;
        Node<E> inicio = this.primero;
        if(this.isEmpty())
            return i;
        else{
            while(inicio.sig!=this.primero){
                i++;
                inicio=inicio.sig;
            }
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return (this.primero==null);
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        Object[] array1 = new Object[size()];
        for(int i=0;i<size();i++){
            array1[i]=this.get(i);
        }
        return array1;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(E e) {
        Node<E> n1 = new Node(e);
        if(this.isEmpty()){
           this.primero=n1;
        }else{
        Node<E> inicio = this.primero;
        while(inicio.sig!=this.primero&&inicio.sig!=null){
            inicio=inicio.sig;
        }
        inicio.sig=n1;
        n1.sig=this.primero;
        this.primero.ante=n1;
        n1.ante=inicio;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public E get(int index) {
        if(index>=size()||index<0||isEmpty())
            throw new IndexOutOfBoundsException(index);
        Node it=this.primero;
        for(int i=0;i<index;i++){
            it=it.sig;
        }
        return (E)it.contenido;
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void addLast(E e){
        add(e);
    }
    
    @Override
    public void add(int index, E e) {
        if(index<=0||index>size())
            throw new RuntimeException("Invalid Index");
        Node nuevonodo = new Node(e);
        Node it=primero;
        for(int i=0;i<index-1;i++){
            it=it.sig;
        }
        Node continuacion = it.sig;
        it.sig=nuevonodo;
        nuevonodo.sig=continuacion;
    }

    public E removeLast(){
        return remove(size()-1);
    }
    
    @Override
    public E remove(int index) {
        if(index<=0||index>size())
            throw new RuntimeException("Invalid Index");
        Node it=primero;
        Node it2=null;
        for(int i=0;i<index;i++){
            it2=it;
            it=it.sig;
        }
        it2.sig=it.sig;
        it.sig=null;
        return (E)it.contenido;
    }
    public void invertir(){
        
    }
    public void recorrerInvertido(){
        CircleListIterator<E> c1 = new CircleListIterator(this);
        while(c1.hasNext()){
            System.out.println(c1.next());
        }
        System.out.println(get(0));
    }
    
    @Override
    public int indexOf(Object o) {
        for(int i = 0;i<size();i++){
            if(get(i)==(E)o)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        return new CLListIterator<>(this);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
    @Override
    public String toString(){
        for(E e:this){
            System.out.println(e);
        }
        return "";
    }
}

