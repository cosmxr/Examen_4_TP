public class CuentaInfinitaHandler implements Handler {
    @Override
    public void handle(Proceso proceso) throws InterruptedException {
        ((CuentaInfinita) proceso).execute(0);
    }
}