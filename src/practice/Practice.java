/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import utilities.*;
import collections.lists.*;

/**
 *
 * @author ctcrrmcidlk
 */
public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TestUnorderedArrayList();
//        TestOrderedArrayList();
        TestLinkedList();
    }
    
    private static void TestLinkedList() {
        LinkedList<Integer> alist = new LinkedList();
        alist.insert(new Node(1));
        alist.insert(new Node(5));
        alist.insert(new Node(8));        
        alist.print();
        
        alist.insertAt(new Node(2), 1);        
        alist.print();
        
        alist.removeAt(1);        
        alist.print();
        
        System.out.println("item at 1: " + alist.getItem(1));
        
        alist.clearList();
        alist.print();
        
    }
        
    private static void TestOrderedArrayList() {
        OrderedArrayList<Integer> alist = new OrderedArrayList();
        
        for (int i = 1; i < 100; ++i) {
            int newItem = (int)Math.round(Math.random() * 255.0);
            alist.insert(newItem);
        }
        alist.print();
        
        alist.removeDuplicates();
        alist.print();
                
        alist.print();        
        System.out.println("looking for 90. found it at " + alist.binarySearch(90));
        
        int searchItem = alist.getItem(44);
        alist.print();        
        System.out.println("looking for " + searchItem + ". found it at " + alist.binarySearch(searchItem));
        
//        alist.insert(1);
//        alist.insert(4);
//        alist.insert(3);
//        alist.insert(4);
//        alist.insert(5);
//        alist.insert(6);        
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.insert(2);        
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.remove(4);        
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.remove(1);        
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.remove(6);        
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.removeAt(0);        
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.removeAt(2);        
//        Debug.println("printing alist...");
//        alist.print();
        
    }
    
    private static void TestUnorderedArrayList() {
        UnorderedArrayList<Integer> alist = new UnorderedArrayList();
        
        alist.insert(1);
        alist.insert(2);
        alist.insert(3);
        alist.insert(4);
        alist.insert(5);
        alist.insert(6);        
        Debug.println("printing alist...");
        alist.print();
        
        alist.removeAt(4);
        Debug.println("printing alist...");
        alist.print();
        
        alist.insert(20);
        Debug.println("printing alist...");
        alist.print();
        
        alist.replaceAt(5, 5);
        Debug.println("printing alist...");
        alist.print();
        
//        alist.clearList();
//        Debug.println("printing alist...");
//        alist.print();
        
        alist.insertAt(20, 4);
        Debug.print("printing alist...");
        alist.print();
        
        UnorderedArrayList<Integer> blist;
        
        blist = (UnorderedArrayList<Integer>) alist.clone();
        Debug.print("printing blist...");
        blist.print();
        blist.insert(Integer.SIZE);
        Debug.print("printing alist...");
        alist.print();
        Debug.print("printing blist...");
        blist.print();
    }
}
