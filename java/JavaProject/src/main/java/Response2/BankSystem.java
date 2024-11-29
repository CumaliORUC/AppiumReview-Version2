package Response2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private static Map<Integer, Customer> customers;
    private static Scanner scanner;

    public static void main(String[] args) {
        customers = new HashMap<>();
        customers.put(444206, new Customer(444206, 1001));
        customers.put(444207, new Customer(444207, 1002));
        scanner = new Scanner(System.in);
        login();
    }

    private static void login() {
        System.out.print("Enter your customer number: ");
        String customerNumberStr = scanner.nextLine();
        int customerNumber;
        try {
            customerNumber = Integer.parseInt(customerNumberStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid customer number. Please enter a numeric value.");
            login();
            return;
        }

        System.out.print("Enter your PIN: ");
        String pinStr = scanner.nextLine();
        int pin;
        try {
            pin = Integer.parseInt(pinStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid PIN. Please enter a numeric value.");
            login();
            return;
        }

        Customer customer = customers.get(customerNumber);
        if (customer == null || customer.getPin() != pin) {
            System.out.println("Invalid customer number or PIN.");
            login();
            return;
        }

        System.out.println("Login successful!");
        accountMenu(customer);
    }

    private static void accountMenu(Customer customer) {
        System.out.println("Select an account:");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1:
                accountOperations(customer.getAccounts().get("Checking"));
                accountMenu(customer);
                break;
            case 2:
                accountOperations(customer.getAccounts().get("Savings"));
                accountMenu(customer);
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                accountMenu(customer);
        }
    }

    private static void accountOperations(Account account) {
        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Select an operation:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                if (depositAmount > 0) {
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                } else {
                    System.out.println("Invalid deposit amount. Please enter a positive value.");
                }
                accountOperations(account);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                if (withdrawalAmount > 0) {
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } else {
                    System.out.println("Invalid withdrawal amount. Please enter a positive value.");
                }
                accountOperations(account);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                accountOperations(account);
        }
    }
}