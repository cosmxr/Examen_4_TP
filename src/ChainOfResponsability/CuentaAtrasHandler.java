package ChainOfResponsability;

import Modelo.CuentaAtras;
import Modelo.Proceso;
import Vista.Vista;

public class CuentaAtrasHandler implements Handler {
    @Override
    public void handle(Proceso proceso, Vista vista) throws InterruptedException {
        if (proceso instanceof CuentaAtras) {
            CuentaAtras cuentaAtras = (CuentaAtras) proceso;
            cuentaAtras.execute(); // Ejecuta la cuenta atrás
        } else {
            throw new IllegalArgumentException("Tipo de proceso incorrecto para CuentaAtrasHandler");
        }
    }
}
