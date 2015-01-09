package collections.lists;

import utilities.Debug;

/**
 *
 * @author ctcrrmcidlk
 * @param <T>
 */
public class LinkedList<T extends Comparable> implements Cloneable {
    private Node<T> head;
    private int length;
    
    // constructors
    public LinkedList() {
        this.head = null;
    }
    
    public LinkedList(Node head) {
        this.head = head;
    }
    
    // properties
    public int size() { return this.length; }
    
    
    // methods
    public boolean isEmpty() { return this.length == 0; }
    
    public void insert(Node item) {       
        Debug.println("adding " + item.getData() + " to the linked list");
        Node<T> current = this.head;
        
        if (current == null) {
            this.head = item;
        }
        else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(item);
        }       
        
        ++this.length;
    }
    
    public void insertAt(Node newNode, int index) {
        Debug.println("Inserting " + newNode.getData() + " at index " + index);
        if (index > length - 1) {
            System.err.println("Index out of bounds. index: " + index);
            return;
        }
        
        Node current = this.head;
        int count = 0;
        
        while (current != null) {
            if (count == index) {
                Debug.println("current: " + current.getData());
                
                Node temp = current.getNext();
                current.setNext(newNode);
                
                if (temp != null) {
                    newNode.setNext(temp);
                }
                ++this.length;
                break;
            }
            current = current.getNext(); 
            ++count;
        }
    }
    
    public void removeAt(int index) {
        Debug.println("Removing from index " + index);
        if (index > length - 1) {
            System.err.println("Index out of bounds. index: " + index);
            return;
        }
        
        Node current = this.head;
        int count = 0;
        
        while (current != null) {
            if (count == index) {
                Debug.println("current: " + current.getData());
                
                Node temp = current.getNext();
                current = null;
                
                if (count > 0) {
                    getNode(count - 1).setNext(temp);
                }
                else {
                    this.head = temp;
                }
                --this.length;
                break;
            }
            current = current.getNext();    
            ++count;
        }
    }
    
    public void clearList() {
        Node current = this.head;
        
        while (current != null) {
            Node temp = current;
            current = current.getNext();
            temp = null;
        }
        
        this.length = 0;
    }
    
    public Comparable<T> getItem(int index) {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        
        Node current = this.head;
        int i = 0;
        while (current != null) {
            if (i++ == index) {
                return current.getData();
            }
            current = current.getNext();
        }
        
        return null;
    }
    
    public Node getNode(int index) {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        
        Node current = this.head;
        int i = 0;
        while (current != null) {
            if (i++ == index) {
                return current;
            }
            current = current.getNext();
        }
        
        return null;
    }
    
    public int seqSearch(T item) {
        Node current = this.head;
        int i = 0;
        
        while (current != null) {
            if (current.equals(item)) {
                return i;
            }
            ++i;
        }
        
        return -1;
    }
      
    public void print() {        
        Debug.println("printing linked list");
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        
        Node<T> current = this.head;
        
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        
        System.out.println();
    }
    
    public void sort() {
        if (this.length < 8) {
            insertionSort();
        }
        else {
            mergeSort();
        }
    }
    
    private void insertionSort() {
        
    }
    
    private void mergeSort() {
        
    }
    
    private void quickSort() {
        
    }
    
    // overrides
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
}
