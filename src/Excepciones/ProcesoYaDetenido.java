package Excepciones;

public class ProcesoYaDetenido extends Exception{
    public ProcesoYaDetenido(String message) {
        super(message);
    }
}