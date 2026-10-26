package banksys;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages bank accounts, handling account storage, creation, and listing operations.
 */
public class BankAccountManager {

  private Map<Integer, BankAccount> accounts;
  private int id;

  /**
   * Constructs a new BankAccountManager with empty account storage.
   */
  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  /**
   * Adds a new bank account if the storage limit has not been reached.
   *
   * 
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
   * Displays all managed bank accounts and their details.
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
}