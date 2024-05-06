/**
 * Este método realiza una cuenta creciente infinita.
 * Cada número se imprime en la consola con una diferencia de 0.5 segundos entre cada número.
 *
 * @throws RuntimeException si el hilo es interrumpido durante el sueño "diferencia de 0.5"
 */
public class CuentaInfinita implements Proceso {
    @Override
    public void execute(int cuenta) {

        while (true) {
            System.out.println(cuenta);
            cuenta++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

