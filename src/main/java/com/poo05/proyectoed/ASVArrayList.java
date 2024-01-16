/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author USER
 * @param <E>
 */
public class ASVArrayList<E> implements List<E>, Iterable<E>,Serializable{
    E[] arreglo;
    private int indice;
    private Comparator<E> cmp;
    
    public ASVArrayList(Comparator<E> cmp){
        this.arreglo=(E[]) new Object[10];
        indice=0;
        this.cmp=cmp;
    }
    @Override
    public Iterator<E> iterator() {
        return new ASVIterator<>(this);
    }
    private class ASVIterator<E> implements Iterator<E>{
        private final E[] arregloit;
        private int indiceit;
        public ASVIterator(ASVArrayList ar){
            arregloit=(E[])arreglo;
            indiceit=0;
        }
        @Override
        public boolean hasNext() {
            return arregloit[indiceit]!=null;
        }

        @Override
        public E next() {
            E retorno = this.arregloit[indiceit];
            this.indiceit+=1;
            return retorno;
        }
    }
    public ASVArrayList(){
        this.arreglo=(E[]) new Object[10];
        indice=0;
    }
    
    @Override
    public int size() {
        return indice;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object o) {
        for(E e:this.arreglo){
            if(e==(E)o)
                return true;
        }
        return false;
    }

    @Override
    public E[] toArray() {
        E[] retorno = (E[]) new Object[indice];
        for (int i=0;i<this.indice;i++){
            retorno[i]=this.arreglo[i];
        }
        return retorno;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(E e) {
        add(this.indice,e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean st = false;
        for(int i=0;i<size();i++){
            if(get(i).equals((E)o)){
                remove(i);
                st=true;
            }
        }
        return st;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(size(),c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for(E e:c){
            add(index,e);
            index++;
        }
        return true;
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
        this.arreglo = (E[]) new Object[10];
        this.indice=0;
    }

    @Override
    public E get(int index) {
        if(index>this.indice-1||index<0){
            throw new IndexOutOfBoundsException("Indice no válido");
        }
        return arreglo[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void agrandarArreglo(){
        E[] nuevoarreglo =(E[]) new Object[this.arreglo.length*2];
        for(int i=0;i<this.arreglo.length;i++){
            nuevoarreglo[i]=this.arreglo[i];
        }
        this.arreglo=nuevoarreglo;
    }
    
    @Override
    public void add(int index, E element) {
        if(index>=0&&index<=size()){
          if(indice>=this.arreglo.length){
              agrandarArreglo();
          }
          for(int i=this.indice-1;i>=index;i--){
              this.arreglo[i+1]=this.arreglo[i];
          }
          this.arreglo[index]=element;
          this.indice++;
        }else{
            throw new IndexOutOfBoundsException("No valido");
        }
    }

    @Override
    public E remove(int index) {
        E eretorno=null;
        if(index>=0&&index<size()){
            eretorno=arreglo[index];
            for(int i=index;i<indice;i++){
                arreglo[i]=arreglo[i+1];
            }
            indice--;
        }else{
            throw new IndexOutOfBoundsException("No valido");
        }
        return eretorno;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size();i++){
            if(arreglo[i].equals((E)o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=size()-1;i>=0;i--){
            if(arreglo[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ASVArrayListIterator(this);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        ASVArrayList<E> retorno = new ASVArrayList<>();
        for (int i=fromIndex;i<=toIndex;i++){
            retorno.add(this.arreglo[i]);
        }
        return retorno;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(E e:this.arreglo){
            if(e!=null){
                sb.append(e);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    public E encontrarMenor(Comparator cmp){
        E emenor=null;
        for(E e:this){
            if(emenor==null)
                emenor=e;
            else if(cmp.compare(e, emenor)<0)
                emenor=e;
        }
        return emenor;
    }
    private class ASVArrayListIterator<E> implements ListIterator<E>{
        private final E[] arregloit;
        private int indice;
        private int tam;
        public ASVArrayListIterator(ASVArrayList<E> list){
            arregloit=list.arreglo;
            indice=-1;
            tam=list.size();
        }
        @Override
        public boolean hasNext() {
            return nextIndex()<tam;
        }

        @Override
        public E next() {
            E retorno = this.arregloit[nextIndex()];
            this.indice=nextIndex();
            return retorno;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex()>0;
        }

        @Override
        public E previous() {
            E retorno = this.arregloit[previousIndex()];
            this.indice=previousIndex();
            return retorno;
        }

        @Override
        public int nextIndex() {
            return indice+1;
        }

        @Override
        public int previousIndex() {
            return indice-1;
        }

        @Override
        public void remove() {
            if(indice>=0&&indice<size()){
            for(int i=indice;i<indice;i++){
                arregloit[i]=arregloit[i+1];
            }
            indice--;
            }else{
                throw new IndexOutOfBoundsException("No valido");
            }
        }

        @Override
        public void set(E e) {
            arregloit[indice]=e; 
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
}



