package ChainOfResponsability;

import Modelo.Proceso;
import Vista.*;

public interface Handler {
    void handle(Proceso proceso, Vista vista) throws InterruptedException;
}