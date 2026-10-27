
package exception;

/**
 * Represents an exception thrown when a frozen bank account
 * is used for transactions.
 */
public class AccountFrozenException extends Exception {

  /** Holds the error message passed from the constructor. */
  private String message;

  /**
   * Creates an exception with the specified error message.
   *
   * @param message the error message describing the exception
   */
  public AccountFrozenException(String message) {
    super(message);
    this.message = message;
  }

  /**
   * Returns the detail message of this exception.
   *
   * @return the exception's error message
   */
  @Override
  public String getMessage() {
    return this.message;
  }
}
