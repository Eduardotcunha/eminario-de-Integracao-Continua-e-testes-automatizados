package org.exemplo;

class ContaCorrente {
    private int numero;
    private double saldo;
    private Cliente titular;

    public ContaCorrente(int numero, Cliente titular) {
        this.numero = numero;
        this.saldo = 0.0;
        this.titular = titular;
    }
    
    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public Cliente getTitular() { return titular; }
    
    public void depositar(double valor) {
        saldo += valor;
    }
    
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "ContaCorrente{" + "numero=" + numero + ", saldo=" + saldo + ", titular=" + titular.getNome() + '}';
    }
}
