package ChainOfResponsability;

import Excepciones.InputInvalido;
import Excepciones.ProcesoDesconocido;
import Modelo.CuentaAtras;
import Modelo.CuentaInfinita;
import Modelo.Proceso;

public class HaltChecker {
    private static HaltChecker instance;

    public static HaltChecker getInstance() {
        if (instance == null) {
            instance = new HaltChecker();
        }
        return instance;
    }

    public String willHalt(Proceso proceso, Proceso inputProceso) throws ProcesoDesconocido, InputInvalido {
        if (proceso instanceof CuentaInfinita && inputProceso instanceof CuentaInfinita) {
            return "nunca";
        } else if (proceso instanceof CuentaInfinita && inputProceso instanceof CuentaAtras) {
            throw new InputInvalido("Input seleccionado no es valido, con el proceso seleccionado.");
        } else if (proceso instanceof CuentaAtras && inputProceso instanceof CuentaAtras){
            return "para"; //se para
        } else if (proceso instanceof CuentaAtras && inputProceso instanceof CuentaInfinita) {
            throw new InputInvalido("Input seleccionado no es valido, con el proceso seleccionado.");
        }else {
            throw new ProcesoDesconocido ("Proceso desconocido, error en la selección de datos");
    }
}
}