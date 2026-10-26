package banksys;

/**
 * Savings bank account representation extending BankAccount.
 */
public class SavingsAccount extends BankAccount {

  /**
   * Constructs a SavingsAccount with owner name.
   *
   * @param ownerName the name of the owner
   */
  public SavingsAccount(String ownerName) {
    super(ownerName);
  }
}