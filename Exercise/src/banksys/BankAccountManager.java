package banksys;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManager {

    Map<Integer, BankAccount> accounts;
    int id;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account) {
        if (accounts.size() >= 100) {
            System.out.println("The maximum limit of created accounts is 100");
            return;
        }

        accounts.put(this.id, account);
        System.out.println("Account added successfully with ID: " + this.id);
        this.id++;
    }

    public void listAccounts() {
       
    }
}
