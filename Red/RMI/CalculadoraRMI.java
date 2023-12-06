package RMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraRMI extends UnicastRemoteObject implements Calculadora, Serializable{

    public CalculadoraRMI() throws RemoteException{};

    @Override
    public int div(int a, int b) throws RemoteException, ArithmeticException {
        System.out.println("Dividiendo "+a+" / "+b+" = "+(a/b));
        return a/b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        System.out.println("Multiplicando "+a+" * "+b+" = "+(a*b));
        return a*b;
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        System.out.println("Sumando "+a+" + "+b+" = "+(a+b));
        return a+b;
    }

    @Override
    public int res(int a, int b) throws RemoteException {
        System.out.println("Restando "+a+" - "+b+" = "+(a-b));
        return a-b;
    }
    
}
