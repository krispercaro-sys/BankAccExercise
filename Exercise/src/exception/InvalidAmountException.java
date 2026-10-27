package exception;

/**
 * exception thrown when an invalid deposit or withdrawal amount is provided.
 */
public class InvalidAmountException extends Exception {

  /** Holds the error message passed from the constructor. */
  private String message;

  /**
   * Exception for invalid amount.
   */
  public InvalidAmountException(String message) {
    super(message);
    this.message = message;
  }

  /**
   * Message.
   */
  @Override
  public String getMessage() {
    return this.message;
  }
}