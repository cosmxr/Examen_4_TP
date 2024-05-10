package ChainOfResponsability;

/**
 * Clase CuentaInfinitaProcesoHandler que implementa ExcepcionHandlerInterface para manejar excepciones
 * relacionadas con el proceso de cuenta infinita en el patrón Chain of Responsibility.
 */
public class CuentaInfinitaProcesoHandler implements ExcepcionHandlerInterface {
    private ExcepcionHandlerInterface successor;

    /**
     * Constructor de CuentaInfinitaProcesoHandler que establece el siguiente manejador.
     *
     * @param successor El siguiente manejador en la cadena.
     */
    public CuentaInfinitaProcesoHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

    /**
     * Maneja la excepción relacionada con el proceso de cuenta infinita.
     * Si la excepción no puede ser manejada por este manejador, la pasa al siguiente en la cadena.
     *
     * @param ex La excepción que se está manejando.
     */
    @Override
    public void handleException(Exception ex) {
        if (ex.getMessage().contains("CuentaInfinita")) {
            // Manejar la excepción
        } else if (successor != null) {
            successor.handleException(ex);
        }
    }

    /**
     * Establece el siguiente manejador en la cadena para manejar excepciones adicionales.
     *
     * @param nextHandler El siguiente manejador en la cadena.
     */
    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.successor = nextHandler;
    }
}