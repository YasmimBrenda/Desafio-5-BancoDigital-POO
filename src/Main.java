import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Listar Contas");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir newline

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta:");
                    String numeroContaCorrente = scanner.nextLine();
                    System.out.println("Digite o limite do cheque especial:");
                    double limiteChequeEspecial = scanner.nextDouble();
                    scanner.nextLine();  // Consumir newline

                    ContaCorrente contaCorrente = new ContaCorrente(numeroContaCorrente, limiteChequeEspecial);
                    banco.adicionarConta(contaCorrente);
                    System.out.println("Conta Corrente criada com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o número da conta:");
                    String numeroContaPoupanca = scanner.nextLine();
                    System.out.println("Digite a taxa de rendimento:");
                    double taxaRendimento = scanner.nextDouble();
                    scanner.nextLine();  // Consumir newline

                    ContaPoupanca contaPoupanca = new ContaPoupanca(numeroContaPoupanca, taxaRendimento);
                    banco.adicionarConta(contaPoupanca);
                    System.out.println("Conta Poupança criada com sucesso!");
                    break;

                case 3:
                    System.out.println("Digite o número da conta:");
                    String numeroContaDeposito = scanner.nextLine();
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();  // Consumir newline

                    ContaBancaria contaDeposito = banco.buscarConta(numeroContaDeposito);
                    if (contaDeposito != null) {
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da conta:");
                    String numeroContaSaque = scanner.nextLine();
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();  // Consumir newline

                    ContaBancaria contaSaque = banco.buscarConta(numeroContaSaque);
                    if (contaSaque != null) {
                        contaSaque.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o número da conta de origem:");
                    String numeroContaOrigem = scanner.nextLine();
                    System.out.println("Digite o número da conta de destino:");
                    String numeroContaDestino = scanner.nextLine();
                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();  // Consumir newline

                    banco.transferir(numeroContaOrigem, numeroContaDestino, valorTransferencia);
                    System.out.println("Transferência realizada com sucesso!");
                    break;

                case 6:
                    banco.listarContas();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
