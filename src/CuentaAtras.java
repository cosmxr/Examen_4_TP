/**
 * Este método realiza una cuenta atrás desde 10 hasta 0.
 * Cada número se imprime en la consola con una diferencia de 0.5 segundos entre cada número.
 *
 * @throws RuntimeException si el hilo es interrumpido durante el sueño "diferencia de 0.5"
 */

public class CuentaAtras {
    public static void cuentaAtras(){
    int num = 10;
        while (num >= 0) {
        System.out.println(num);
        num--;
            try {
                Thread.sleep(500); //funcion para crear la diferencia de 0.5 segundos
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
}
