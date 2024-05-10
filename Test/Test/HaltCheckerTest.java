package Test;

import static org.junit.jupiter.api.Assertions.*;

import ChainOfResponsability.HaltChecker;
import org.junit.jupiter.api.Test;
import Modelo.*;
import Excepciones.*;

/**
 * Clase de prueba para la clase HaltChecker.
 */
public class HaltCheckerTest {

    /**
     * Test para verificar que una instancia de CuentaInfinita nunca se detiene.
     */

    @Test
    public void testWillHaltWithCuentaInfinita() {
        HaltChecker haltChecker = HaltChecker.getInstance();
        Proceso proceso = new CuentaInfinita(null); // Vista se pasa como null para la prueba
        Proceso inputProceso = new CuentaInfinita(null); // Vista se pasa como null para la prueba
        assertDoesNotThrow(() -> {
            String result = haltChecker.willHalt(proceso, inputProceso);
            assertEquals("nunca", result);
        });
    }

    /**
     * Test para verificar que una instancia de CuentaAtras se detiene cuando el input es también CuentaAtras.
     */

    @Test
    public void testWillHaltWithCuentaAtrasAndInputCuentaAtras() {
        HaltChecker haltChecker = HaltChecker.getInstance();
        Proceso proceso = new CuentaAtras(null); // Vista se pasa como null para la prueba
        Proceso inputProceso = new CuentaAtras(null); // Vista se pasa como null para la prueba
        assertDoesNotThrow(() -> {
            String result = haltChecker.willHalt(proceso, inputProceso);
            assertEquals("para", result);
        });
    }

    /**
     * Test para verificar que se lance una excepción InputInvalido cuando se usa CuentaAtras con input CuentaInfinita.
     */

    @Test
    public void testWillHaltWithCuentaAtrasAndInputCuentaInfinita() {
        HaltChecker haltChecker = HaltChecker.getInstance();
        Proceso proceso = new CuentaAtras(null); // Vista se pasa como null para la prueba
        Proceso inputProceso = new CuentaInfinita(null); // Vista se pasa como null para la prueba
        assertThrows(InputInvalido.class, () -> {
            haltChecker.willHalt(proceso, inputProceso);
        });
    }

}