package Controlador;

import Modelo.Proceso;
import Vista.Vista;
import ChainOfResponsability.HaltChecker;

import javax.swing.*;

public class Reverser {
    private Vista vista;
    private Proceso proceso;
    private boolean running;

    public Reverser() {
        this.vista = null;
        this.proceso = null;
        this.running = false;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public void execute(Proceso proceso) {
        this.proceso = proceso;
    }

    public void start() {
        if (proceso == null) {
            throw new IllegalStateException("No se ha especificado ningún proceso para ejecutar.");
        }

        running = true;
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    HaltChecker haltChecker = HaltChecker.getInstance();
                    boolean willHalt = haltChecker.willHalt(proceso);
                    if (willHalt) {
                        while (running) {
                            publish("El proceso se detendrá, iniciando bucle infinito...");
                            Thread.sleep(1000); // Espera 1 segundo
                        }
                    } else {
                        publish("El proceso es infinito, no se detendrá");
                    }
                } catch (Exception e) {
                    publish("Error al ejecutar el proceso: " + e.getMessage());
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

        worker.execute();
    }

    public void stop() {
        running = false;
    }
}








