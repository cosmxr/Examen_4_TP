package ChainOfResponsability;

import Excepciones.ProcesoDesconocido;
import Excepciones.ProcesoSinEspecificar;
import Excepciones.ProcesoYaDetenido;
import Modelo.CuentaAtras;
import Modelo.CuentaInfinita;
import Modelo.Proceso;

public class HaltChecker {
    private static HaltChecker instance;
    private CuentaInfinita infinito;
    private CuentaAtras finito;

    public static HaltChecker getInstance() {
        if (instance == null) {
            instance = new HaltChecker();
        }
        return instance;
    }

    public boolean willHalt(Proceso proceso) throws ProcesoDesconocido {
        if (proceso instanceof CuentaInfinita) {
            return false;
            //no se para
        } else if (proceso instanceof CuentaAtras) {
            return true;
            //se para
        } else {
            throw new ProcesoDesconocido ("Proceso desconocido");
        }
    }
}