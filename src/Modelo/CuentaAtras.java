package Modelo;

import Vista.Vista;

public class CuentaAtras implements Proceso {
    private Vista vista;

    public CuentaAtras(Vista vista) {
        this.vista = vista;
    }

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



