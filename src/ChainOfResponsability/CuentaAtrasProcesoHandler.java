package ChainOfResponsability;

/**
 * Clase que maneja excepciones relacionadas con el proceso de cuenta atrás
 * en el contexto del patrón Chain of Responsibility.
 */
public class CuentaAtrasProcesoHandler implements ExcepcionHandlerInterface {
    private ExcepcionHandlerInterface successor;

    /**
     * Constructor de CuentaAtrasProcesoHandler que establece el siguiente manejador.
     *
     * @param successor El siguiente manejador en la cadena.
     */
    public CuentaAtrasProcesoHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

    /**
     * Maneja la excepción relacionada con el proceso de cuenta atrás.
     * Si la excepción no puede ser manejada por este manejador, la pasa al siguiente en la cadena.
     *
     * @param ex La excepción que se está manejando.
     */
    @Override
    public void handleException(Exception ex) {
        if (ex.getMessage().contains("CuentaAtras")) {
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