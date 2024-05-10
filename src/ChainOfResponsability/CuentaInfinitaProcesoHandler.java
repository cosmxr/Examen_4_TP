package ChainOfResponsability;

import Excepciones.ProcesoSinEspecificar;

public class CuentaInfinitaProcesoHandler implements ExcepcionHandlerInterface {
    private ExcepcionHandlerInterface successor;

    public CuentaInfinitaProcesoHandler(ExcepcionHandlerInterface successor) {
        this.successor = successor;
    }

    @Override
    public void handleException(Exception ex) {
        if (ex.getMessage().contains("CuentaInfinita")) {
            // Manejar la excepción
        } else if (successor != null) {
            successor.handleException(ex);
        }
    }

    @Override
    public void setNextHandler(ExcepcionHandlerInterface nextHandler) {
        this.successor = nextHandler;
    }
}