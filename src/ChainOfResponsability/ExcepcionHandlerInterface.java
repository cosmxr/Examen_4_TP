package ChainOfResponsability;

/**
 * Interfaz ExcepcionHandlerInterface que define métodos para manejar excepciones
 * siguiendo el patrón Chain of Responsibility.
 */
public interface ExcepcionHandlerInterface {

    /**
     * Maneja la excepción especificada.
     *
     * @param ex La excepción a manejar.
     */
    void handleException(Exception ex);

    /**
     * Establece el siguiente manejador en la cadena de responsabilidad.
     *
     * @param nextHandler El siguiente manejador en la cadena.
     */
    void setNextHandler(ExcepcionHandlerInterface nextHandler);

}