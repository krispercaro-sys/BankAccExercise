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

  private static void silentRun(Action action) {
    try {
      action.execute();
    } catch (Exception ignored) {
      // Suppress initial setup outputs
    }
  }

  /**
   * Main execution method.
   */
  public static void main(String[] args) {
    BankAccount acc1 = new SavingsAccount("Test0");
    //amount 1000.125 is from exercise 2
    silentRun(() -> acc1.deposit(1000.125));
    silentRun(() -> acc1.withdraw(500));

    System.out.println("============ EXERCISE 3 ============\n");
    // Test Case 1
    run(() -> {
      System.out.println("Amount deposited: -500.00");
      acc1.deposit(-500);
    });
    System.out.println("\n========================\n");
    // Test Case 2
    acc1.freezeAccount();
    run(() -> acc1.deposit(11500));
    System.out.println("\n========================\n");
    // Test Case 3
    acc1.unfreezeAccount();
    run(() -> {
      System.out.println("Amount withdrawn: -100.00");
      acc1.withdraw(-100);
    });
    System.out.println("\n========================\n");
    // Test Case 4
    run(() -> {
      System.out.println("Amount withdrawn: 1500.00");
      acc1.withdraw(1500);
    });
    System.out.printf("Current balance: %.2f%n", acc1.getBalance());
    System.out.println("\n========================\n");
    // Test Case 5
    acc1.freezeAccount();
    run(() -> acc1.withdraw(500));
    
    acc1.unfreezeAccount();
    acc1.getTransactionHistory().add(new Transaction("Withdraw", 100.0));
    System.out.println("\n========================\n");
    // Test Case 6:
    BankAccountManager accM1 = new BankAccountManager();
    System.out.println("Filtering transactions at or above 200...");
    List<Transaction> filtered = accM1.filterTransactionsAtOrAbove(
        200, acc1.getTransactionHistory()
    );
    System.out.println(filtered);
    System.out.println("\n========================\n");
    // Test Case 7
    System.out.println("Sorting transactions by amount...");
    List<Transaction> sorted = accM1.sortTransactionsByAmount(acc1.getTransactionHistory());
    System.out.println(sorted);
  }
}