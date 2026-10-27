package banksys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Manages bank accounts, handling storage, filtering, and sorting of transactions.
 */
public class BankAccountManager {

  private Map<Integer, BankAccount> accounts;
  private int id;

  /**
   *.
   */
  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  /**
   *.
   */
  public void addAccount(BankAccount account) {
    if (accounts.size() >= 100) {
      System.out.println("The maximum limit of created accounts is 100");
      return;
    }

    accounts.put(this.id, account);
    System.out.println("Account added successfully with ID: " + this.id);
    this.id++;
  }

  /**
   *.
   */
  public void listAccounts() {
    if (accounts.isEmpty()) {
      System.out.println("No bank accounts found.");
      return;
    }

    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      int accountId = entry.getKey();
      BankAccount account = entry.getValue();

      System.out.printf(
          "Account ID: %d, Account Name: %s, Balance: %.2f%n",
          accountId,
          account.getOwnerName(),
          account.getBalance()
      );
    }
  }

  /**
   *.
   */
  public List<Transaction> filterTransactionsAtOrAbove(double amount, List<Transaction> txList) {
    Predicate<Transaction> filterCondition = tx -> tx.getAmount() >= amount;
    return txList.stream()
        .filter(filterCondition)
        .collect(Collectors.toList());
  }

  /**
   *.
   */
  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    List<Transaction> sortedList = new ArrayList<>(txList);
    sortedList.sort((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    return sortedList;
  }
}