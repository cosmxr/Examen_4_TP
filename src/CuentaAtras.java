public class CuentaAtras {
    public static void cuentaAtras(){
    int num = 10;
        while (num >= 0) {
        System.out.println(num);
        num--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
}
