/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.lists;

import java.util.*;

/**
 *
 * @author Lee
 */
public class BinaryTree<T extends Comparable> {
    private BTNode root;
    
    public BTNode getRoot() { return this.root; }
    
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(BTNode root) {
        this.root = root;
    }
    
    public BinaryTree(T rootValue) {
        this.root = new BTNode(rootValue);
    }
    
    // Breadth-first, preorder print
    public void printBFS() {
        Queue<BTNode> q = new java.util.LinkedList<BTNode>();
        
        q.add(this.root);
        
        while (!q.isEmpty()) {
            BTNode n = q.remove();
            
            if (n != null) System.out.print(n + " ");
            
            if (n.getLeft() != null) {
                q.add(n.getLeft());
            }
            if (n.getRight() != null) {
                q.add(n.getRight());
            }         
        }
    }
}
