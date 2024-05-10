package Modelo;

import Excepciones.CuentaException;
import Vista.Vista;

/**
 * La clase CuentaInfinita implementa la interfaz Proceso y representa
 * un proceso de cuenta infinita.
 */
public class CuentaInfinita implements Proceso {
    private Vista vista;

    /**
     * Constructor de la clase CuentaInfinita.
     *
     * @param vista La vista asociada a este proceso para mostrar mensajes.
     */
    public CuentaInfinita(Vista vista) {
        this.vista = vista;
    }

    /**
     * Ejecuta el proceso de cuenta infinita.
     *
     * @throws CuentaException Si ocurre un error durante la cuenta infinita.
     * @throws InterruptedException Si la ejecución del proceso es interrumpida.
     */
    @Override
    public void execute() throws InterruptedException {
        int cuenta = 0;
        while (true) {
            String message = "Cuenta Infinita: " + cuenta;
            vista.update(message);
            cuenta++;
            Thread.sleep(500);
        }
    }
}





