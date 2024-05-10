package ChainOfResponsability;

import Excepciones.*;


/**
 * Clase ReverserHandler que implementa la interfaz ExcepcionHandlerInterface.
 * Esta clase maneja excepciones específicas relacionadas con procesos en el Reverser.
 */
public class ReverserHandler implements ExcepcionHandlerInterface {

    private ExcepcionHandlerInterface successor;  // Referencia al siguiente manejador

    /**
     * Constructor de la clase ReverserHandler.
     *
     * @param successor El siguiente manejador en la cadena de responsabilidad.
     */
    public ReverserHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

    /**
     * Maneja la excepción específica.
     * En este caso, maneja excepciones relacionadas con procesos en el Reverser.
     *
     * @param ex La excepción a manejar.
     */
    @Override
    public void handleException(Exception ex) {
        if (ex instanceof ProcesoNoImplementado) {
            System.err.println("Se produjo una excepción ProcesoNoImplementado en el proceso Reverser: " + ex.getMessage());
        } else if (ex instanceof ProcesoSinEspecificar) {
            System.err.println("Se produjo una excepción ProcesoSinEspecificar en el proceso Reverser: " + ex.getMessage());
        } else if (ex instanceof ProcesoYaDetenido) {
            System.err.println("Se produjo una excepción ProcesoYaDetenido en el proceso Reverser: " + ex.getMessage());
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
