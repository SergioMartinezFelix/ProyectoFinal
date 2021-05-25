package excepciones;

public class HabitacionesInsuficientesException extends Exception {

    public HabitacionesInsuficientesException() {
    	super("No hay suficientes habitaciones en el hotel");
    }

    public HabitacionesInsuficientesException(String message) {
        super(message);
    }

}
