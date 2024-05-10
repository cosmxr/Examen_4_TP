package Controlador;

import Modelo.Proceso;
import Vista.Vista;
import ChainOfResponsability.HaltChecker;
import Excepciones.*;

import javax.swing.*;
/**
 * Controlador principal encargado de gestionar la ejecución de procesos y la interacción con la vista.
 */
public class Reverser {
    private Vista vista;
    private Proceso proceso;
    private boolean running;

    /**
     * Constructor para la clase Reverser.
     */
    public Reverser() {
        this.vista = null;
        this.proceso = null;
        this.running = false;

    }
    /**
     * Establece la vista asociada a este controlador.
     *
     * @param vista La vista a asociar con este controlador.
     */
    public void setVista(Vista vista) {
        this.vista = vista;
    }
    /**
     * Ejecuta un proceso dado. Este método prepara el proceso para su ejecución.
     *
     * @param proceso El proceso a ejecutar.
     * @throws ProcesoNoImplementado Si el proceso no está implementado correctamente.
     */
    public void execute(Proceso proceso) throws ProcesoNoImplementado{
        if  (!(proceso instanceof Proceso)) {
            throw new ProcesoNoImplementado("El objeto proporcionado no implementa la interfaz Proceso");
        }
        this.proceso = proceso;
    }
    /**
     * Inicia la ejecución del proceso.
     *
     * @param inputProceso El proceso de entrada que se utilizará junto con el proceso principal.
     * @throws ProcesoSinEspecificar Si no se ha especificado ningún proceso para ejecutar.
     */
    public void start(Proceso inputProceso) throws ProcesoSinEspecificar {
        if (proceso == null) {
            throw new ProcesoSinEspecificar("No se ha especificado ningún proceso para ejecutar.");
        }

        running = true;
        //Se utiliza un SwingWorker para ejecutar el proceso en segundo plano
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    // Lógica para verificar si el proceso debe detenerse o no
                    HaltChecker haltChecker = HaltChecker.getInstance();
                    String willHalt = haltChecker.willHalt(proceso, inputProceso);
                    if (willHalt.equals("para")) {
                        // Bucle infinito hasta que el proceso se detenga
                        while (running) {
                            publish("El proceso se detendrá, iniciando bucle infinito...");
                            Thread.sleep(1000); // Espera 1 segundo
                        }
                    } else {
                        publish("El proceso es infinito, no se detendrá");
                    }
                } catch (Exception e) {
                    publish("Error al ejecutar el proceso:  " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String message : chunks) {
                    vista.update(message);
                }
            }

            @Override
            protected void done() {
                running = false;
            }
        };

        worker.execute(); //ejecuta SwingWorker
    }
    /**
     * Detiene la ejecución del proceso actual.
     *
     * @throws ProcesoYaDetenido Si el proceso ya se ha detenido previamente.
     */
    public void stop() throws ProcesoYaDetenido{
        if (!running) {
            throw new ProcesoYaDetenido("El proceso ya se ha detenido.");
        }
        running = false;
    }
}




