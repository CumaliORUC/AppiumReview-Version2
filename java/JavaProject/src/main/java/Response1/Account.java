package Response1;

abstract class Account {
    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract void withdraw(double amount);
}