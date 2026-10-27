package banksys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Manages bank accounts and transaction filtering and sorting.
 */
public class BankAccountManager {

  private Map<Integer, BankAccount> accounts;
  private int id;

  /**
   * Initializes the account manager.
   */
  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  /**
   * Adds an account if the maximum limit is not reached.
   *
   * @param account the bank account to add
   */
  public void addAccount(BankAccount account) {
    if (accounts.size() >= 100) {
      System.out.println(
          "The maximum limit of created accounts is 100");
      return;
    }

    accounts.put(this.id, account);
    System.out.println(
        "Account added successfully with ID: " + this.id);
    this.id++;
  }

  /**
   * Displays all registered bank accounts.
   */
  public void listAccounts() {
    if (accounts.isEmpty()) {
      System.out.println("No bank accounts found.");
      return;
    }

    for (Map.Entry<Integer, BankAccount> entry
        : accounts.entrySet()) {
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
   * Filters transactions by a minimum amount.
   *
   * @param amount the minimum transaction amount
   * @param txList the list of transactions to filter
   * @return transactions with amounts greater than or equal to
   *         the specified amount
   */
  public List<Transaction> filterTransactionsAtOrAbove(
      double amount, List<Transaction> txList) {
    Predicate<Transaction> filterCondition =
        tx -> tx.getAmount() >= amount;

    return txList.stream()
        .filter(filterCondition)
        .collect(Collectors.toList());
  }

  /**
   * Sorts transactions by amount in ascending order.
   *
   * @param txList the list of transactions to sort
   * @return a new list of transactions sorted by amount
   */
  public List<Transaction> sortTransactionsByAmount(
      List<Transaction> txList) {
    List<Transaction> sortedList = new ArrayList<>(txList);
    sortedList.sort(
        (t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));

    return sortedList;
  }
}
