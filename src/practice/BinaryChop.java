/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author ctcrrmcidlk
 */
public class BinaryChop {
    public static int iterChop(int needle, int[] haystack) {
        int low = 0;
        int high = haystack.length - 1;
        
        int mid;
        
        while (low <= high) {
            mid = (low + high) / 2;
            
            int currVal = haystack[mid];
            
            if (currVal < needle) { // search higher
                low = mid + 1;
            }
            else if (currVal > needle) { // search lower
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        
        return -1;
    }

    public static int recChop(int needle, int[] haystack, int begin, int end) {
        int mid = (begin + end) / 2;
        int currVal = haystack[mid];
        
        //System.out.println("recChop: mid: " + mid + "; currVal: " + currVal);

        if (begin <= end) {
            if (currVal < needle) return recChop(needle, haystack, mid + 1, end);
            else if (currVal > needle) return recChop(needle, haystack, begin, mid - 1);
            else return mid;
        }
        else {
            return -1;
        }
    }
    
    
}
