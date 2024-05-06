public class Main {
    public static void main(String[] args) {
        Reverser reverser = new Reverser(); // Crear una instancia de Reverser
        Vista vista = new Vista(reverser); // Pasar reverser a la instancia de Vista
        reverser.setVista(vista); // Establecer la referencia de Vista en Reverser
    }
}

