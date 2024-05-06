package ChainOfResponsability;

import Modelo.CuentaInfinita;
import Modelo.Proceso;

public class CuentaInfinitaChecker implements Checker {
    @Override
    public boolean check(Proceso proceso) {
        return proceso instanceof CuentaInfinita;
    }
}
