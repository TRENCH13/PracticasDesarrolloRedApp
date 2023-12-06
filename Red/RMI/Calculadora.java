package RMI;

public interface Calculadora extends java.rmi.Remote{
    public int div(int a, int b) throws java.rmi.RemoteException, ArithmeticException;
    public int mul(int a, int b) throws java.rmi.RemoteException;
    public int sum(int a, int b) throws java.rmi.RemoteException;
    public int res(int a, int b) throws java.rmi.RemoteException;
}
