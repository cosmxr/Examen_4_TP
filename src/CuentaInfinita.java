/**
 * Este método realiza una cuenta creciente infinita.
 * Cada número se imprime en la consola con una diferencia de 0.5 segundos entre cada número.
 *
 * @throws RuntimeException si el hilo es interrumpido durante el sueño "diferencia de 0.5"
 */
public class CuentaInfinita implements Proceso {
    private Proceso next;

    @Override
    public void setNext(Proceso proceso) {
        this.next = proceso;
    }

    @Override
    public void execute(int cuenta) throws InterruptedException {
        if (cuenta < 0 && next != null) {
            next.execute(cuenta);
        } else {
            while (true) {
                System.out.println(cuenta);
                cuenta++;
                Thread.sleep(500); // Espera 0.5 segundos
            }
        }
    }
}


