package exception;

/**
 * Custom exception thrown when operations are performed on a frozen bank account.
 */
public class AccountFrozenException extends Exception {

  /** Holds the error message passed from the constructor. */
  private String message;

  /**
   *.
   */
  public AccountFrozenException(String message) {
    super(message);
    this.message = message;
  }

  /**
   * Returns the detail message string of this exception.
   */
  @Override
  public String getMessage() {
    return this.message;
  }
}