package org.exemplo;
public class Main {
    public static void main(String[] args) {
        GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes();
        GerenciadoraContas gerenciadoraContas = new GerenciadoraContas();
        
        Cliente cliente1 = new Cliente(1, "Carlos", 30);
        Cliente cliente2 = new Cliente(2, "Ana", 17);

        gerenciadoraClientes.adicionarCliente(cliente1);
        gerenciadoraClientes.adicionarCliente(cliente2);
        
        ContaCorrente conta1 = new ContaCorrente(101, cliente1);
        ContaCorrente conta2 = new ContaCorrente(102, cliente2);
        
        gerenciadoraContas.adicionarConta(conta1);
        gerenciadoraContas.adicionarConta(conta2);
        
        conta1.depositar(500.0);
        conta1.sacar(200.0);
        
        System.out.println(conta1);
        System.out.println(conta2);
    }
}

