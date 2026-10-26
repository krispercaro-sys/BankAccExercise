package banksys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Stores user transaction information.
 */
public class Transaction {

  private String type;
  private double amount;
  private LocalDateTime timestamp;

  /**
   * Initializes a new Transaction with type and amount.
   *
   * @param type the transaction type (e.g., Deposit, Withdraw)
   * @param amount the monetary value of the transaction
   */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timestamp = LocalDateTime.now();
  }

  public String getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return String.format(
        "Transaction [type=%s, amount=%s, time_stamp=%s]",
        type, amount, timestamp.format(formatter)
    );
  }
}