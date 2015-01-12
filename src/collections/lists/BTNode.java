/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.lists;

/**
 *
 * @author Lee
 */
public class BTNode <T extends Comparable> {
    BTNode<T> left;
    BTNode<T> right;
    T data;    
    
    public BTNode(T data) {
        this.data = data;
    }
    
    public BTNode(T data, BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public BTNode getLeft() { return this.left; }
    public void setLeft(BTNode value) { this.left = value; }
    public BTNode getRight() { return this.right; }
    public void setRight(BTNode value) { this.right = value; }
    
    public String toString() {
        return this.data.toString();
    }
}
