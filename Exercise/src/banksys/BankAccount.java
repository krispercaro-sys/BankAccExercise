package banksys;

public class BankAccount {

    private double balance;

    private boolean isFrozen;

    public BankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
    }

    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        System.out.println("Amount deposited: " + amount);

        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        this.balance += amount;
        System.out.printf("Current balance: %.2f%n", this.balance);
    }

    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        System.out.println("Amount withdrawn: " + amount);

        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        if (amount > balance) {
            System.out.printf("Insufficient balance. Current balance: %.2f%n", this.balance);
            return;
        }

        this.balance -= amount;
        System.out.printf("Current balance: %.2f%n", this.balance);
    }

    public double getBalance() {
        return this.balance;
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