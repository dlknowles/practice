/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.lists;

import utilities.*;
import exceptions.ListFullException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ctcrrmcidlk
 * @param <T>
 */
public abstract class ArrayListClass<T extends Comparable> implements Cloneable {
    // private fields
    protected int length;
    protected int maxSize;
    protected T[] list;
        
    // constructors
    public ArrayListClass() {
        this.maxSize = 100; // start out with space for 100 objects.
        this.length = 0;
        this.list = (T[]) new Comparable[this.maxSize];
        Debug.println("Created new ArrayListClass. length: " + this.length + "; maxSize: " + this.maxSize);
    }
    
    public ArrayListClass(int size) {
        this.maxSize = size;
        this.length = 0;
        this.list = (T[]) new Comparable[this.maxSize];
        Debug.println("Created new ArrayListClass. length: " + this.length + "; maxSize: " + this.maxSize);
    }
    
    // public methods
    public boolean isEmpty() { return this.length == 0; }
    
    public boolean isFull() { return this.length == this.maxSize; }
    
    public int size() { return this.length; }
    
    public int maxSize() { return this.maxSize; }
    
    public void remove(T item) {
        removeAt(seqSearch(item));
    }
    
    public void removeAt(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException(index);
        
        for (int i = index; i < length; ++i) {
            if (i < this.maxSize - 1) {
                this.list[i] = this.list[i + 1];
            }
        }
        
        this.list[this.length-- - 1] = null;
    }
    
    public boolean isItemAtEqual(int index, T item) throws ArrayIndexOutOfBoundsException {
        if (index >= this.length) throw new ArrayIndexOutOfBoundsException(index + " given. Length is " + this.length);
        
        return (this.list[index].equals(item));
    }
    
    public T getItem(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= this.length) throw new ArrayIndexOutOfBoundsException(index);
        
        return this.list[index];
    }
    
    public void clearList() {
        for (int i = 0; i < this.length; ++i) {
            this.list[i] = null;
        }
        this.length = 0;
    }
    
    public void print() {
        Debug.println("length: " + this.length + "; maxSize: " + this.maxSize);
        for (T elem: this.list) {
            // only print nulls if debug == true
            if (elem == null) {
                Debug.print("null ");
            }
            else {
                System.out.print(elem + " ");
            }
        }
        System.out.println();
    }
    
    public int seqSearch(T searchItem) {
        int index = -1;
        
        for(int i = 0; i < this.length; ++i) {
            if (this.list[i].equals(searchItem)) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    // protected methods    
    protected void replaceAt(T item, int index) throws ArrayIndexOutOfBoundsException {
        if (index >= this.length) throw new ArrayIndexOutOfBoundsException(index);
                
        this.list[index] = item;
    }
    
    protected void insertAt(T item, int index) throws ArrayIndexOutOfBoundsException, ListFullException {
        if (index > this.maxSize - 1 || index > this.length - 1) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        if (this.length >= this.maxSize) {
            throw new exceptions.ListFullException("Cannot insert an item at index " + index);
        }
                
        for (int i = length - 1; i >= index; --i) {
            this.list[i + 1] = this.list[i];
        }        
        this.list[index] = item;
        ++length;
    }
    
    protected void insertEnd(T item) throws ListFullException {
        if (this.length < this.maxSize) {
            this.list[this.length++] = item;
        }
        else {
            throw new exceptions.ListFullException("Cannot insert any more items.");
            //throw new ArrayIndexOutOfBoundsException("The list is full. length: " + this.length + "; maxSize: " + this.maxSize);
        }
    }
    
    
    // override methods
    @Override
    public Object clone() { 
        Object newObj = null;
        try {
            newObj = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.err.println(ex.getMessage());
        }
        return newObj;
    }
    
    // private functions
    
}
