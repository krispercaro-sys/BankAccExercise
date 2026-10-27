package exception;

/**
 * Custom exception thrown when an invalid deposit or withdrawal amount is provided.
 */
public class InvalidAmountException extends Exception {

  /** Holds the error message passed from the constructor. */
  private String message;

  /**
   *.
   */
  public InvalidAmountException(String message) {
    super(message);
    this.message = message;
  }

  /**
   *.
   */
  @Override
  public String getMessage() {
    return this.message;
  }
}