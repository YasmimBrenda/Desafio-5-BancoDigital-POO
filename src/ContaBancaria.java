public abstract class ContaBancaria {
    private String numeroConta;
    protected double saldo;

    public ContaBancaria(String numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}