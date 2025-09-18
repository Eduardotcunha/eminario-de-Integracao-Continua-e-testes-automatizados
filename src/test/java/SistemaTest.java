package org.exemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SistemaTest {
 private GerenciadoraClientes gerenciadoraClientes;
    private GerenciadoraContas gerenciadoraContas;
    private Cliente cliente;
    private ContaCorrente contacorrente;

    @BeforeEach
    void setUp() {
        gerenciadoraClientes = new GerenciadoraClientes();
        gerenciadoraContas = new GerenciadoraContas();
        cliente = new Cliente(1, "Carlos", 30);
        contacorrente = new ContaCorrente(101,cliente);
    }

    @Test
    void testAdicionarEBuscarCliente() {
        gerenciadoraClientes.adicionarCliente(cliente);
        assertEquals(cliente, gerenciadoraClientes.buscarCliente(1));
    }
    
    @Test
    void testeBuscarCliente() {
        gerenciadoraClientes.adicionarCliente(cliente);
        Cliente c = gerenciadoraClientes.buscarCliente(cliente.getId());
        assertEquals(cliente, c);

        }
    
    @Test 
     void testeBuscarClientePorNome(){
         gerenciadoraClientes.adicionarCliente(cliente);
         Cliente c  =gerenciadoraClientes.buscarClientePorNome(cliente.getNome());
         assertEquals(cliente, c);
    }
    
    @Test
    
    void testeRemoverClientePorNome(){
        gerenciadoraClientes.adicionarCliente(cliente);
        
        boolean clienteRemovido = gerenciadoraClientes.removerClientePorNome(cliente.getNome());
        
          assertTrue(clienteRemovido);
          
        Cliente clienteBuscadoAposRemocao = gerenciadoraClientes.buscarClientePorNome(cliente.getNome());
        
          assertNull(clienteBuscadoAposRemocao);
    }
    @Test
    void testeRemoverPorId(){
        gerenciadoraClientes.adicionarCliente(cliente);
        
        gerenciadoraClientes.removerClientePorId(cliente.getId());
        
        Cliente clienteBuscadoAposRemocaoId = gerenciadoraClientes.buscarCliente(cliente.getId());
        
        assertNull(clienteBuscadoAposRemocaoId);
    }
    
    @Test 
    void testeDepositar (){
        contacorrente.depositar(100);
        assertEquals(100, contacorrente.getSaldo());
    }
    
    @Test 
    void testeDepositarSacar (){
        contacorrente.depositar(100);
        assertEquals(100, contacorrente.getSaldo());
        contacorrente.sacar(60);
        assertEquals(40, contacorrente.getSaldo());
    }
    
    @Test
    void testeAdcionarContaEBuscarConta(){
        gerenciadoraContas.adicionarConta(contacorrente);
        assertEquals(contacorrente, gerenciadoraContas.buscarConta(101));
    }
    
}
