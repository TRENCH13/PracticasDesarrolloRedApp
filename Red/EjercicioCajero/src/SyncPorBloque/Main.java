package SyncPorBloque;

public class Main {
    public static void main(String args[]) throws InterruptedException{
        Thread proceso1 = new Thread(new Subproceso(), "Subproceso 1");
        
        proceso1.start();
        synchronized (proceso1){
            proceso1.wait();
        }
        System.out.println("La espera ha finalizado");
    }
}