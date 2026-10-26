package exception;

/**
 * Custom exception thrown when an invalid deposit or withdrawal amount is provided.
 */
public class InvalidAmountException extends Exception {

  /** Holds the error message passed from the constructor. */
  private String message;

  /**
   * Constructs an InvalidAmountException with the specified error message.
   *
   * @param message the detail message describing the exception condition
   */
  public InvalidAmountException(String message) {
    super(message);
    this.message = message;
  }

  /**
   * Returns the detail message string of this exception.
   *
   * @return the detail message string
   */
  @Override
  public String getMessage() {
    return this.message;
  }
}