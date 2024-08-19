import java.util.ArrayList;
import java.util.List;

public class Agencia {
  private String numero;
  private List<ContaEssencial> contasEssenciais = new ArrayList<>();
  private List<ContaRentavel> contasRentaveis = new ArrayList<>();
  private List<Tarifavel> contasTarifaveis = new ArrayList<>();

  public Agencia(String numero) {
    this.numero = numero;
  }

  public void addContaEssencial(ContaEssencial conta) {
    this.contasEssenciais.add(conta);
  }

  public void addContaRentavel(ContaRentavel conta) {
    this.contasRentaveis.add(conta);
  }

  public void addContaTarifavel(Tarifavel conta) {
    this.contasTarifaveis.add(conta);
  }

  public void saque(String numeroConta, double valor) throws ContaException {
    ContaEssencial conta = getConta(numeroConta);
    conta.saque(valor);
  }

  public void deposito(String numeroConta, double valor) throws ContaException {
    ContaEssencial conta = getConta(numeroConta);
    conta.deposito(valor);
  }

  public void atualizarRendimentoContas(Double taxa) {
    for (ContaRentavel contaRentavel : contasRentaveis) {
      contaRentavel.atualizarRendimento(taxa);
    }
  }

  public void cobrarTarifaContas(Double tarifa) throws ContaException{
    for(Tarifavel contaTarifavel : contasTarifaveis) {
      contaTarifavel.cobrarTarifa(tarifa);
    }
  }

  private ContaEssencial getConta(String numeroConta) throws ContaException {
    for (Tarifavel contaTarifavel : contasTarifaveis) {
      if (contaTarifavel.getNumeroConta().equals(numeroConta)) {
        return contaTarifavel;
      }
    }
    for (ContaRentavel contaRentavel : contasRentaveis) {
      if (contaRentavel.getNumeroConta().equals(numeroConta)) {
        return contaRentavel;
      }
    }
    for (ContaEssencial contaEssencial : contasEssenciais) {
      if (contaEssencial.getNumeroConta().equals(numeroConta)) {
        return contaEssencial;
      }
    }
    
    throw new ContaException("Numero da conta " + numeroConta + " não existe");
  }

}
