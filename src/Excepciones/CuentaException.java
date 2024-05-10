package Excepciones;

/**
 * Excepción personalizada para errores relacionados con cuentas.
 */
public class CuentaException extends Exception{

    /**
     * Constructor de la clase CuentaException.
     *
     * @param message Mensaje descriptivo del error.
     */
    public CuentaException(String message) {
        super(message);
    }
}