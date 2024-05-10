package Excepciones;

/**
 * Excepción personalizada para indicar un proceso desconocido.
 */
public class ProcesoDesconocido extends Exception{
    /**
     * Constructor de la clase ProcesoDesconocido.
     *
     * @param message Mensaje descriptivo del error.
     */
    public ProcesoDesconocido(String message) {
        super(message);
    }
}
