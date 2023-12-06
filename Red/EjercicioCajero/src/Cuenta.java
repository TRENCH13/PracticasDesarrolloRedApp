public class Cuenta {
    private int saldoActual;
    
    public Cuenta(){
        saldoActual = 50;
    }
    
    public int getSaldoActual(){
        return saldoActual;
    }
    
    public void retiroCuenta(int valor){
        saldoActual -= valor;
    }
}