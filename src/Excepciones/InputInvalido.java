package Excepciones;

/**
 * Excepción personalizada para indicar que se ha proporcionado un input inválido.
 */
public class InputInvalido extends Exception{
    /**
     * Constructor de la clase InputInvalido.
     *
     * @param message Mensaje descriptivo del error.
     */
    public InputInvalido (String message){
        super (message);
    }
}
