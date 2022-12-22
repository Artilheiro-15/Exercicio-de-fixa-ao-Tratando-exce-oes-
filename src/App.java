import excepitions.BusinessException;
import java.util.Scanner;
import javax.swing.event.AncestorEvent;
import model.entities.Account;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    //Fazer um programa para ler os dados de uma conta bancária e depois realizar um
    //saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
    //ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
    //saque da conta. Implemente a conta bancária conforme projeto abaixo:

    System.out.println("=====================");
    System.out.println("Insira os dados da conta: ");
    System.out.print("Numero: ");
    int number = sc.nextInt();
    System.out.print("Titular: ");
    sc.nextLine();
    String holder = sc.nextLine();
    System.out.print("Saldo inicial: ");
    double balance = sc.nextDouble();
    System.out.print("Limite de saque: ");
    double WithdrawLimit = sc.nextDouble();

    Account account = new Account(number, holder, balance, WithdrawLimit);

    System.out.println("**********************************************");
    System.out.println("**********************************************");

    System.out.print("Informe uma quantia para ser sacada: ");
    double amount = sc.nextDouble();

    //aki simplesmente vou chamar o withdraw se der alguma exceçao ela vai ser desparada pelo o proprio withdraw
    // traduçao da palavra (try) e tentar eu vou tentar execulta isso aki so que essa chamada pode lançar uma excesao
    //entao casso ela despara uma exceçao eu posso agora capiturar essa exceçao
    try {
      account.withdraw(amount);
      System.out.printf("Novo saldo: %.2f%n", account.getBalance());
    } catch (BusinessException e) { // eu vou vim aki e colocar um catch e o tipo da exceçao
      System.out.println(e.getMessage());
    }
    //olha como minha estrutura agora ela esta muito mais fulida eu nao tenho mais if else
    // eu simplesmente chamo oque tem que chamar e mostro na tela agr eu tenho um cod linear
    // faz oque voce tem que fazer linearmente se em algum ponto ali estourar uma exceçao eu pego ela no catch
    // essa aqui e uma boa engaria de softh para resolver tanto a delegaçao quanto a manutençao e codigo limpo
    System.out.println("==========FIM DO PROGRAMA===========");

    sc.close();
  }
}
