package banksys;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with deposit, withdrawal, and status
 * management features.
 */
public class BankAccount {

  private String ownerName;
  private double balance;
  private boolean isFrozen;
  private List<Transaction> transactionHistory;

  /**
   * Constructs a BankAccount with the specified owner name.
   *
   * @param ownerName the name of the account owner
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

  public String getOwnerName() {
    return this.ownerName;
  }

  public double getBalance() {
    return this.balance;
  }

  /**
   * Deposits a specified amount into the account.
   *
   * @param amount the amount to deposit
   * @throws AccountFrozenException if the account is frozen
   * @throws InvalidAmountException if the deposit amount is less than
   *         or equal to zero
   */
  public void deposit(double amount)
      throws AccountFrozenException, InvalidAmountException {
    if (isFrozen()) {
      throw new AccountFrozenException(
          "Account is FROZEN. Unable to transact.");
    }

    if (amount <= 0) {
      throw new InvalidAmountException(
          "Invalid amount. Must be greater than 0");
    }

    System.out.println("Amount deposited: " + amount);
    this.balance += amount;
    this.transactionHistory.add(new Transaction("Deposit", amount));
    System.out.printf("Current balance: %.2f%n", this.balance);
  }

  /**
   * Withdraws a specified amount from the account.
   *
   * @param amount the amount to withdraw
   * @throws AccountFrozenException if the account is frozen
   * @throws InvalidAmountException if the withdrawal amount is less
   *         than or equal to zero
   * @throws InsufficientFundsException if the withdrawal amount
   *         exceeds balance
   */
  public void withdraw(double amount)
      throws AccountFrozenException, InvalidAmountException,
      InsufficientFundsException {
    if (isFrozen()) {
      throw new AccountFrozenException(
          "Account is FROZEN. Unable to transact.");
    }

    if (amount <= 0) {
      throw new InvalidAmountException(
          "Invalid amount. Must be greater than 0");
    }

    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient balance.");
    }

    System.out.println("Amount withdrawn: " + amount);
    this.balance -= amount;
    this.transactionHistory.add(new Transaction("Withdraw", amount));
    System.out.printf("Current balance: %.2f%n", this.balance);
  }

  public List<Transaction> getTransactionHistory() {
    return this.transactionHistory;
  }

  public void freezeAccount() {
    this.isFrozen = true;
  }

  public void unfreezeAccount() {
    this.isFrozen = false;
  }

  public boolean isFrozen() {
    return this.isFrozen;
  }
}
