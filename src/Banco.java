import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        ContaBancaria contaOrigem = buscarConta(numeroContaOrigem);
        ContaBancaria contaDestino = buscarConta(numeroContaDestino);

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {  // Alterado para public
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        for (ContaBancaria conta : contas) {
            System.out.println("Número da Conta: " + conta.getNumeroConta() + ", Saldo: " + conta.getSaldo());
        }
    }
}
