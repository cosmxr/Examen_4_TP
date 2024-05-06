/**
 * Este método realiza una cuenta atrás desde 10 hasta 0.
 * Cada número se imprime en la consola con una diferencia de 0.5 segundos entre cada número.
 *
 * @throws RuntimeException si el hilo es interrumpido durante el sueño "diferencia de 0.5"
 */

public class CuentaAtras implements Proceso {
    @Override
    public void execute(int cuenta) {
        while (cuenta >= 0) {
            System.out.println(cuenta);
            cuenta--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
