package ChainOfResponsability;

public class ExceptionHandler {
    private static ExceptionHandler instance;
    private final ExcepcionHandlerInterface cuentaInfinitaProcesoHandler;
    private final ExcepcionHandlerInterface cuentaAtrasProcesoHandler;

    private ExceptionHandler() {
        cuentaInfinitaProcesoHandler = new CuentaInfinitaProcesoHandler();
        cuentaAtrasProcesoHandler = new CuentaAtrasProcesoHandler();
        cuentaInfinitaProcesoHandler.setNextHandler(cuentaAtrasProcesoHandler);
    }

    public  ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public void handleException(Exception exception) {
        cuentaInfinitaProcesoHandler.handleException(exception);
    }
}
