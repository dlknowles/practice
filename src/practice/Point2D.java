/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * @author ctcrrmcidlk
 */
public class Point2D {
    
    private int x;
    private int y;
    
    public int getX() { return x; }
    public void setX(int value) { x = value; }
    public int getY() { return y; }
    public void setY(int value) { y = value; }
    
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
       return "(" + x + ", " + y + ")"; 
    }
    
    public static double getDistance(Point2D a, Point2D b) {
        // euclidian distance = square root of ( (x2 - x1)^2 + (y2 - y1)^2 )
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }
    
    public static ArrayList<Point2D> getClosest(Point2D comparisonPoint, Point2D[] ar, int numToAdd) {
        ArrayList<Point2D> closest = new ArrayList();
        TreeMap<Double, Point2D> set = new TreeMap();   // TreeMap (Red/Black tree) keeps hash map ordered
        
        for (Point2D p: ar) {
            double dist = Point2D.getDistance(p, comparisonPoint);
            //System.out.println("Adding point to TreeMap: " + p.toString() + " with distance of " + dist);
            set.put(dist, p);
        }
        
//        for (Map.Entry<Double, Point2D> entry: set.entrySet()) {
//            System.out.println("entry: key: " + entry.getKey() + "; value: " + entry.getValue().toString());
//        }
        
        int counter = 0;
        for (Map.Entry<Double, Point2D> entry: set.entrySet()) {
            if (counter++ == numToAdd) break;
            
            closest.add(entry.getValue());
        }
        return closest;
    }
    
}
