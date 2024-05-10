package ChainOfResponsability;

import Excepciones.InputInvalido;
import Excepciones.ProcesoDesconocido;
import Modelo.*;

/**
 * Clase HaltChecker que proporciona lógica para determinar si un proceso se detendrá.
 * Utiliza el patrón Singleton para garantizar una única instancia.
 */
public class HaltChecker {
    private static HaltChecker instance;

    /**
     * Método estático para obtener la instancia única de HaltChecker.
     *
     * @return La instancia única de HaltChecker.
     */
    public static HaltChecker getInstance() {
        if (instance == null) {
            instance = new HaltChecker(); // Crea la instancia si no existe
        }
        return instance;
    }

    /**
     * Determina si el proceso se detendrá según los tipos de procesos de entrada y actual.
     *
     * @param proceso      El proceso actual.
     * @param inputProceso El input de entrada.
     * @return Una cadena indicando si el proceso se detendrá o continuará infinitamente.
     * @throws ProcesoDesconocido Si se encuentra un proceso desconocido.
     * @throws InputInvalido     Si se proporciona un input no válido para el proceso.
     */
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