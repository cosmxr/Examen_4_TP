package ChainOfResponsability;

import Excepciones.*;

public class ReverserHandler implements ExcepcionHandlerInterface{

    private ExcepcionHandlerInterface successor;

    public ReverserHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

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

    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.successor = nextHandler;
    }
}