public interface Proceso {
    void setNext(Proceso proceso);
    void execute(int cuenta);
}