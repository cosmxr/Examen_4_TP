package ChainOfResponsability;

public interface ExcepcionHandlerInterface {
    void setNextHandler(ExcepcionHandlerInterface nextHandler);
    void handleException(Exception exception);
}