/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import utilities.*;
import collections.lists.*;
import java.util.ArrayList;

/**
 *
 * @author ctcrrmcidlk
 */
public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestMissing();
//        TestPoint2D();
//        int[] nums = {8, 8, 8, 9, 9, 11, 15, 16, 16, 16};
//        int[] counts = NumberHelper.getCounts(nums);
//        
//        for (int i = 0; i < counts.length; ++i) {
//            if (counts[i] > 0) {
//                System.out.println(i + ": " + counts[i]);
//            }
//        }
//        TestBinTree();
//        TestUnorderedArrayList();
//        TestOrderedArrayList();
//        TestLinkedList();
        
//        TestChop();
    }
    
    private static void TestMissing() {
        int ar[] = {1, 2, 4, 6, 7, 8, 9};
        int missing[] = NumberHelper.getMissingBruteForce(9, ar);
        
        for (int i: missing) {
            System.out.print(i + " ");
        }
        
        System.out.println();
    }
    
    private static void TestPoint2D() {
        Point2D[] points = {
            new Point2D(-2, -4),
            new Point2D(0, 0),
            new Point2D(10, 15),
            new Point2D(5, 6),
            new Point2D(7, 8),
            new Point2D(-10, -30)
        };
        
        ArrayList<Point2D> closest = Point2D.getClosest(new Point2D(5, 5), points, 2);
        
        for (Point2D p: closest) {
            System.out.print(p.toString() + " ");
        }
        System.out.println();
    }
    
    private static void TestBinTree() {
        BTNode<Integer> root = new BTNode(1);
        
        root.setLeft(new BTNode<Integer>(2));
        root.setRight(new BTNode<Integer>(3));
        
        root.getLeft().setLeft(new BTNode<Integer>(4));
        root.getLeft().setRight(new BTNode<Integer>(5));
        
        root.getRight().setLeft(new BTNode<Integer>(6));
        root.getRight().setRight(new BTNode<Integer>(7));
        
//        root.getLeft().getLeft().setLeft(new BTNode<Integer>(8));
        
        
        BinaryTree<Integer> t = new BinaryTree(root);
        
        t.printLevels();
        
//        t.printBFS();
        
//        t.DFTraversal(root);
//        System.out.println("Height: " + t.GetHeight());
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
        
        alist.insert(6);
        alist.insert(2);
        alist.insert(3);
        alist.insert(4);
        alist.insert(5);
        alist.insert(1);        
        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.removeAt(4);
//        Debug.println("printing alist...");
        alist.print();
        
        alist.sort();
        alist.print();
        
//        alist.insert(20);
//        Debug.println("printing alist...");
//        alist.print();
//        
//        alist.replaceAt(5, 5);
//        Debug.println("printing alist...");
//        alist.print();
//        
////        alist.clearList();
////        Debug.println("printing alist...");
////        alist.print();
//        
//        alist.insertAt(20, 4);
//        Debug.print("printing alist...");
//        alist.print();
//        
//        UnorderedArrayList<Integer> blist;
//        
//        blist = (UnorderedArrayList<Integer>) alist.clone();
//        Debug.print("printing blist...");
//        blist.print();
//        blist.insert(Integer.SIZE);
//        Debug.print("printing alist...");
//        alist.print();
//        Debug.print("printing blist...");
//        blist.print();
    }
   
    static void TestChop() {
        int[] ar = {1, 3, 5};
        
        System.out.println("testing iterative binary search");
        System.out.println(BinaryChop.iterChop(0, ar));
        System.out.println(BinaryChop.iterChop(1, ar));
        System.out.println(BinaryChop.iterChop(3, ar));
        System.out.println(BinaryChop.iterChop(5, ar));
        System.out.println(BinaryChop.iterChop(6, ar));
        
        System.out.println("\ntesting recursive binary search");        
        System.out.println(BinaryChop.recChop(0, ar, 0, ar.length - 1));
        System.out.println(BinaryChop.recChop(1, ar, 0, ar.length - 1));
        System.out.println(BinaryChop.recChop(3, ar, 0, ar.length - 1));
        System.out.println(BinaryChop.recChop(5, ar, 0, ar.length - 1));
        System.out.println(BinaryChop.recChop(6, ar, 0, ar.length - 1));
    }
        
    
}
