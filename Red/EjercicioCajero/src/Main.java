public class Main {
    public static void main(String args[]){
        Cajero cajero = new Cajero();
        Thread usuario1 = new Thread(cajero, "Felipe");
        Thread usuario2 = new Thread(cajero, "Pedro");
        
        usuario1.start();
        usuario2.start();
    }
}