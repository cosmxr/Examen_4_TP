/**
 * Este método realiza una cuenta creciente infinita.
 * Cada número se imprime en la consola con una diferencia de 0.5 segundos entre cada número.
 *
 * @throws RuntimeException si el hilo es interrumpido durante el sueño "diferencia de 0.5"
 */
public class CuentaInfinita {
        public static void cuentaInfinita() {
            int num = 1;
            while (true) {
                System.out.println(num);
                num++;
                try {
                    Thread.sleep(500); //funcion para crear la diferencia de 0.5 segundos
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

