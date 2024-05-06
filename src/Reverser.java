public class Reverser {
    public void execute(Proceso proceso) {
        HaltChecker haltChecker = HaltChecker.getInstance();
        boolean willHalt = haltChecker.willHalt(proceso);

        if (willHalt) {
            while (true) {
                System.out.println("Ejecutando bucle infinito de " + proceso.getClass().getName());
                try {
                    Thread.sleep(1000); // Espera 1 segundo
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            System.out.println("EL programa no se para");
        }
    }
}