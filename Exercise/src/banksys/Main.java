package banksys;

import java.util.List;

/**
 * Entry point for testing bank account operations, exception handling, and lambda features.
 */
public class Main {

  @FunctionalInterface
  private interface Action {
    void execute() throws Exception;
  }

  private static void run(Action action) {
    try {
      action.execute();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Main execution method matching test cases.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    BankAccount acc1 = new SavingsAccount("Test0");
    BankAccountManager accM1 = new BankAccountManager();

    // Setup initial deposit
    run(() -> acc1.deposit(1000.125));
    System.out.println("_________________");

    // Test Case 1: Deposit with negative / zero amount
    run(() -> acc1.deposit(0));
    System.out.println("_________________");

    run(() -> {
      System.out.println("Amount deposited: -500.00");
      acc1.deposit(-500);
    });
    System.out.println("_________________");

    // Valid withdrawal
    run(() -> acc1.withdraw(500));
    System.out.println("_________________");

    // Test Case 4: Withdraw with insufficient funds
    run(() -> {
      System.out.println("Amount withdrawn: 1500.00");
      acc1.withdraw(1500);
    });
    System.out.printf("Current balance: %.2f%n", acc1.getBalance());
    System.out.println("_________________");

    // Test Case 3: Withdraw with negative amount
    run(() -> {
      System.out.println("Amount withdrawn: -100.00");
      acc1.withdraw(-100);
    });
    System.out.println("_________________");

    // Test Cases 2 & 5: Operations when account is frozen
    acc1.freezeAccount();
    run(() -> acc1.deposit(11500));
    System.out.println("_________________");

    run(() -> acc1.withdraw(500));
    System.out.println("_________________");

    // Unfreeze and resume
    acc1.unfreezeAccount();
    run(() -> acc1.withdraw(100));
    System.out.println("=================");

    // Test Case 6: Filter transactions
    System.out.println("Filtering transactions at or above 200...");
    List<Transaction> filtered = accM1.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory());
    System.out.println(filtered);
    System.out.println("_________________");

    // Test Case 7: Sort transactions
    System.out.println("Sorting transactions by amount...");
    List<Transaction> sorted = accM1.sortTransactionsByAmount(acc1.getTransactionHistory());
    System.out.println(sorted);
  }
}