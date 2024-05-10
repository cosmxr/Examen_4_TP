package Modelo;

import Excepciones.CuentaException;
import Vista.Vista;

/**
 * La clase CuentaAtras implementa la interfaz Proceso y representa
 * un proceso de cuenta regresiva.
 */
public class CuentaAtras implements Proceso {
    private Vista vista;

    /**
     * Constructor de la clase CuentaAtras.
     *
     * @param vista La vista asociada a este proceso para mostrar mensajes.
     */
    public CuentaAtras(Vista vista) {
        this.vista = vista;
    }

    /**
     * Ejecuta el proceso de cuenta regresiva.
     *
     * @throws CuentaException Si ocurre un error durante la cuenta regresiva.
     * @throws InterruptedException Si la ejecución del proceso es interrumpida.
     */
    @Override
    public void execute() throws InterruptedException {
        int cuenta = 10;
        while (cuenta > 0) {
            String message = "Cuenta Atrás: " + cuenta;
            vista.update(message);
            cuenta--;
            Thread.sleep(500);
        }
    }
}



