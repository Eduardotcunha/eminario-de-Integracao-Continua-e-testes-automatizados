package org.exemplo;
import java.util.ArrayList;
import java.util.List;


class GerenciadoraContas {
    private List<ContaCorrente> contas = new ArrayList<>();

    public void adicionarConta(ContaCorrente conta) {
        contas.add(conta);
    }

     public ContaCorrente buscarConta(int numero) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}



