/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.lists;

/**
 *
 * @author ctcrrmcidlk
 * @param <T>
 */
public class Node<T extends Comparable> {
    private T data;
    private Node next;
    
    public Node(T data) {
        this.data = data;
    }
    
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    // properties
    public T getData() { return this.data; }
    public void setData(T value) { this.data = value; }
    public Node getNext() { return this.next; }
    public void setNext(Node value) { this.next = value; }
    
    
    
    // overrides
    @Override
    public String toString() {
        return data.toString();
    }
}
