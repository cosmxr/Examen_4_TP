package ChainOfResponsability;

import Modelo.Proceso;
import Vista.Vista;

public class ExceptionHandler {
    private static ExceptionHandler instance;
    private Checker cuentaInfinitaChecker;
    private Checker cuentaAtrasChecker;

    private Handler cuentaInfinitaHandler;
    private Handler cuentaAtrasHandler;

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

    public void handleException(Proceso proceso, Vista vista) {
        try {
            if (cuentaInfinitaChecker.check(proceso)) {
                cuentaInfinitaHandler.handle(proceso, vista);
            } else if (cuentaAtrasChecker.check(proceso)) {
                cuentaAtrasHandler.handle(proceso, vista);
            } else {
                throw new IllegalArgumentException("Proceso desconocido");
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // Maneja la interrupción adecuadamente
            Thread.currentThread().interrupt(); // Restaura la bandera de interrupción
        }
    }
}

