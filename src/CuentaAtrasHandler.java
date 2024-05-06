public class CuentaAtrasHandler implements Handler {
    @Override
    public void handle(Proceso proceso) throws InterruptedException {
        ((CuentaAtras) proceso).execute(10);
    }
}
