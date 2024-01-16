/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo05.proyectoed;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author aleja
 * @param <E>
 */
public class ASVLinkedList<E> implements List<E>, Iterable<E>, Serializable{
    private ALinkedNode first;
    private ALinkedNode last;
    private int index;
    
    public ASVLinkedList(){
        this.first=null;
        this.last=null;
        this.index=0;
    }
    
    
    
    @Override
    public int size() {
        return index;
    }
    @Override
    public boolean isEmpty() {
        return index==0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        return new ASVLinkedListIterator(this);
    }

    @Override
    public Object[] toArray() {
        Object[] retorno = new Object[size()];
        ALinkedNode<E> it=this.first;
        for(int i=0;i<size();i++){
            retorno[i]=it.content;
            it=it.next;
        }
        return retorno;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(E e) {
        add(index,e);
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
        ALinkedNode<E> it = this.first;
        for(int i=0;i<index;i++){
            it=it.next;
        }
        return it.getContent();
    }

    @Override
    public E set(int index, E element) {
        ALinkedNode<E> it = this.first;
        for(int i=0;i<index;i++){
            it=it.next;
        }
        E antiguo = it.content;
        it.content=element;
        return antiguo;
    }

    @Override
    public void add(int index, E element) {
        ALinkedNode addNode = new ALinkedNode(element);
        if(isEmpty()){
            this.first=addNode;
            this.last=addNode;
        }else if(index==0){
            addNode.next=first;
            first=addNode;
        }else{
//            if(index==0){
//                addNode.next=first;
//                first=addNode;
//            }else if(index==size()){
//                addNode.previous=this.last;
//                last=addNode;
//            }else{
                ALinkedNode it = this.first;
                for(int i=0;i<index-1;i++){
                    it=it.next;
                }
                if(index!=this.index){
                    ALinkedNode save = it.next;
                    it.next=addNode;
                    addNode.next=save;
                }else{
                    it.next=addNode;
                    this.last=addNode;
                }
            }
            this.index++;
        
    }
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ASVLLIterator(this);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private class ALinkedNode<E>{
        ALinkedNode<E> next;
        private ALinkedNode previous;
        E content;
        public ALinkedNode(E content){
            this.content=content;
            next=null;
            previous=null;
        }
        public E getContent(){
            return this.content;
        }
    }
    private class ASVLinkedListIterator<E> implements Iterator<E>{
        private ALinkedNode<E> iter;
        public ASVLinkedListIterator(ASVLinkedList l1){
            this.iter=l1.first;
        }
        @Override
        public boolean hasNext() {
            return iter!=null;
        }

        @Override
        public E next() {
            E content = iter.getContent();
            iter=iter.next;
            return content;
        }
        
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(E element:this){
            sb.append(element);
            sb.append(" ");
        }
        return sb.toString();
    }
    private class ASVLLIterator<E> implements ListIterator<E>{
        private ASVLinkedList<E> iter;
        private int index = -1;
        public ASVLLIterator(ASVLinkedList<E> iter){
            this.iter=iter;
        }
        @Override
        public boolean hasNext() {
            return iter.get(nextIndex())!=null;
        }

        @Override
        public E next() {
            E retorno = this.iter.get(nextIndex());
            this.index=nextIndex();
            return retorno;
        }

        @Override
        public boolean hasPrevious() {
            return index>0;
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        }

        @Override
        public int nextIndex() {
            return index+1;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void set(E e) {
            iter.set(index, e);
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
}

