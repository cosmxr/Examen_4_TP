package Excepciones;

/**
 * Excepción personalizada para indicar que no se ha especificado un proceso.
 */
public class ProcesoSinEspecificar extends Exception{

    /**
     * Constructor de la clase ProcesoSinEspecificar.
     *
     * @param message Mensaje descriptivo del error.
     */
    public  ProcesoSinEspecificar(String message) {
        super(message);
    }
}
