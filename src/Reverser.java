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
        HaltChecker haltChecker = HaltChecker.getInstance();
        boolean willHalt = haltChecker.willHalt(proceso);

        if (willHalt) {
            running = true;
            new Thread(() -> {
                while (running) {
                    vista.update("Ejecutando bucle infinito de " + proceso.getClass().getName());
                    try {
                        Thread.sleep(1000); // Espera 1 segundo
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        } else {
            vista.update("El programa no se para");
        }
    }

    public void stop() {
        running = false;
    }
}

