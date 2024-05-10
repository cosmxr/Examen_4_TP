import ChainOfResponsability.ExceptionHandler;
import Excepciones.ProcesoNoImplementado;
import Excepciones.ProcesoSinEspecificar;
import Modelo.Proceso;
import Vista.Vista;
import Controlador.Reverser;
import Modelo.CuentaAtras;
import Modelo.CuentaInfinita;

import javax.swing.*;

/**
 * Esta clase representa la clase principal del programa que inicia la aplicación.
 * Contiene el método `main` que es el punto de entrada principal para ejecutar el programa.
 */
public class Main {

    /**
     * Método principal que inicia la aplicación y configura los componentes principales.
     * Crea una instancia del controlador `Reverser`, configura la vista y maneja las interacciones de usuario.
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        //Creamos una instancia para el manejador de excepciones
        ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
        try{
        // Crear una instancia del controlador Reverser sin pasar ningún parámetro
        Reverser reverser = new Reverser();
        Vista vista = new Vista(reverser);


        // Establecer la referencia de la vista en el reverser
        reverser.setVista(vista);

        // Ejecutar la creación de la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Hacer visible la ventana de la aplicación
            vista.getFrame().setVisible(true);
        });

        Proceso[] inputProceso = new Proceso[1];

        // Configurar ActionListener para el botón de Cuenta Infinita
        vista.getBtnInputCuentaInfinita().addActionListener(e -> {
            inputProceso[0] = new CuentaInfinita(vista);
        });

        vista.getBtnInputCuentaAtras().addActionListener(e -> {
            inputProceso[0] = new CuentaAtras(vista);
        });

        vista.getBtnCuentaInfinita().addActionListener(e -> {
            try {
                reverser.execute(new CuentaInfinita(vista)); // Iniciar una cuenta infinita
                reverser.start(inputProceso[0]); // Comenzar la ejecución del proceso
            } catch (ProcesoNoImplementado | ProcesoSinEspecificar ex) {
                exceptionHandler.handleException(ex);
            }
        });

        vista.getBtnCuentaAtras().addActionListener(e -> {
            try {
                reverser.execute(new CuentaAtras(vista)); // Iniciar una cuenta atrás
                reverser.start(inputProceso[0]); // Comenzar la ejecución del proceso
            } catch (ProcesoNoImplementado | ProcesoSinEspecificar ex) {
                exceptionHandler.handleException(ex);
            }
        });
    }catch (Exception ex){
            exceptionHandler.handleException(ex);
        }
}
}