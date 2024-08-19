public class ContaPoupanca implements ContaRentavel {

    private Agencia agencia;
    private String numeroConta;
    protected double saldo;

    public ContaPoupanca(Agencia agencia, String numeroConta, double saldo) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    @Override
    public void saque(Double valor) throws ContaException {
        if (valor > 0) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
            } else {
                throw new ContaException("Conta sem saldo suficiente: " + this.saldo);
            }
        } else {
            throw new ContaException("Valor inválido para saque " + valor);
        }
    }

    @Override
    public void deposito(Double valor) throws ContaException {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new ContaException("Valor inválido para depósito " + valor);
        }
    }

    @Override
    public void atualizarRendimento(Double taxaRendimento) {
        this.saldo += (this.saldo * taxaRendimento);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

}
