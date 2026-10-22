package banksys;

public class Main {

    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("Test0");
        if (acc1 instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) acc1;
            System.out.println("Account Owner: " + sa.getOwnerName() + ".");
        }

        acc1.deposit(1000.125);
        System.out.println("_________________");

        acc1.deposit(0);
        System.out.println("_________________");

        acc1.deposit(-500);
        System.out.println("_________________");

        acc1.withdraw(500);
        System.out.println("_________________");

        acc1.withdraw(1500);
        System.out.println("_________________");

        acc1.withdraw(-100);
        System.out.println("_________________");

        acc1.freezeAccount();
        acc1.deposit(11500);
        System.out.println("_________________");

        acc1.withdraw(500);
        System.out.println("_________________");
        
        acc1.unfreezeAccount();
        acc1.withdraw(100);
    }

}
