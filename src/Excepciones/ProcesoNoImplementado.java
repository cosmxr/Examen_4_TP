package Excepciones;

/**
 * Excepción personalizada para indicar que un proceso no ha sido implementado.
 */
public class ProcesoNoImplementado extends Exception{
    /**
     * Constructor de la clase ProcesoNoImplementado.
     *
     * @param message Mensaje descriptivo del error.
     */
    public ProcesoNoImplementado(String message){
        super (message);
    }
}
