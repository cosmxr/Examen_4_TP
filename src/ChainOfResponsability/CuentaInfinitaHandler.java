package ChainOfResponsability;

import Modelo.CuentaInfinita;
import Modelo.Proceso;
import Vista.Vista;
import Excepciones.*;

public class CuentaInfinitaHandler implements Handler {
    @Override
    public void handle(Proceso proceso, Vista vista) throws  InterruptedException, ProcesoIncorrecto{
        if (proceso instanceof CuentaInfinita) {
            CuentaInfinita cuentaInfinita = (CuentaInfinita) proceso;
            cuentaInfinita.execute(); // Ejecuta la cuenta infinita
        } else {
            throw new ProcesoIncorrecto("Tipo de proceso incorrecto para CuentaInfinitaHandler");
        }
    }
}
