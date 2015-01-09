/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author ctcrrmcidlk
 */
public class ListFullException extends IndexOutOfBoundsException {
    private static final String DEFAULT_MESSAGE = "The list is full.";
    private String message = "";
    
    public ListFullException() {
        super(DEFAULT_MESSAGE);
    }
    
    public ListFullException(String message) {
        super(DEFAULT_MESSAGE + " " + message);
        this.message = message;
    }
//    
//    public ListFullException(Throwable cause) {
//        super(cause);
//    }
    
    @Override
    public String toString() {
        return DEFAULT_MESSAGE + " " + this.message;
    }
    
    @Override
    public String getMessage() {
        return DEFAULT_MESSAGE + " " + this.message;
    }
}
