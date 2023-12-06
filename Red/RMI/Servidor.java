package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {

        System.out.println("Creando registro RMI...");

        try {
            Registry registry = LocateRegistry.createRegistry(1099);

            System.out.println("Enlazando métodos remotos Calculadora");
            registry.rebind("Calculadora", new CalculadoraRMI());
        } catch (RemoteException e) {
            System.err.println(e);
        }
    }
}
