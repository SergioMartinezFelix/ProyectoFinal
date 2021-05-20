/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author sergi
 */
public class PrecioErroneoException extends Exception {

    public PrecioErroneoException() {
    }

    public PrecioErroneoException(String message) {
        super(message);
    }

    public PrecioErroneoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrecioErroneoException(Throwable cause) {
        super(cause);
    }

    public PrecioErroneoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    

    
    
}
