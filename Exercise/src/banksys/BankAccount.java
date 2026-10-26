package banksys;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with deposit, withdrawal, and status management features.
 */
public class BankAccount {

  private String ownerName;
  private double balance;
  private boolean isFrozen;
  private List<Transaction> transactionHistory;

  /**
   * Constructs a BankAccount with the specified owner name.
   *
   * 
   */
  public BankAccount(String ownerName) {
    this.ownerName = ownerName;
    this.balance = 0.0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Constructs a BankAccount with a default owner name.
   */
  public BankAccount() {
    this("Unknown");
  }

  /**
   * Gets the owner name of the account.
   *
   * 
   */
  public String getOwnerName() {
    return this.ownerName;
  }

  /**
   * Gets the current balance of the account.
   *
   * 
   */
  public double getBalance() {
    return this.balance;
  }

  /**
   * Deposits a specified amount into the account.
   *
   * 
   */
  public void deposit(double amount) {
    if (isFrozen()) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }

    if (amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }

    System.out.println("Amount deposited: " + amount);
    this.balance += amount;
    this.transactionHistory.add(new Transaction("Deposit", amount));
    System.out.printf("Current balance: %.2f%n", this.balance);
  }

  /**
   * Withdraws a specified amount from the account.
   *
   * 
   */
  public void withdraw(double amount) {
    if (isFrozen()) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }

    if (amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }

    if (amount > balance) {
      System.out.printf("Insufficient balance. Current balance: %.2f%n", this.balance);
      return;
    }

    System.out.println("Amount withdrawn: " + amount);
    this.balance -= amount;
    this.transactionHistory.add(new Transaction("Withdraw", amount));
    System.out.printf("Current balance: %.2f%n", this.balance);
  }

  /**
   * Gets the transaction history of the account.
   *
   * 
   */
  public List<Transaction> getTransactionHistory() {
    return this.transactionHistory;
  }

  /**
   * Freezes the account to prevent further transactions.
   */
  public void freezeAccount() {
    this.isFrozen = true;
  }

  /**
   * Unfreezes the account to allow transactions.
   */
  public void unfreezeAccount() {
    this.isFrozen = false;
  }

  /**
   * Checks whether the account is currently frozen.
   *
   * 
   */
  public boolean isFrozen() {
    return this.isFrozen;
  }
}