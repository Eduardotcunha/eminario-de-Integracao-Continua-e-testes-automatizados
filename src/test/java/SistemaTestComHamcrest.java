package org.exemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class SistemaTestComHamcrest {
    private GerenciadoraClientes gerenciadoraClientes;
    private GerenciadoraContas gerenciadoraContas;
    private Cliente cliente;
    private ContaCorrente contacorrente;

    @BeforeEach
    void setUp() {
        gerenciadoraClientes = new GerenciadoraClientes();
        gerenciadoraContas = new GerenciadoraContas();
        
    }

    @Test
    void testAdicionarEBuscarCliente() {
        Cliente cliente = new Cliente(1, "Carlos", 30);
        gerenciadoraClientes.adicionarCliente(cliente);
        assertThat(gerenciadoraClientes.buscarCliente(1), is(cliente));
    }
    
    @Test
    void testeBuscarCliente(){
        Cliente cliente = new Cliente(1, "Carlos", 30);
        gerenciadoraClientes.adicionarCliente(cliente);
        Cliente c =gerenciadoraClientes.buscarCliente(cliente.getId());
        assertThat(c,is (cliente) );
        
    }
        
    @Test
    void testBuscarClientePorNome (){
        Cliente cliente = new Cliente(1, "Carlos", 30);
        gerenciadoraClientes.adicionarCliente(cliente);
        Cliente c = gerenciadoraClientes.buscarClientePorNome(cliente.getNome());
        assertThat(c,is (cliente));
    }
    
    @Test
    void testaRemoverClientePorNome(){
        Cliente cliente = new Cliente(1, "Carlos", 30);
        
        gerenciadoraClientes.adicionarCliente(cliente);
        
        gerenciadoraClientes.removerClientePorNome(cliente.getNome());
        
        Cliente c =gerenciadoraClientes.buscarCliente(cliente.getId());
        
        assertThat(c,nullValue());
    }
    
    @Test
    void testeRemoverPorId(){
        Cliente cliente = new Cliente(1, "Carlos", 30);
        gerenciadoraClientes.adicionarCliente(cliente);
        gerenciadoraClientes.removerClientePorId(cliente.getId());
        Cliente c = gerenciadoraClientes.buscarCliente(1);
        assertThat(c,nullValue());
    }
    
    @Test
    void testeDepositarSacar (){
        cliente = new Cliente(1, "Carlos", 30);
        contacorrente = new ContaCorrente(101,cliente);
        contacorrente.depositar(100);
        assertThat(contacorrente.getSaldo(),is (100.0));
        contacorrente.sacar(60);
        assertThat(contacorrente.getSaldo(),is (40.0));
    }
    
    @Test
    void testAdcionarBuscarConta(){
       cliente = new Cliente(1, "Carlos", 30);
       contacorrente = new ContaCorrente(101,cliente);
       gerenciadoraContas.adicionarConta(contacorrente);
       ContaCorrente c =gerenciadoraContas.buscarConta(101);
        assertThat(c,equalTo(contacorrente) );
       
    }
}