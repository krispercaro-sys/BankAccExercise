package exception;

/**
 * Custom exception thrown when a withdrawal exceeds the available balance.
 */
public class InsufficientFundsException extends Exception {

  private String message;

  /**
   * Constructs an InsufficientFundsException with the specified error message.
   *
   * @param message detail message describing the exception
   */
  public InsufficientFundsException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}