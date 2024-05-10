package Modelo;

import Excepciones.CuentaException;
/**
 * La interfaz Proceso define el comportamiento que deben implementar
 * los diferentes tipos de procesos en la aplicación.
 */
public interface Proceso {
    /**
     * Método para ejecutar el proceso específico.
     *
     * @throws CuentaException Si ocurre un error durante la ejecución del proceso.
     * @throws InterruptedException Si la ejecución del proceso es interrumpida.
     */
    void execute() throws CuentaException, InterruptedException;
}

