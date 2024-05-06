public class CuentaAtrasChecker implements Checker {
    @Override
    public boolean check(Proceso proceso) {
        return proceso instanceof CuentaAtras;
    }
}