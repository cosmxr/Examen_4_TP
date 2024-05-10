package ChainOfResponsability;

import Excepciones.*;


/**
 * Clase HaltCheckerHandler que implementa la interfaz ExcepcionHandlerInterface.
 * Esta clase maneja excepciones específicas relacionadas con el proceso HaltChecker.
 */
public class HaltCheckerHandler implements ExcepcionHandlerInterface {

    private ExcepcionHandlerInterface successor;

    /**
     * Constructor de la clase HaltCheckerHandler.
     *
     * @param successor El siguiente manejador en la cadena de responsabilidad.
     */
    public HaltCheckerHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

    /**
     * Maneja la excepción específica.
     * En este caso, maneja excepciones relacionadas con el proceso HaltChecker.
     *
     * @param ex La excepción a manejar.
     */
    @Override
    public void handleException(Exception ex) {
        if (ex instanceof ProcesoDesconocido) {
            System.err.println("Se produjo una excepción ProcesoDesconocido en el proceso HaltChecker: " + ex.getMessage());
        } else if (ex instanceof InputInvalido) {
            System.err.println("Se produjo una excepción InputInvalido en el proceso HaltChecker: " + ex.getMessage());
        } else if (successor != null) {
            successor.handleException(ex);
        }
    }

    /**
     * Establece el siguiente manejador en la cadena de responsabilidad.
     *
     * @param nextHandler El siguiente manejador a establecer.
     */
    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.successor = nextHandler;
    }
}
