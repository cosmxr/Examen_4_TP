package Modelo;

import Excepciones.CuentaException;

public interface Proceso {
    void execute() throws CuentaException, InterruptedException;
}

