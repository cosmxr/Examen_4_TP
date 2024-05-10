package ChainOfResponsability;

import Excepciones.*;

public class HaltCheckerHandler implements ExcepcionHandlerInterface{

    private ExcepcionHandlerInterface successor;

    public HaltCheckerHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

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

    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.successor = nextHandler;
    }
}