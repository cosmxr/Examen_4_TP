package Excepciones;

import Modelo.Proceso;

public class ProcesoIncorrecto extends Exception{
    private Proceso proceso;

    public ProcesoIncorrecto(Proceso proceso) {
        this.proceso = proceso;
    }

    public Proceso getProceso() {
        return proceso;
    }
}