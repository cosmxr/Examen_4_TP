package Excepciones;

import Modelo.Proceso;

/**
 * Excepción personalizada para indicar un proceso incorrecto.
 */
public class ProcesoIncorrecto extends Exception{
    private Proceso proceso;

    /**
     * Constructor de la clase ProcesoIncorrecto.
     *
     * @param proceso El proceso incorrecto.
     */
    public ProcesoIncorrecto(Proceso proceso) {
        this.proceso = proceso;
    }

    /**
     * Obtiene el proceso incorrecto.
     *
     * @return El proceso incorrecto.
     */
    public Proceso getProceso() {
        return proceso;
    }
}