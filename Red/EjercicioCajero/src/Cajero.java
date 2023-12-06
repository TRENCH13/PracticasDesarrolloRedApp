
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cajero implements Runnable{
    Cuenta cuenta;
    
    public Cajero(){
        cuenta = new Cuenta();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                retirarDinero(10);
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private synchronized void retirarDinero(int valorRetiro){
        if(cuenta.getSaldoActual() >= valorRetiro){
            System.out.println("Saldo actual: " + cuenta.getSaldoActual());
            
            cuenta.retiroCuenta(valorRetiro);
            
            System.out.println("El usuario " + Thread.currentThread().getName() + " está retirando $" + valorRetiro);
            System.out.println("Retiro exitoso");
            System.out.println("Nuevo saldo: " + cuenta.getSaldoActual());
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
}