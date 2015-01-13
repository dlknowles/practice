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
    
    public void printLevels() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        
        Queue<BTNode> q = new java.util.LinkedList();
        
        q.add(root);
        int numLevels = GetHeight();
        int numSpaces = (int)(Math.pow(2, numLevels) / 2);
//        int currentLevel = 1;
        
        while (!q.isEmpty()) {
            q.add(null);
            numSpaces /= 2;
            
            for (int i = 0; i < numSpaces; ++i) System.out.print("-");
            
            while (q.peek() != null) {
                BTNode current = q.remove();
                System.out.print(current.toString() + " ");
                
                if (current.getLeft() != null) q.add(current.getLeft());
                if (current.getRight() != null) q.add(current.getRight());
            }
//            ++currentLevel;
            q.remove();
            System.out.println();
        }
    }
    
    public void DFTraversal(BTNode root) {
        if (root != null) {
            System.out.print(root.toString() + " ");
            
            DFTraversal(root.getLeft());
            DFTraversal(root.getRight());
        }
        else {
            System.out.println();
        }
    }
    
    public int GetNumNodes(BTNode root, int max) {
        int count = 0;
        
        if (root != null) {
            count += 1;
            
            count += GetNumNodes(root.getLeft(), count);
            count += GetNumNodes(root.getRight(), count);
        }
        
        return count;
    }
    
    public int GetHeight() {
        if (root == null) return 0;
        
        Queue<BTNode> q = new java.util.LinkedList();
        
        q.add(root);
        int height = 0;
        
        while (!q.isEmpty()) {
            q.add(null);
            
            while (q.peek() != null) {
                BTNode current = q.remove();
                
                if (current.getLeft() != null) q.add(current.getLeft());
                if (current.getRight() != null) q.add(current.getRight());
            }
            
            q.remove();
            ++height;
        }
        
        return height;
    }
}
