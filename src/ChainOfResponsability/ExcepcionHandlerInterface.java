package ChainOfResponsability;


public interface ExcepcionHandlerInterface {
    void handleException(Exception ex);

    void setNextHandler(ExcepcionHandlerInterface nextHandler);

}