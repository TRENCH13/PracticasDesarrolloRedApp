
import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 2; i++){
            try {
                System.out.println("Filósofo " + Thread.currentThread().getName() + " se prepara para comer.");
                Thread.sleep(1000);
                
                tomarTenedor();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private  void pensar(){
        try {
            System.out.println("Filósofo " + Thread.currentThread().getName() + " deja de comer.");
            Thread.sleep(1000);
            System.out.println("Filósofo " + Thread.currentThread().getName() + " está pensando.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private synchronized void tomarTenedor(){
        try {
            System.out.println("Filósofo " + Thread.currentThread().getName() + " toma el tenedor izquierdo.");
            Thread.sleep(1000);
            System.out.println("Filósofo " + Thread.currentThread().getName() + " toma el tenedor derecho.");
            Thread.sleep(1000);
            
            comer();
            Thread.sleep(1000);
            
            pensar();
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private  void comer(){
        System.out.println("Filósofo " + Thread.currentThread().getName() + " está comiendo.");
    }
}