package Response1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountProject {
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize existing customers
        customers.put(444206, new Customer(444206, 1001, new CheckingAccount(1, 1000), new SavingsAccount(2, 500)));
        customers.put(444207, new Customer(444207, 1002, new CheckingAccount(3, 2000), new SavingsAccount(4, 1000)));

        while (true) {
            System.out.println("Enter your customer number:");
            int customerNumber = getIntegerInput();
            System.out.println("Enter your PIN:");
            int pin = getIntegerInput();

            Customer customer = customers.get(customerNumber);
            if (customer != null && customer.getPin() == pin) {
                System.out.println("Login successful!");
                accountMenu(customer);
            } else {
                System.out.println("Invalid customer number or PIN. Please try again.");
            }
        }
    }

    private static void accountMenu(Customer customer) {
        while (true) {
            System.out.println("Select an account:");
            System.out.println("1. Checking Account");
            System.out.println("2. Savings Account");
            System.out.println("3. Exit");
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    accountOperations(customer.getCheckingAccount());
                    break;
                case 2:
                    accountOperations(customer.getSavingsAccount());
                    break;
                case 3:   System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void accountOperations(Account account) {
        while (true) {
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Select an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = getPositiveDoubleInput();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = getPositiveDoubleInput();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static int getIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private static double getPositiveDoubleInput() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Invalid input. Please enter a positive value.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }
}