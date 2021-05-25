package excepciones;

public class PrecioInsuficienteException extends Exception {

    public PrecioInsuficienteException() {
    	super("El precio dispuesto a pagar es menor del precio real de la noche");
    }

    public PrecioInsuficienteException(String message) {
        super(message);
    }

}
