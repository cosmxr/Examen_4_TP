public class CuentaInfinitaChecker implements Checker {
    @Override
    public boolean check(Proceso proceso) {
        return proceso instanceof CuentaInfinita;
    }
}
