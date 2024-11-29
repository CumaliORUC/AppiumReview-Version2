package Response1;

class Customer {
    private int customerNumber;
    private int pin;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;

    public Customer(int customerNumber, int pin, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        this.customerNumber = customerNumber;
        this.pin = pin;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPin() {
        return pin;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }
}