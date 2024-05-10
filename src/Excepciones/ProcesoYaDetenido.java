package Excepciones;

/**
 * Excepción personalizada para indicar que un proceso ya ha sido detenido.
 */
public class ProcesoYaDetenido extends Exception{

    /**
     * Constructor de la clase ProcesoYaDetenido.
     *
     * @param message Mensaje descriptivo del error.
     */
    public ProcesoYaDetenido(String message) {
        super(message);
    }
}