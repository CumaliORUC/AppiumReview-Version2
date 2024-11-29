package Response1;

// Class for Checking Account
class CheckingAccount extends Account {
    public CheckingAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}