/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Lee
 */
public class NumberHelper {
    public static int[] getCounts(int[] input) {
        int lastNumber = input[input.length - 1];        
        int[] count = new int[lastNumber + 1];
        
        count(input, 0, input.length - 1, count);
        
        return count;
    }
    
    private static void count(int[] input, int begin, int end, int[] count) {
        System.out.println("count: begin: " + begin + "; end: " + end);
        if (input[begin] == input[end]) {
            count[input[begin]] += end - begin + 1;
        }
        else {
            count(input, begin, (begin + end)/2, count);
            count(input, (begin + end)/2 + 1, end, count);
        }
    }
    
    public static int[] getMissingBruteForce(int len, int[] ar) {
        int missingLen = len - ar.length;
        int[] missing = new int[missingLen];
        int missingCount = 0;        
        int arCount = 0;
        
        if (missingLen == 0) return new int[0];
        
        for (int i = 0; i < len; ++i) {
            if (arCount > ar.length - 1) {
                missing[missingCount++] = (i + 1);
            }
            else 
            {
                if (ar[arCount] != (i + 1)) {
                    missing[missingCount++] = (i + 1);
                }
                else {
                    ++arCount;
                }
            }
        }
        
        return missing;
    }
    
}
