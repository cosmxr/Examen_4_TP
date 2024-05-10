package Test;

import org.junit.jupiter.api.Test;
import ChainOfResponsability.*;
import Excepciones.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
/**
 * Clase de prueba para la clase ExceptionHandler.
 */
public class ExceptionHandlerTest {

    /**
     * Test para asegurar que se maneje correctamente una excepción ProcesoNoImplementado.
     */
    @Test
    public void testHandleProcesoNoImplementadoException() {
        ExceptionHandler handler = ExceptionHandler.getInstance();
        ProcesoNoImplementado exception = new ProcesoNoImplementado("Proceso no implementado");
        assertDoesNotThrow(() -> {
            handler.handleException(exception);
        });
    }

    /**
     * Test para asegurar que se maneje correctamente una excepción ProcesoSinEspecificar.
     */
    @Test
    public void testHandleProcesoSinEspecificarException() {
        ExceptionHandler handler = ExceptionHandler.getInstance();
        ProcesoSinEspecificar exception = new ProcesoSinEspecificar("Proceso sin especificar");
        assertDoesNotThrow(() -> {
            handler.handleException(exception);
        });
    }

    /**
     * Test para asegurar que se maneje correctamente una excepción ProcesoYaDetenido.
     */
    @Test
    public void testHandleProcesoYaDetenidoException() {
        ExceptionHandler handler = ExceptionHandler.getInstance();
        ProcesoYaDetenido exception = new ProcesoYaDetenido("Proceso ya detenido");
        assertDoesNotThrow(() -> {
            handler.handleException(exception);
        });
    }

    /**
     * Test para asegurar que se maneje correctamente una excepción ProcesoDesconocido.
     */
    @Test
    public void testHandleProcesoDesconocidoException() {
        ExceptionHandler handler = ExceptionHandler.getInstance();
        ProcesoDesconocido exception = new ProcesoDesconocido("Proceso desconocido");
        assertDoesNotThrow(() -> {
            handler.handleException(exception);
        });
    }

    /**
     * Test para asegurar que se maneje correctamente una excepción InputInvalido.
     */
    @Test
    public void testHandleInputInvalidoException() {
        ExceptionHandler handler = ExceptionHandler.getInstance();
        InputInvalido exception = new InputInvalido("Input inválido");
        assertDoesNotThrow(() -> {
            handler.handleException(exception);
        });
    }

    /**
     * Test para asegurar que se maneje correctamente una excepción CuentaException.
     */
    @Test
    public void testHandleCuentaException() {
        ExceptionHandler handler = ExceptionHandler.getInstance();
        CuentaException exception = new CuentaException("Error en la cuenta");
        assertDoesNotThrow(() -> {
            handler.handleException(exception);
        });
    }
}
