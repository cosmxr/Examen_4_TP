package ChainOfResponsability;

import Modelo.CuentaAtras;
import Excepciones.*;

public class CuentaAtrasProcesoHandler implements ExcepcionHandlerInterface {
    private ExcepcionHandlerInterface nextHandler;

    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleException(Exception exception) {
        if (exception instanceof ProcesoIncorrecto &&
                ((ProcesoIncorrecto) exception).getProceso() instanceof CuentaAtras) {
            // Manejar la excepción
            System.out.println("Manejando excepción ProcesoIncorrecto para CuentaAtras");
        } else if (nextHandler != null) {
            nextHandler.handleException(exception);
        }
    }
}