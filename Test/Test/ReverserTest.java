package Test;

import static org.junit.jupiter.api.Assertions.*;

import Vista.Vista;
import org.junit.jupiter.api.Test;
import Controlador.*;
import Excepciones.*;
import Modelo.*;

/**
 * Clase de prueba para la clase Reverser.
 */
public class ReverserTest {
    Reverser reverser = new Reverser();
    Vista vista = new Vista(reverser);

    /**
     * Test para asegurar que se lance una excepción si se intenta ejecutar con un proceso no implementado.
     */
    @Test
    public void testExecuteWithNonImplementedProcess() {
        Reverser reverser = new Reverser();
        assertThrows(ProcesoNoImplementado.class, () -> {
            reverser.execute(null); // Pasando un proceso nulo intencionalmente para simular un error
        });
    }

    /**
     * Test para asegurar que se lance una excepción si se intenta iniciar sin especificar un proceso.
     */
    @Test
    public void testStartWithoutSpecifiedProcess() {
        Reverser reverser = new Reverser();
        assertThrows(ProcesoSinEspecificar.class, () -> {
            reverser.start(null); // Pasando un proceso nulo intencionalmente para simular un error
        });
    }

    /**
     * Test para asegurar que se lance una excepción si se intenta detener un proceso ya detenido.
     */
    @Test
    public void testStopAlreadyStoppedProcess() {
        Reverser reverser = new Reverser();
        assertThrows(ProcesoYaDetenido.class, () -> {
            reverser.stop(); // Intentando detener un proceso que no está en ejecución
        });
    }

    /**
     * Test para asegurar que se puede ejecutar un proceso implementado correctamente.
     */
    @Test
    public void testExecuteWithImplementedProcess() {
        Reverser reverser = new Reverser();
        Proceso proceso = new CuentaAtras(vista); // Creando un proceso válido
        assertDoesNotThrow(() -> {
            reverser.execute(proceso);
        });
    }
}