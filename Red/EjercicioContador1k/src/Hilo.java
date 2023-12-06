public class Hilo implements Runnable{
    public static void main(String args[]){
        Thread h1 = new Thread(new Hilo(), "Hilo 1");
        Thread h2 = new Thread(new Hilo(), "Hilo 2");
        
        h1.start();
        h2.start();
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Hilo 1")){
            for(int i = 1; i <= 1000; i++){
                System.out.println(Thread.currentThread().getName() + ": "+ i);
            }
        }
        
        if(Thread.currentThread().getName().equals("Hilo 2")){
            for(int i = 1000; i >= 1; i--){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}