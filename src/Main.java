public class Main {
    public static void main(String[] args) {
        CuentaAtras cuentaAtras=new CuentaAtras();
        CuentaInfinita cuentaInfinita = new CuentaInfinita();
        Reverser reverser = new Reverser();
        reverser.execute(cuentaInfinita);

    }
}