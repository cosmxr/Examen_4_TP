package ChainOfResponsability;

import Excepciones.CuentaException;
import Excepciones.ProcesoIncorrecto;
import Modelo.Proceso;
import Vista.*;

public interface Handler {
    void handle(Proceso proceso, Vista vista) throws InterruptedException, ProcesoIncorrecto;
}