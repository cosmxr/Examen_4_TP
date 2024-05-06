package ChainOfResponsability;

import Excepciones.ProcesoIncorrecto;
import Modelo.Proceso;
import Vista.Vista;

public class ExceptionHandler {
    private static ExceptionHandler instance;
    private final Checker cuentaInfinitaChecker;
    private final Checker cuentaAtrasChecker;

    private final Handler cuentaInfinitaHandler;
    private final Handler cuentaAtrasHandler;

    private ExceptionHandler() {
        cuentaInfinitaChecker = new CuentaInfinitaChecker();
        cuentaAtrasChecker = new CuentaAtrasChecker();

        cuentaInfinitaHandler = new CuentaInfinitaHandler();
        cuentaAtrasHandler = new CuentaAtrasHandler();
    }

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public void handleException(Proceso proceso, Vista vista) throws ProcesoIncorrecto, InterruptedException {
        if (cuentaInfinitaChecker.check(proceso)) {
            cuentaInfinitaHandler.handle(proceso, vista);
        } else if (cuentaAtrasChecker.check(proceso)) {
            cuentaAtrasHandler.handle(proceso, vista);
        } else {
            throw new ProcesoIncorrecto("Proceso desconocido");
        }
    }
}

