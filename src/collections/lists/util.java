/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ctcrrmcidlk
 */
public class util {
    public static void MergeSort(int[] ar) {
        if (ar.length < 2) {
            return;
        }
        
        int[] aux = new int[ar.length];
        
        MergeSort(ar, aux, 0, ar.length - 1);
    }
    
    private static void MergeSort(int[] ar, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        
        int mid = lo + (hi - lo) / 2; // doing it this way to avoid integer overflow errors
        MergeSort(ar, aux, lo, mid);
        MergeSort(ar, aux, mid + 1, hi);
        Merge(ar, aux, lo, mid, hi);
    }
    
    private static void Merge(int[] ar, int[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        
        for (int k = lo; k <= hi; ++k) {
            if (i > mid) {
                aux[k] = ar[j++];
            } else if (j > hi) {
                aux[k] = ar[i++];
            } else if (ar[i] <= ar[j]) {
                aux[k] = ar[i++];
            } else {
                aux[k] = ar[j++];
            }
        }
        
        for (int k = lo; k <= hi; ++k) {
            ar[k] = aux[k];
        }
    }
    
    public static long CountInversions(int[] ar) {
        if (ar.length < 2) return 0;
        
        int[] aux = new int[ar.length];
        int[] ar2 = new int[ar.length];
        
        for (int i = 0; i < ar.length; ++i) {       // O(n)
            ar2[i] = ar[i];
        }
        
        return CountInversions(ar2, aux, 0, ar2.length - 1);
    }
    
    private static long CountInversions(int[] ar, int[] aux, int lo, int hi) {
        if (hi <= lo) return 0;
        
        int mid = (lo + hi) / 2;
        long x = CountInversions(ar, aux, lo, mid);
        long y = CountInversions(ar, aux, mid + 1, hi);
        long z = CountSplitInversions(ar, aux, lo, mid, hi);
        
        return x + y + z;
    }
    
    private static long CountSplitInversions(int[] ar, int[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        long count = 0;
        
        for (int k = lo; k <= hi; ++k) {
            if (i > mid) {
                aux[k] = ar[j++];
            } else if (j > hi) {
                aux[k] = ar[i++];
            } else if (ar[i] <= ar[j]) {
                aux[k] = ar[i++];
            } else {
//                System.out.println("adding to count; mid: " + mid + "; i: " + i);
                aux[k] = ar[j++];
                if (mid >= i) {
                    count += 1;// mid - i + 1;     // add number of items remaining in the left side of the array
                }
            }
        }
        
        return count;
    }
    
    public static void PrintArray(int[] ar) {
        for (int n: ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    public static int[] getIntArrayFromFile(String filename) {
        Scanner s = null;
        ArrayList<Integer> intlist = new ArrayList();
        int[] result = new int[0];
        
        try {
            s = new Scanner(new BufferedReader(new FileReader(filename)));
            
            while (s.hasNext()) {
                intlist.add(s.nextInt());
            }
            result = new int[intlist.size()];
            for (int i = 0; i < result.length; ++i) {
                result[i] = intlist.get(i);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
        
        return result;
    }
    
    public static void QuickSort(int[] ar) {
        if (ar.length < 2) return;
        
        QuickSort(ar, 0, ar.length - 1);
    }
    
    private static void QuickSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int p = Partition(ar, lo, hi);
            QuickSort(ar, lo, p - 1);
            QuickSort(ar, p + 1, hi);
        }
    }
    
    private static int Partition(int[] ar, int lo, int hi) {
        if (lo >= hi) return hi;
        
        int p = ar[hi];
        int i = lo;
        int j = hi - 1;
        
        if (i >= j) {
            return i;
        }
        
        while (i < j) {
            while (ar[i] <= p) {
                ++i;
            }
            while (ar[j] > p) {
                --j;
            }
            if (i < j) {
                swap(ar, i, j);
            }
        }
        
        swap(ar, i, hi);
        
        return i;
    }
    
    private static void swap(int[] ar, int a, int b) {
        //System.out.println("swapping " + ar[a] + " and " + ar[b]);
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }
}
