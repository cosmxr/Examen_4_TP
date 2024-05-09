package ChainOfResponsability;

import Modelo.CuentaInfinita;
import Excepciones.*;

public class CuentaInfinitaProcesoHandler implements ExcepcionHandlerInterface {
    private ExcepcionHandlerInterface nextHandler;

    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleException(Exception exception) {
        if (exception instanceof ProcesoIncorrecto &&
                ((ProcesoIncorrecto) exception).getProceso() instanceof CuentaInfinita) {
            // Manejar la excepción
            System.out.println("Manejando excepción ProcesoIncorrecto para CuentaInfinita");
        } else if (nextHandler != null) {
            nextHandler.handleException(exception);
        }
    }
}