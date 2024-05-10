package ChainOfResponsability;

public class ExceptionHandler {
    private static ExceptionHandler instance;
    private static ExcepcionHandlerInterface firstHandler;

    private ExceptionHandler(ExcepcionHandlerInterface firstHandler) {
        this.firstHandler = firstHandler;
    }

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            ExcepcionHandlerInterface reverserHandler = new ReverserHandler(null);
            ExcepcionHandlerInterface haltCheckerHandler = new HaltCheckerHandler(reverserHandler);
            ExcepcionHandlerInterface cuentaAtrasHandler = new CuentaAtrasProcesoHandler(haltCheckerHandler);
            ExcepcionHandlerInterface cuentaInfinitaHandler = new CuentaInfinitaProcesoHandler(cuentaAtrasHandler);

            instance = new ExceptionHandler(cuentaInfinitaHandler);
        }
        return instance;
    }

    public void handleException(Exception ex) {
        firstHandler.handleException(ex);
    }
}
