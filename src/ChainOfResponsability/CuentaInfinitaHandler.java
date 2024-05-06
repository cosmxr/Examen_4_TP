package ChainOfResponsability;

import Modelo.CuentaInfinita;
import Modelo.Proceso;
import Vista.Vista;

public class CuentaInfinitaHandler implements Handler {
    @Override
    public void handle(Proceso proceso, Vista vista) throws InterruptedException {
        if (proceso instanceof CuentaInfinita) {
            CuentaInfinita cuentaInfinita = (CuentaInfinita) proceso;
            cuentaInfinita.execute(); // Ejecuta la cuenta infinita
        } else {
            throw new IllegalArgumentException("Tipo de proceso incorrecto para CuentaInfinitaHandler");
        }
    }
}
