public class Main {
    public static void main(String args[]){
        Filosofo filosofos = new Filosofo();
        Thread filosofo1 = new Thread(filosofos, "1");
        Thread filosofo2 = new Thread(filosofos, "2");
        Thread filosofo3 = new Thread(filosofos, "3");
        Thread filosofo4 = new Thread(filosofos, "4");
        Thread filosofo5 = new Thread(filosofos, "5");
        
        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
        filosofo5.start();
    }
}