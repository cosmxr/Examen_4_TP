/**
 * Este método realiza una cuenta atrás desde 10 hasta 0.
 * Cada número se imprime en la consola con una diferencia de 0.5 segundos entre cada número.
 *
 * @throws RuntimeException si el hilo es interrumpido durante el sueño "diferencia de 0.5"
 */

public class CuentaAtras implements Proceso {
    private Proceso next;

    @Override
    public void setNext(Proceso proceso) {
        this.next = proceso;
    }

    @Override
    public void execute(int cuenta) throws InterruptedException {
        if (cuenta >= 0 && next != null) {
            next.execute(cuenta);
        } else {
            while (cuenta > 0) {
                System.out.println(cuenta);
                cuenta--;
                Thread.sleep(500); // Espera 0.5 segundos
            }
        }
    }
}
