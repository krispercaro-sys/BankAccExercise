package banksys;

/**
 * Entry point for demonstrating bank operations and account management.
 */
public class Main {

  /**
   * Main execution method.
   *
   * 
   */
  public static void main(String[] args) {
    // Setup initial account from earlier operations
    BankAccount acc1 = new SavingsAccount("Test0");
    if (acc1 instanceof SavingsAccount) {
      SavingsAccount sa = (SavingsAccount) acc1;
      System.out.println("Account Owner: " + sa.getOwnerName() + ".");
    }

    acc1.deposit(1000.125);
    System.out.println("_________________");

    acc1.deposit(0);
    System.out.println("_________________");

    acc1.deposit(-500);
    System.out.println("_________________");

    acc1.withdraw(500);
    System.out.println("_________________");

    acc1.withdraw(1500);
    System.out.println("_________________");

    acc1.withdraw(-100);
    System.out.println("_________________");

    acc1.freezeAccount();
    acc1.deposit(11500);
    System.out.println("_________________");

    acc1.withdraw(500);
    System.out.println("_________________");

    acc1.unfreezeAccount();
    acc1.withdraw(100);
    System.out.println("=================");

    System.out.println("Transaction history: ");
    System.out.println(acc1.getTransactionHistory());
    System.out.println("_________________");

    BankAccountManager accM1 = new BankAccountManager();

    accM1.addAccount(acc1);

    accM1.addAccount(new SavingsAccount("Test1"));
    System.out.println("_________________");

    accM1.listAccounts();
  }
}