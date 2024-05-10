package ChainOfResponsability;

/**
 * Clase ExceptionHandler que gestiona excepciones utilizando el patrón Chain of Responsibility.
 * Utiliza una estructura de manejo de excepciones en cadena para manejar diferentes tipos de excepciones.
 */
public class ExceptionHandler {

    private static ExceptionHandler instance;
    private static ExcepcionHandlerInterface firstHandler;  // Primer manejador en la cadena

    /**
     * Constructor privado de ExceptionHandler que inicializa la cadena de manejo de excepciones.
     *
     * @param firstHandler El primer manejador en la cadena.
     */
    private ExceptionHandler(ExcepcionHandlerInterface firstHandler) {
        this.firstHandler = firstHandler;
    }

    /**
     * Método estático para obtener la instancia única de ExceptionHandler.
     * Crea la instancia si no existe y la devuelve.
     *
     * @return La instancia única de ExceptionHandler.
     */
    public static ExceptionHandler getInstance() {
        if (instance == null) {
            // Configuración de la cadena de manejo de excepciones
            ExcepcionHandlerInterface reverserHandler = new ReverserHandler(null);
            ExcepcionHandlerInterface haltCheckerHandler = new HaltCheckerHandler(reverserHandler);
            ExcepcionHandlerInterface cuentaAtrasHandler = new CuentaAtrasProcesoHandler(haltCheckerHandler);
            ExcepcionHandlerInterface cuentaInfinitaHandler = new CuentaInfinitaProcesoHandler(cuentaAtrasHandler);

            instance = new ExceptionHandler(cuentaInfinitaHandler);
        }
        return instance;
    }

    /**
     * Maneja la excepción especificada utilizando la cadena de responsabilidad.
     *
     * @param ex La excepción a manejar.
     */
    public void handleException(Exception ex) {
        firstHandler.handleException(ex);
    }
}
