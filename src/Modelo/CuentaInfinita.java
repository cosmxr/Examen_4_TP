package Modelo;

import Vista.Vista;

public class CuentaInfinita implements Proceso {
    private Vista vista;

    public CuentaInfinita(Vista vista) {
        this.vista = vista;
    }

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





