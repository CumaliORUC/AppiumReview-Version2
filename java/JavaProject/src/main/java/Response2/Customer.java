package Response2;

import java.util.HashMap;
import java.util.Map;

class Customer {
    private int customerNumber;
    private int pin;
    private Map<String, Account> accounts;

    public Customer(int customerNumber, int pin) {
        this.customerNumber = customerNumber;
        this.pin = pin;
        this.accounts = new HashMap<>();
        this.accounts.put("Checking", new CheckingAccount(1000.0));
        this.accounts.put("Savings", new SavingsAccount(500.0));
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPin() {
        return pin;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}