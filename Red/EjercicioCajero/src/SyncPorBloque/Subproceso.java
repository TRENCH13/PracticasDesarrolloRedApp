package SyncPorBloque;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Subproceso implements Runnable{

    @Override
    public void run() {
        System.out.println("Pulse ENTER para detener la espera de " + Thread.currentThread().getName());
        
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Subproceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized (this){
            this.notifyAll();
        }
    }
    
}