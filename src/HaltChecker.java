public class HaltChecker {
    private static HaltChecker instance;
    private CuentaInfinita infinito;
    private CuentaAtras finito;

    private HaltChecker() {}

    public static HaltChecker getInstance() {
        if (instance == null) {
            instance = new HaltChecker();
        }
        return instance;
    }

    public boolean willHalt(Proceso proceso) {
        if (proceso instanceof CuentaInfinita) {
            return false;
            //no se para
        } else if (proceso instanceof CuentaAtras) {
            return true;
            //se para
        } else {
            throw new IllegalArgumentException("Proceso desconocido");
        }
    }
}