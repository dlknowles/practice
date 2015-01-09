/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author ctcrrmcidlk
 */
public class Debug {
    public static void println(String message) {
        if (Globals.debug) System.out.println(message);
    }
    
    public static void print(String message) {
        if (Globals.debug) System.out.print(message);
    }
}
